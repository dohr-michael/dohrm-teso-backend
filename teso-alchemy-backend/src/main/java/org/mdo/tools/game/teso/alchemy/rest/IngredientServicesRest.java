package org.mdo.tools.game.teso.alchemy.rest;

import org.mdo.tools.game.teso.alchemy.services.IngredientServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
@RestController
@RequestMapping("ingredients")
public class IngredientServicesRest {

    @Autowired
    private IngredientServices services;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Ingredient> getAll() {
        services.getIngredients("BLUE_ENTOLOMA", "DRAGONTHORN");
        return services.getAll();
    }

}
