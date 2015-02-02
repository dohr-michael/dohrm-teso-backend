package org.mdo.tools.game.teso.alchemy.persistence.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdo.tools.game.teso.alchemy.Application;
import org.mdo.tools.game.teso.alchemy.persistence.domain.EffectEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author MDO
 * @since 01/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EffectRepositoryTest {

    @Autowired
    private EffectRepository repository;

    @Test
    public void testFindAll() {
        final List<EffectEntity> all = repository.findAll();
        assertEquals(24, all.size());
        final Optional<EffectEntity> item = all
                .stream()
                .filter(effect -> effect.getRef().equals("SPEED"))
                .findFirst();
        assertTrue(item.isPresent());
        check(item.get(), "SPEED", "BLESSED_THISTLE", "NAMIRA_S_ROT");
    }

    @Test
    public void testFindOne() {
        final EffectEntity empty = repository.findOne("TOTO");
        assertNull(empty);

        check(repository.findOne("SPEED"), "SPEED", "BLESSED_THISTLE", "NAMIRA_S_ROT");
    }

    private void check(EffectEntity entity, String ref, String... excepts) {
        assertEquals(ref, entity.getRef());
        final List<IngredientEntity> ingredients = entity.getIngredients();
        assertEquals(excepts.length, ingredients.size());
        for (String except : excepts) {
            assertEquals(1L, ingredients.stream().filter(ingredient -> except.equals(ingredient.getRef())).count());
        }
    }

}
