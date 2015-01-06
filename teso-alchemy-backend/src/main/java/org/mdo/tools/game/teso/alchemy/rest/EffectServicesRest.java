package org.mdo.tools.game.teso.alchemy.rest;

import org.mdo.tools.game.teso.alchemy.services.EffectServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Effect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MDO
 * @since 01/01/2015
 */
@RestController
@RequestMapping("effects")
public class EffectServicesRest {

    @Autowired
    private EffectServices services;

    /**
     * Returns all effects.
     *
     * @return list of effects.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Effect> getAll() {
        return services.getAll();
    }

    /**
     * Returns the details of a specifics effect passed in parameters.
     *
     * @param ref the ref.
     * @return details of the effect.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{ref}")
    @ResponseBody
    public Effect getDetails(@PathVariable(value = "ref") final String ref) {
        return services.getDetails(ref);
    }

}
