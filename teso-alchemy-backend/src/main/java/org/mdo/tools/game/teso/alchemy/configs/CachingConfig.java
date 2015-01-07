package org.mdo.tools.game.teso.alchemy.configs;

import net.sf.ehcache.config.CacheConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MDO
 * @since 07/01/2015
 */
@Configuration
@EnableCaching
public class CachingConfig implements CachingConfigurer {

    private static Logger LOG = LoggerFactory.getLogger(CachingConfig.class);

    @Bean(destroyMethod = "shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("restCache");
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);

        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new InternalKeyGenerator();
    }

    private static class InternalKeyGenerator implements KeyGenerator {

        @Override
        public Object generate(Object target, Method method, Object... params) {
            final List<Object> finalParams = new ArrayList<>();
            if (target != null) {
                finalParams.add(target.getClass().toString());
            }
            if (method != null) {
                finalParams.add(method.getName());
            }
            if (params.length == 1 && params[0] != null && params[0].getClass().isArray()) {
                finalParams.addAll(Arrays.asList((Object[]) params[0]));
            } else {
                finalParams.addAll(Arrays.asList(params));
            }
            return new SimpleKey(finalParams.toArray());
        }
    }
}
