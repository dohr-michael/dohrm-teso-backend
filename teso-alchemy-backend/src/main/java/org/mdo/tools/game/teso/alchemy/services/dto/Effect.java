package org.mdo.tools.game.teso.alchemy.services.dto;

import java.util.*;

/**
 * @author MDO
 * @since 02/01/2015
 */
public class Effect {
    private String ref;
    private final Map<Locale, String> name = new HashMap<>();
    private final List<Ingredient> ingredients = new LinkedList<>();

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Map<Locale, String> getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
