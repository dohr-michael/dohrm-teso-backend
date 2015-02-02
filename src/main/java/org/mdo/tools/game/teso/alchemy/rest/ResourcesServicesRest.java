package org.mdo.tools.game.teso.alchemy.rest;

import org.mdo.tools.game.teso.alchemy.services.ResourcesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MDO
 * @since 16/01/2015
 */
@RestController
@RequestMapping("resources")
public class ResourcesServicesRest {

    @Autowired
    private ResourcesServices resourcesServices;

    @RequestMapping(value = "images/ingredients", method = RequestMethod.GET)
    public Map<String, String> getIngredientImages() {
        return resourcesServices.getIngredientImages();
    }
}
