package org.mdo.tools.game.teso.alchemy.persistence.repository;

import org.mdo.tools.game.teso.alchemy.persistence.domain.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author MDO
 * @since 02/01/2015
 */
public interface TranslationRepository extends JpaRepository<TranslationEntity, TranslationEntity.TranslationId> {

    @Query(value = "SELECT t FROM TranslationEntity t WHERE t.id.ref=:ref")
    List<TranslationEntity> findByReference(@Param("ref") String ref);

    @Query(value = "SELECT t FROM TranslationEntity t WHERE t.id.ref like concat(:cat, '_%')")
    List<TranslationEntity> findByCategory(@Param("cat") String cat);
}
