package org.mdo.tools.game.teso.alchemy.persistence.repository;

import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;

import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
public interface IngredientRepositoryCustom {

    /**
     * Find all all compatible ingredients passed in parameters.
     *
     * @param ingredients list of ingredients to check
     * @return compatible ingredients.
     */
    List<IngredientEntity> findCompatibleIngredients(List<String> ingredients);
}
