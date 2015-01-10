package org.mdo.tools.game.teso.alchemy.rest;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.services.RecipeServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author MDO
 * @since 04/01/2015
 */
@RestController
@RequestMapping(value = "recipe")
public class RecipeServicesRest {

    @Autowired
    private RecipeServices services;

    @RequestMapping(method = RequestMethod.GET, value = "ingredients")
    @ResponseBody
    @Cacheable(value = "restCache")
    public Recipe getRecipe(@RequestParam(value = "ref1") final String ingredient1,
                            @RequestParam(value = "ref2") final String ingredient2,
                            @RequestParam(value = "ref3", required = false, defaultValue = "") final String ingredient3) {
        if (Strings.nullToEmpty(ingredient3).equals("")) {
            return services.getRecipeFromIngredients(Lists.newArrayList(ingredient1, ingredient2));
        } else {
            return services.getRecipeFromIngredients(Lists.newArrayList(ingredient1, ingredient2, ingredient3));
        }
    }

}
