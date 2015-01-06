package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Iterables;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdo.tools.game.teso.alchemy.Application;
import org.mdo.tools.game.teso.alchemy.services.dto.Effect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author MDO
 * @since 06/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EffectServicesImplTest {

    @Autowired
    private EffectServicesImpl services;

    @Test
    public void testGetAll() {
        final List<Effect> all = services.getAll();
        assertEquals(24, all.size());
        assertFalse(Optional.ofNullable(Iterables.find(all, e -> e != null && "TOTO".equals(e.getRef()), null)).isPresent());
        final Optional<Effect> one = Optional.ofNullable(Iterables.find(all, e -> e != null && "DETECTION".equals(e.getRef()), null));
        assertTrue(one.isPresent());
        assertEquals(2, one.get().getIngredients().size());

    }

    @Test
    public void testGetDetails() {
        assertNull(services.getDetails(""));
        final Effect detection = services.getDetails("DETECTION");
        assertNotNull(detection);
        assertEquals(2, detection.getIngredients().size());
    }
}
