package org.mdo.tools.game.teso.alchemy.services.impl;

import com.google.common.collect.Lists;
import org.mdo.tools.game.teso.alchemy.persistence.repository.EffectRepository;
import org.mdo.tools.game.teso.alchemy.persistence.repository.TranslationRepository;
import org.mdo.tools.game.teso.alchemy.services.EffectServices;
import org.mdo.tools.game.teso.alchemy.services.dto.Effect;
import org.mdo.tools.game.teso.alchemy.services.impl.function.EffectFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MDO
 * @since 06/01/2015
 */
@Service
public class EffectServicesImpl implements EffectServices {

    @Autowired
    private EffectRepository repository;

    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public List<Effect> getAll() {
        return Lists.transform(repository.findAll(),
                new EffectFunction(translationRepository.findAll()));
    }

    @Override
    public Effect getDetails(String effectRef) {
        return new EffectFunction(translationRepository.findAll())
                .apply(repository.findOne(effectRef));
    }
}
