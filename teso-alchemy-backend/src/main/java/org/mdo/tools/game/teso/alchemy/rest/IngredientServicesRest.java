package org.mdo.tools.game.teso.alchemy.rest;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.services.IngredientServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Returns all ingredients.
     *
     * @return list of ingredients.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = "restCache")
    public List<Ingredient> getAll() {
        return services.getAll();
    }

    /**
     * Returns the details of a specifics ingredient passed in parameters.
     *
     * @param ref the ref.
     * @return details of the ingredients.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{ref}")
    @ResponseBody
    @Cacheable(value = "restCache")
    public Ingredient getDetails(@PathVariable(value = "ref") final String ref) {
        return services.getDetails(ref);
    }

    /**
     * Returns all ingredients compatible with the union of ingredients passed in parameters.
     *
     * @param ref1 ref1
     * @param ref2 ref2
     * @return the list of ingredients.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/compatibles")
    @ResponseBody
    @Cacheable(value = "restCache")
    public List<Ingredient> getCompatibles(@RequestParam(value = "ref1") final String ref1,
                                           @RequestParam(value = "ref2", required = false, defaultValue = "") final String ref2) {
        if (Strings.nullToEmpty(ref2).equals("")) {
            return services.getCompatiblesIngredients(Lists.newArrayList(ref1));
        } else {
            return services.getCompatiblesIngredients(Lists.newArrayList(ref1, ref2));
        }
    }

}
