package org.mdo.tools.game.teso.alchemy.services.impl.function;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.TranslationEntity;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;

import java.util.List;
import java.util.Locale;

/**
 * @author MDO
 * @since 02/01/2015
 */
public class IngredientFunction implements Function<IngredientEntity, Ingredient> {
    private final List<TranslationEntity> translations;
    private final boolean recurse;

    public IngredientFunction(List<TranslationEntity> translations) {
        this(translations, true);
    }

    public IngredientFunction(List<TranslationEntity> translations, boolean recurse) {
        this.translations = translations;
        this.recurse = recurse;
    }

    @Override
    public Ingredient apply(final IngredientEntity input) {
        Ingredient ingredient = null;
        if (input != null) {
            ingredient = new Ingredient();
            final String ref = Strings.nullToEmpty(input.getRef());
            ingredient.setRef(ref);
            ingredient.setImage(input.getImage());
            final Iterable<TranslationEntity> filter = Iterables.filter(translations, t -> t != null && t.getId() != null && ("INGREDIENT_" + ref).equals(t.getId().getRef()));
            for (TranslationEntity translationEntity : filter) {
                final Locale locale = new Locale(translationEntity.getId().getLocale());
                ingredient.getName().put(locale, translationEntity.getValue());
            }
            if (recurse && input.getEffects().size() > 0) {
                ingredient.getEffects().addAll(Lists.transform(input.getEffects(), new EffectFunction(translations, false)));
            }
        }
        return ingredient;
    }
}
