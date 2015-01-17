package org.mdo.tools.game.teso.alchemy.services.dto;

import java.util.*;

/**
 * @author MDO
 * @since 02/01/2015
 */
public class Ingredient {
    private String ref;
    private final Map<Locale, String> name = new HashMap<>();
    private final List<Effect> effects = new ArrayList<>();

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Map<Locale, String> getName() {
        return name;
    }

    public List<Effect> getEffects() {
        return effects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingredient that = (Ingredient) o;

        if (ref != null ? !ref.equals(that.ref) : that.ref != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ref != null ? ref.hashCode() : 0;
    }
}
