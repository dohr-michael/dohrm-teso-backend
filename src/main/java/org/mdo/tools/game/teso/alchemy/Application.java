package org.mdo.tools.game.teso.alchemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

        System.setProperty("spring.datasource.url", System.getenv("DATABASE_URL"));
        System.setProperty("spring.datasource.username", System.getenv("DATABASE_USERNAME"));
        System.setProperty("spring.datasource.password", System.getenv("DATABASE_PASSWORD"));

        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        app.run(args);
    }

}
