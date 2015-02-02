package org.mdo.tools.game.teso.alchemy.services;

import java.util.Map;

/**
 * @author MDO
 * @since 16/01/2015
 */
public interface ResourcesServices {

    /**
     * Returns all images of ingredients as Base64 image.
     *
     * @return association ingredient ref / image.
     */
    Map<String, String> getIngredientImages();

}
