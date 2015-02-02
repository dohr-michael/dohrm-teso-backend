package org.mdo.tools.game.teso.alchemy.services.impl;

import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.mdo.tools.game.teso.alchemy.persistence.repository.IngredientRepository;
import org.mdo.tools.game.teso.alchemy.services.ResourcesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MDO
 * @since 16/01/2015
 */
@Service
public class ResourcesServicesImpl implements ResourcesServices {

    @Autowired
    private IngredientRepository repository;

    @Override
    public Map<String, String> getIngredientImages() {
        final List<IngredientEntity> all = repository.findAll();
        final Map<String, String> result = new HashMap<>();
        all.forEach(item -> {
            if (item != null) {
                result.put(item.getRef(), item.getImage());
            }
        });
        return result;
    }
}
