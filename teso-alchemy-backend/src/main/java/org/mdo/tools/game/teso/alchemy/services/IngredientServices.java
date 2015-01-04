package org.mdo.tools.game.teso.alchemy.services;

import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;

import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
public interface IngredientServices {

    /**
     * Returns the complete list of ingredients available.
     *
     * @return the list of ingredients.
     */
    List<Ingredient> getAll();

    /**
     * Returns the details of a specifics ingredient.
     *
     * @param ingredientRef the ingredient to check
     * @return
     */
    Ingredient getDetails(final String ingredientRef);

    /**
     * Returns the list of ingredient compatible with ingredient passed in parameter.
     *
     * @param ingredientsRef list of ingredient to check
     * @return the list of ingredient compatible with selected.
     */
    List<Ingredient> getIngredients(final String... ingredientsRef);

}
