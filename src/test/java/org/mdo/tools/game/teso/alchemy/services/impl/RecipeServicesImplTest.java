package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdo.tools.game.teso.alchemy.Application;
import org.mdo.tools.game.teso.alchemy.services.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @author MDO
 * @since 04/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RecipeServicesImplTest {

    @Autowired
    private RecipeServicesImpl services;

    @Test
    public void testGetRecipeFromIngredients() {
        assertNull(services.getRecipeFromIngredients(null));
        assertNull(services.getRecipeFromIngredients(new ArrayList<>()));
        assertNull(services.getRecipeFromIngredients(Lists.newArrayList("BLESSED_THISTLE")));

        final Recipe emptyEffect = services.getRecipeFromIngredients(Lists.newArrayList("BLESSED_THISTLE", "IMP_STOOL"));
        assertNotNull(emptyEffect);
        assertEquals(2, emptyEffect.getIngredients().size());
        check(emptyEffect);

        final Recipe oneEffect = services.getRecipeFromIngredients(Lists.newArrayList("BLESSED_THISTLE", "COLUMBINE"));
        assertNotNull(oneEffect);
        assertEquals(2, oneEffect.getIngredients().size());
        check(oneEffect, "RESTORE_STAMINA");

        final Recipe twoEffect = services.getRecipeFromIngredients(Lists.newArrayList("BLESSED_THISTLE", "DRAGONTHORN"));
        assertNotNull(twoEffect);
        assertEquals(2, twoEffect.getIngredients().size());
        check(twoEffect, "INCREASE_WEAPON_POWER", "RESTORE_STAMINA");

        final Recipe twoEffectBis = services.getRecipeFromIngredients(Lists.newArrayList("BLESSED_THISTLE", "DRAGONTHORN", "IMP_STOOL"));
        assertNotNull(twoEffectBis);
        assertEquals(3, twoEffectBis.getIngredients().size());
        check(twoEffectBis, "INCREASE_WEAPON_POWER", "RESTORE_STAMINA");

        final Recipe moreEffect = services.getRecipeFromIngredients(Lists.newArrayList("BLESSED_THISTLE", "DRAGONTHORN", "STINKHORN"));
        assertNotNull(moreEffect);
        assertEquals(3, moreEffect.getIngredients().size());
        check(moreEffect, "INCREASE_WEAPON_POWER", "RESTORE_STAMINA", "LOWER_ARMOR", "RAVAGE_HEALTH");
    }

    private void check(Recipe recipe, String... effects) {
        assertEquals(effects.length, recipe.getEffects().size());
        for (String effect : effects) {
            assertTrue(Optional.ofNullable(Iterables.find(recipe.getEffects(), e -> effect.equals(e.getRef()), null)).isPresent());
        }
    }
}
