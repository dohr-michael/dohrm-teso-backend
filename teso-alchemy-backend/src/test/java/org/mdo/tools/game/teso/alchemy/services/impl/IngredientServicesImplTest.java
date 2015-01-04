package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdo.tools.game.teso.alchemy.Application;
import org.mdo.tools.game.teso.alchemy.services.dto.Effect;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author MDO
 * @since 04/01/2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class IngredientServicesImplTest {

    @Autowired
    private IngredientServicesImpl services;

    @Test
    public void testGetAll() {
        final List<Ingredient> all = services.getAll();
        assertEquals(18, all.size());
        final Optional<Ingredient> item = all
                .stream()
                .filter(effect -> effect.getRef().equals("BLUE_ENTOLOMA"))
                .findFirst();
        assertTrue(item.isPresent());
        check(item.get(), "BLUE_ENTOLOMA", "INVISIBILITY", "LOWER_SPELL_POWER", "RAVAGE_MAGICKA", "RESTORE_HEALTH");
    }

    @Test
    public void testGetCompatiblesIngredients() {
        final List<Ingredient> empty = services.getCompatiblesIngredients(Lists.newArrayList());
        assertEquals(0, empty.size());

        final List<Ingredient> oneIngredient = services.getCompatiblesIngredients(Lists.newArrayList("BLUE_ENTOLOMA"));
        check(oneIngredient, "BUGLOSS", "COLUMBINE", "EMETIC_RUSSULA", "LUMINOUS_RUSSULA", "MOUNTAIN_FLOWER", "NAMIRA_S_ROT", "NIRNROOT", "VIOLET_COPRINUS", "WATER_HYACINTH", "WHITE_CAP");

        final List<Ingredient> twoIngredient = services.getCompatiblesIngredients(Lists.newArrayList("BLUE_ENTOLOMA", "NAMIRA_S_ROT"));
        check(twoIngredient, "BLESSED_THISTLE", "BUGLOSS", "COLUMBINE", "EMETIC_RUSSULA", "LADY_S_SMOCK", "LUMINOUS_RUSSULA", "MOUNTAIN_FLOWER", "VIOLET_COPRINUS", "WATER_HYACINTH", "WHITE_CAP", "WORMWOOD");
    }

    private void check(Ingredient ingredient, String ref, String... excepts) {
        assertEquals(ref, ingredient.getRef());
        final List<Effect> ingredients = ingredient.getEffects();
        assertEquals(excepts.length, ingredients.size());
        assertEquals(2, ingredient.getName().size());
        for (String except : excepts) {
            assertEquals(1L, ingredients.stream().filter(current -> except.equals(current.getRef())).count());
        }
    }

    private void check(List<Ingredient> ingredients, String... excepts) {
        assertEquals(excepts.length, ingredients.size());
        for (String except : excepts) {
            assertEquals(1L, ingredients.stream().filter(ingredient -> except.equals(ingredient.getRef())).count());
        }
        for (Ingredient ingredient : ingredients) {
            assertEquals(2, ingredient.getName().size());
            final Ingredient base = services.getDetails(ingredient.getRef());
            assertEquals(base.getEffects().size(), ingredient.getEffects().size());
            // Union to check is same.
            final Sets.SetView<Effect> union = Sets.union(Sets.newHashSet(ingredient.getEffects()), Sets.newHashSet(base.getEffects()));
            assertEquals(4, union.size());
        }
    }

}
