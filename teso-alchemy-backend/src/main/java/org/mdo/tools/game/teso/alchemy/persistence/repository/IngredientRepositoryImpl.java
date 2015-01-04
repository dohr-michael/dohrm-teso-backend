package org.mdo.tools.game.teso.alchemy.persistence.repository;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.persistence.domain.EffectEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MDO
 * @since 02/01/2015
 */
@Component
public class IngredientRepositoryImpl implements IngredientRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private JdbcTemplate template;

    @Override
    public List<IngredientEntity> findCompatibleIngredients(List<String> ingredients) {
        if (ingredients == null || ingredients.size() == 0) {
            return new ArrayList<>();
        }
        final String ingredientsAsString = Joiner.on(",").join(Lists.transform(ingredients, t -> "'" + t + "'"));
        return template.query("SELECT ingredientEntity.ref AS ingredientRef," +
                        "        effectEntity.ref AS effectRef," +
                        "        ingredientEntity.image AS ingredientImage" +
                        " FROM ingredient ingredientEntity" +
                        "   LEFT OUTER JOIN ingr_effect_link linkIngredientEffect ON ingredientEntity.ref=linkIngredientEffect.ingre_ref" +
                        "   LEFT OUTER JOIN effect effectEntity ON linkIngredientEffect.effect_ref=effectEntity.ref" +
                        " WHERE ingredientEntity.ref IN (" +
                        "   SELECT DISTINCT ingre_ref " +
                        "   FROM ingr_effect_link " +
                        "   WHERE effect_ref IN (SELECT DISTINCT effect_ref" +
                        "                        FROM ingr_effect_link " +
                        "                        WHERE ingre_ref IN (" + ingredientsAsString + "))" +
                        "   AND ingre_ref NOT IN (" + ingredientsAsString + ")" +
                        ")",
                (rs) -> {
                    final List<IngredientEntity> result = new ArrayList<>();
                    final Map<String, IngredientEntity> cache = new HashMap<>();
                    while (rs.next()) {
                        final IngredientEntity current;
                        if (cache.containsKey(rs.getString("ingredientRef"))) {
                            current = cache.get(rs.getString("ingredientRef"));
                        } else {
                            current = new IngredientEntity();
                            current.setRef(rs.getString("ingredientRef"));
                            current.setImage(rs.getString("ingredientImage"));
                            cache.put(current.getRef(), current);
                            result.add(current);
                        }
                        final EffectEntity effectEntity = new EffectEntity();
                        effectEntity.setRef(rs.getString("effectRef"));
                        current.getEffects().add(effectEntity);
                    }
                    return result;
                });
    }
}
