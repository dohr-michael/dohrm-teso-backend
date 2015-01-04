package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.mdo.tools.game.teso.alchemy.persistence.domain.EffectEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.mdo.tools.game.teso.alchemy.persistence.repository.IngredientRepository;
import org.mdo.tools.game.teso.alchemy.persistence.repository.TranslationRepository;
import org.mdo.tools.game.teso.alchemy.services.IngredientServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;
import org.mdo.tools.game.teso.alchemy.services.impl.function.IngredientFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author MDO
 * @since 02/01/2015
 */
@Service
public class IngredientServicesImpl implements IngredientServices {

    @Autowired
    private IngredientRepository repository;

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public List<Ingredient> getAll() {
        return Lists.transform(repository.findAll(), new IngredientFunction(translationRepository.findAll()));
    }

    @Override
    public Ingredient getDetails(final String ingredientRef) {
        return new IngredientFunction(translationRepository.findAll()).apply(repository.findOne(ingredientRef));
    }

    @Override
    public List<Ingredient> getCompatiblesIngredients(final List<String> ingredientsRef) {
        final List<IngredientEntity> compatibleIngredients = repository.findCompatibleIngredients(ingredientsRef);
        final List<IngredientEntity> resultList;
        if (ingredientsRef.size() > 1) {
            final List<IngredientEntity> passedInParameters = repository.findAll(ingredientsRef);
            Set<EffectEntity> tmp = Sets.newHashSet();
            for (IngredientEntity passedInParameter : passedInParameters) {
                final HashSet<EffectEntity> set = Sets.newHashSet(passedInParameter.getEffects());
                tmp = Sets.union(Sets.difference(tmp, set),
                        Sets.difference(set, tmp));
            }
            final Set<EffectEntity> effects = Sets.newHashSet(tmp);
            resultList = Lists.newArrayList(
                    Iterables.filter(compatibleIngredients, e -> {
                        boolean find = false;
                        int i = -1;
                        while (!find && ++i < e.getEffects().size()) {
                            find = effects.contains(e.getEffects().get(i));
                        }
                        return find;
                    }));
        } else {
            resultList = compatibleIngredients;
        }
        return Lists.transform(resultList,
                new IngredientFunction(translationRepository.findAll()));
    }

}
