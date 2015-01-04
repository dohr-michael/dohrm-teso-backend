package org.mdo.tools.game.teso.alchemy.persistence.repository;

import org.mdo.tools.game.teso.alchemy.persistence.domain.EffectEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MDO
 * @since 01/01/2015
 */
@Repository
public interface EffectRepository extends JpaRepository<EffectEntity, String> {

    @Override
    @Query(value = "SELECT e FROM EffectEntity e LEFT JOIN FETCH e.ingredients WHERE e.ref=:ref")
    EffectEntity findOne(@Param("ref") String ref);

    @Override
    @Query(value = "SELECT DISTINCT e FROM EffectEntity e  LEFT JOIN FETCH e.ingredients")
    List<EffectEntity> findAll();
}
