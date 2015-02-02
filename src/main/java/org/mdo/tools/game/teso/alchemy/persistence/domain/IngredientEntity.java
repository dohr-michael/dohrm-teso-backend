package org.mdo.tools.game.teso.alchemy.persistence.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MDO
 * @since 31/12/2014
 */
@Entity
@Table(name = "INGREDIENT")
public class IngredientEntity {
    @Id
    @Column(name = "REF")
    private String ref;
    @Lob
    // TO FIX an error into Hibernate Lob -> Long
    @Type(type = "text")
    @Column(name = "IMAGE")
    private String image;
    @ManyToMany
    @JoinTable(name = "INGR_EFFECT_LINK",
            joinColumns = {@JoinColumn(name = "INGRE_REF", referencedColumnName = "REF")},
            inverseJoinColumns = {@JoinColumn(name = "EFFECT_REF", referencedColumnName = "REF")})
    private List<EffectEntity> effects = new ArrayList<>();

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setEffects(List<EffectEntity> effects) {
        this.effects = effects;
    }

    public List<EffectEntity> getEffects() {
        return effects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientEntity that = (IngredientEntity) o;

        if (ref != null ? !ref.equals(that.ref) : that.ref != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ref != null ? ref.hashCode() : 0;
    }
}
