package org.mdo.tools.game.teso.alchemy.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdo.tools.game.teso.alchemy.Application;
import org.mdo.tools.game.teso.alchemy.persistence.domain.TranslationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author MDO
 * @since 02/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TranslationRepositoryTest {
    @Autowired
    private TranslationRepository repository;

    @Test
    public void testFindByReference() {
        final List<TranslationEntity> empty = repository.findByReference("toto");
        assertNotNull(empty);
        assertEquals(0, empty.size());

        final List<TranslationEntity> notEmpty = repository.findByReference("EFFECT_DETECTION");
        assertNotNull(notEmpty);
        assertEquals(2, notEmpty.size());
        final Optional<TranslationEntity> en = notEmpty.stream()
                .filter(t -> t.getId().getLocale().equals("en"))
                .findFirst();
        final Optional<TranslationEntity> fr = notEmpty.stream()
                .filter(t -> t.getId().getLocale().equals("fr"))
                .findFirst();
        assertTrue(en.isPresent());
        assertTrue(fr.isPresent());
    }

    @Test
    public void testFindByCategory() {
        final List<TranslationEntity> empty = repository.findByCategory("toto");
        assertNotNull(empty);
        assertEquals(0, empty.size());

        final List<TranslationEntity> notEmpty = repository.findByCategory("EFFECT");
        assertNotNull(notEmpty);
        assertEquals(24 * 2, notEmpty.size());
    }
}
