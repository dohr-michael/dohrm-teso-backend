package org.mdo.tools.game.teso.alchemy.services;

import org.mdo.tools.game.teso.alchemy.services.dto.Recipe;

import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
public interface RecipeServices {

    /**
     * Returns the recipe based to ingredients passed in parameters.
     *
     * @param ingredientsRef ingredients to check.
     * @return the associated recipe.
     */
    Recipe getRecipeFromIngredients(List<String> ingredientsRef);

    /**
     * Returns the list of recipes with effects passed in parameter.
     *
     * @param effectList effects to find.
     * @return the recipes.
     */
    List<Recipe> getRecipesFromEffects(String... effectList);
}
