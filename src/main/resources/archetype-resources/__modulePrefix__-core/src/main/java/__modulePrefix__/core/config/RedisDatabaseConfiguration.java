package ${groupId}.${modulePrefix}.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import ${groupId}.${modulePrefix}.core.config.properties.MyApplicationProperties;

import java.nio.charset.Charset;

@Configuration
@EnableCaching
public class RedisDatabaseConfiguration extends CachingConfigurerSupport {

    @Autowired
    private MyApplicationProperties myApplicationProperties;

    @Autowired
    private JedisConnectionFactory jedisConnFactory;

    @Autowired
    private StringRedisSerializer stringRedisSerializer;

    @Bean
    public StringRedisSerializer stringRedisSerializer() {

        return new StringRedisSerializer(Charset.forName("UTF-8"));
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    @Bean
    @SuppressWarnings("rawtypes")
    public CacheManager cacheManager(final RedisTemplate redisTemplate) {

        final RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        cacheManager.setUsePrefix(true);
        cacheManager.setCacheNames(myApplicationProperties.getCache().getNames());
        cacheManager.setDefaultExpiration(myApplicationProperties.getCache().getTimeout().getDefaultExpiration());
        return cacheManager;
    }

    @Bean
    @Override
    public CacheErrorHandler errorHandler() {

        return new CacheErrorHandler() {

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {

                // Do nothing
            }

            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

                // Do nothing
            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {

                // Do nothing
            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {

                // Do nothing
            }
        };
    }
}
