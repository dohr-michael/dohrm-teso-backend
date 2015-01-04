package org.mdo.tools.game.teso.alchemy;

import org.mdo.tools.game.teso.alchemy.persistence.repository.IngredientRepositoryCustom;
import org.mdo.tools.game.teso.alchemy.persistence.repository.IngredientRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author MDO
 * @since 30/12/2014
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "org.mdo.tools.game.teso.alchemy.persistence.repository")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
    }

}
