package org.mdo.tools.game.teso.alchemy.persistence.repository;

import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author MDO
 * @since 01/01/2015
 */
public interface IngredientRepository extends JpaRepository<IngredientEntity, String>, IngredientRepositoryCustom {

    @Override
    @Query(value = "SELECT e FROM IngredientEntity e LEFT JOIN FETCH e.effects WHERE e.ref=:ref")
    IngredientEntity findOne(@Param("ref") String ref);

    @Override
    @Query(value = "SELECT DISTINCT e FROM IngredientEntity e  LEFT JOIN FETCH e.effects")
    List<IngredientEntity> findAll();
}
