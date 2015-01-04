package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.persistence.repository.IngredientRepository;
import org.mdo.tools.game.teso.alchemy.persistence.repository.TranslationRepository;
import org.mdo.tools.game.teso.alchemy.services.IngredientServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;
import org.mdo.tools.game.teso.alchemy.services.impl.function.IngredientFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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
    public Ingredient getDetails(String ingredientRef) {
        return new IngredientFunction(translationRepository.findAll()).apply(repository.findOne(ingredientRef));
    }

    @Override
    public List<Ingredient> getIngredients(String... ingredientsRef) {
        // TODO
        repository.findCompatibleIngredients(Arrays.asList(ingredientsRef));
        return null;
    }

}
