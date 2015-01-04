package org.mdo.tools.game.teso.alchemy.services.impl.function;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.persistence.domain.EffectEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.IngredientEntity;
import org.mdo.tools.game.teso.alchemy.persistence.domain.TranslationEntity;
import org.mdo.tools.game.teso.alchemy.services.dto.Effect;
import org.mdo.tools.game.teso.alchemy.services.dto.Ingredient;

import java.util.List;
import java.util.Locale;

/**
 * @author MDO
 * @since 02/01/2015
 */
public class EffectFunction implements Function<EffectEntity, Effect> {
    private final List<TranslationEntity> translations;
    private final boolean recurse;

    public EffectFunction(List<TranslationEntity> translations) {
        this(translations, true);
    }

    public EffectFunction(List<TranslationEntity> translations, boolean recurse) {
        this.translations = Preconditions.checkNotNull(translations);
        this.recurse = recurse;
    }

    @Override
    public Effect apply(final EffectEntity input) {
        Effect effect = null;
        if (input != null) {
            effect = new Effect();
            final String ref = Strings.nullToEmpty(input.getRef());
            effect.setRef(ref);
            final Iterable<TranslationEntity> filter = Iterables.filter(translations, t -> t != null && t.getId() != null && ("EFFECT_" + ref).equals(t.getId().getRef()));
            for (TranslationEntity translationEntity : filter) {
                final Locale locale = new Locale(translationEntity.getId().getLocale());
                effect.getName().put(locale, translationEntity.getValue());
            }
            if (recurse && input.getIngredients().size() > 0) {
                effect.getIngredients().addAll(Lists.transform(input.getIngredients(), new IngredientFunction(translations, false)));
            }
        }
        return effect;
    }
}
