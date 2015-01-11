package org.mdo.tools.game.teso.alchemy.rest;

import com.google.common.base.Strings;
import org.mdo.tools.game.teso.alchemy.services.RecipeServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * @author MDO
 * @since 04/01/2015
 */
@RestController
@RequestMapping(value = "recipes")
public class RecipeServicesRest {

    @Autowired
    private RecipeServices services;

    @RequestMapping(method = RequestMethod.GET, value = "available/ingredients")
    @ResponseBody
    @Cacheable(value = "restCache")
    public List<Recipe> getRecipes(@RequestParam(value = "ref1") final String ingredient1,
                                   @RequestParam(value = "ref2", required = false, defaultValue = "") final String ingredient2) {
        final LinkedList<String> ingredientsRef = new LinkedList<>();
        ingredientsRef.add(ingredient1);
        if (!Strings.nullToEmpty(ingredient2).equals("")) {
            ingredientsRef.add(ingredient2);
        }
        return services.getAvailableRecipesForIngredients(ingredientsRef);
    }

}
