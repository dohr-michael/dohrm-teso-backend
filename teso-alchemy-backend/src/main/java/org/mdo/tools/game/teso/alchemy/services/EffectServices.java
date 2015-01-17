package org.mdo.tools.game.teso.alchemy.services;

import org.mdo.tools.game.teso.alchemy.services.dto.Effect;

import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
public interface EffectServices {

    /**
     * Returns all effects.
     *
     * @return list of effects.
     */
    List<Effect> getAll();

    /**
     * Returns all effects passed in parameters.
     *
     * @param effects effects to finds
     * @return list of effects.
     */
    List<Effect> getAll(List<String> effects);

    /**
     * Returns the details of an effect.
     *
     * @param effectRef effect to find.
     * @return the effect
     */
    Effect getDetails(String effectRef);
}
