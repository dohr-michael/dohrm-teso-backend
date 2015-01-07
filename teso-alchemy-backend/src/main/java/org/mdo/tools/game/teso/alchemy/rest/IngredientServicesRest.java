package org.mdo.tools.game.teso.alchemy.rest;

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
     * Returns all ingredients compatible with ingredients passed in parameters.
     *
     * @param ref reference of ingredient to check.
     * @return list of ingredients.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{ref}/compatibles")
    @ResponseBody
    @Cacheable(value = "restCache")
    public List<Ingredient> getCompatibles(@PathVariable(value = "ref") final String ref) {
        return services.getCompatiblesIngredients(Lists.newArrayList(ref));
    }

    /**
     * Returns all ingredients compatible with the union of ingredients passed in parameters.
     *
     * @param ref1 ref1
     * @param ref2 ref2
     * @return the list of ingredients.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{ref1}/{ref2}/compatibles")
    @ResponseBody
    @Cacheable(value = "restCache")
    public List<Ingredient> getCompatibles(@PathVariable(value = "ref1") final String ref1,
                                           @PathVariable(value = "ref2") final String ref2) {
        return services.getCompatiblesIngredients(Lists.newArrayList(ref1, ref2));
    }

}
