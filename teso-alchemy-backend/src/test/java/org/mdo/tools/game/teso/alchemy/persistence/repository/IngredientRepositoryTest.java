package org.mdo.tools.game.teso.alchemy.persistence.repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdo.tools.game.teso.alchemy.Application;
import org.mdo.tools.game.teso.alchemy.persistence.domain.EffectEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author MDO
 * @since 01/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository repository;

    @Test
    public void testFindAll() {
        final List<IngredientEntity> all = repository.findAll();
        assertEquals(18, all.size());
        final Optional<IngredientEntity> item = all
                .stream()
                .filter(effect -> effect.getRef().equals("BLUE_ENTOLOMA"))
                .findFirst();
        assertTrue(item.isPresent());
        check(item.get(), "BLUE_ENTOLOMA", "INVISIBILITY", "LOWER_SPELL_POWER", "RAVAGE_MAGICKA", "RESTORE_HEALTH");
    }

    @Test
    public void testFindAllFilter() {
        check(repository.findAll(Lists.newArrayList("BLUE_ENTOLOMA", "BUGLOSS")), "BLUE_ENTOLOMA", "BUGLOSS");
    }

    @Test
    public void testFindOne() {
        final IngredientEntity empty = repository.findOne("TOTO");
        assertNull(empty);

        check(repository.findOne("BLUE_ENTOLOMA"), "BLUE_ENTOLOMA", "INVISIBILITY", "LOWER_SPELL_POWER", "RAVAGE_MAGICKA", "RESTORE_HEALTH");
    }

    @Test
    public void testFindCompatibleIngredients() {
        final List<IngredientEntity> empty = repository.findCompatibleIngredients(Lists.newArrayList());
        assertNotNull(empty);
        assertEquals(0, empty.size());
        final List<IngredientEntity> oneIngredient = repository.findCompatibleIngredients(Lists.newArrayList("BLUE_ENTOLOMA"));
        check(oneIngredient, "BUGLOSS", "COLUMBINE", "EMETIC_RUSSULA", "LUMINOUS_RUSSULA", "MOUNTAIN_FLOWER", "NAMIRA_S_ROT", "NIRNROOT", "VIOLET_COPRINUS", "WATER_HYACINTH", "WHITE_CAP");
        final List<IngredientEntity> twoIngredients = repository.findCompatibleIngredients(Lists.newArrayList("BLUE_ENTOLOMA", "NAMIRA_S_ROT"));
        check(twoIngredients, "BLESSED_THISTLE", "BUGLOSS", "COLUMBINE", "EMETIC_RUSSULA", "LADY_S_SMOCK", "LUMINOUS_RUSSULA", "MOUNTAIN_FLOWER", "NIRNROOT", "VIOLET_COPRINUS", "WATER_HYACINTH", "WHITE_CAP", "WORMWOOD");
    }

    private void check(List<IngredientEntity> ingredients, String... excepts) {
        assertEquals(excepts.length, ingredients.size());
        for (String except : excepts) {
            assertEquals(1L, ingredients.stream().filter(ingredient -> except.equals(ingredient.getRef())).count());
        }
        for (IngredientEntity ingredient : ingredients) {
            final IngredientEntity base = repository.findOne(ingredient.getRef());
            assertEquals(base.getEffects().size(), ingredient.getEffects().size());
            // Union to check is same.
            final Sets.SetView<EffectEntity> union = Sets.union(Sets.newHashSet(ingredient.getEffects()), Sets.newHashSet(base.getEffects()));
            assertEquals(4, union.size());
        }
    }

    private void check(IngredientEntity entity, String ref, String... excepts) {
        assertEquals(ref, entity.getRef());
        final List<EffectEntity> ingredients = entity.getEffects();
        assertEquals(excepts.length, ingredients.size());
        for (String except : excepts) {
            assertEquals(1L, ingredients.stream().filter(ingredient -> except.equals(ingredient.getRef())).count());
        }
    }
}
