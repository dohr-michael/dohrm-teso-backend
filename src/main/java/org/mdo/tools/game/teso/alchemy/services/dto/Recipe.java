package org.mdo.tools.game.teso.alchemy.services.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
public class Recipe {
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Effect> effects = new ArrayList<>();

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Effect> getEffects() {
        return effects;
    }
}
