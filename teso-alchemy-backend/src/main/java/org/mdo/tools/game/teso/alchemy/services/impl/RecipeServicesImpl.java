package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Sets;
import org.mdo.tools.game.teso.alchemy.services.IngredientServices;
import org.mdo.tools.game.teso.alchemy.services.RecipeServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Effect;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;
import org.mdo.tools.game.teso.alchemy.services.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author MDO
 * @since 04/01/2015
 */
@Service
public class RecipeServicesImpl implements RecipeServices {

    @Autowired
    private IngredientServices ingredientServices;

    @Override
    public List<Recipe> getAvailableRecipesForIngredients(List<String> ingredientsRef) {
        final List<Recipe> result = new LinkedList<>();
        if (ingredientsRef != null && !ingredientsRef.isEmpty()) {
            final List<Ingredient> ingredients = ingredientServices.getAll(ingredientsRef);
            final List<Ingredient> compatiblesIngredients = ingredientServices.getCompatiblesIngredients(ingredientsRef);
            for (Ingredient compatiblesIngredient : compatiblesIngredients) {
                final LinkedList<Ingredient> tmp = new LinkedList<>();
                tmp.addAll(ingredients);
                tmp.add(compatiblesIngredient);
                result.add(constructRecipeFromIngredients(tmp));
            }

        }
        return result;
    }

    @Override
    public List<Recipe> getRecipesFromEffects(String... effectList) {
        // TODO
        return null;
    }

    @Override
    public Recipe getRecipeFromIngredients(List<String> ingredientsRef) {
        final List<Ingredient> ingredients = ingredientServices.getAll(ingredientsRef);
        if (ingredients != null && ingredients.size() > 1) {
            return constructRecipeFromIngredients(ingredients);
        }
        return null;
    }


    //----------------------------------------------------------------------------
    //
    // Internal
    //
    //----------------------------------------------------------------------------

    Recipe constructRecipeFromIngredients(final List<Ingredient> ingredients) {
        final Recipe result = new Recipe();
        result.getIngredients().addAll(ingredients);
        final Set<Effect> resultAsSet = new HashSet<>();
        for (int i = 0; i < ingredients.size(); ++i) {
            final List<Effect> effects1 = ingredients.get(i).getEffects();
            for (int j = i + 1; j < ingredients.size(); ++j) {
                final List<Effect> effects2 = ingredients.get(j).getEffects();
                resultAsSet.addAll(Sets.
                        intersection(Sets.newHashSet(effects1), Sets.newHashSet(effects2)));
            }
        }
        result.getEffects().addAll(resultAsSet);
        return result;
    }

}
