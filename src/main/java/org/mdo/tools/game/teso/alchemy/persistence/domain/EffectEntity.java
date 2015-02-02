package org.mdo.tools.game.teso.alchemy.persistence.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author MDO
 * @since 31/12/2014
 */
@Entity
@Table(name = "EFFECT")
public class EffectEntity {
    @Id
    @Column(name = "REF")
    private String ref;

    @ManyToMany
    @JoinTable(name = "INGR_EFFECT_LINK",
            joinColumns = {@JoinColumn(name = "EFFECT_REF", referencedColumnName = "REF")},
            inverseJoinColumns = {@JoinColumn(name = "INGRE_REF", referencedColumnName = "REF")})
    private List<IngredientEntity> ingredients;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EffectEntity that = (EffectEntity) o;

        if (ref != null ? !ref.equals(that.ref) : that.ref != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ref != null ? ref.hashCode() : 0;
    }
}
