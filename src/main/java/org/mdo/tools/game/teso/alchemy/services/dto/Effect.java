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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Effect effect = (Effect) o;

        if (ref != null ? !ref.equals(effect.ref) : effect.ref != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ref != null ? ref.hashCode() : 0;
    }
}
