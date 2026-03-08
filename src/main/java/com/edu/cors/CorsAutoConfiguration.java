package com.edu.cors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * CORS Auto-Configuration.
 * <p>
 * This auto-configuration is automatically enabled when this library is on the classpath.
 * To disable, set {@code cors.enabled=false} in application properties.
 * <p>
 * Security: Remove this dependency from your project to completely disable CORS.
 * <p>
 * The filter is registered with HIGHEST_PRECEDENCE to ensure CORS headers are added
 * before authentication filters (like Shiro) process the request.
 */
@AutoConfiguration
@ConditionalOnWebApplication
@EnableConfigurationProperties(CorsProperties.class)
@ConditionalOnProperty(prefix = "cors", name = "enabled", havingValue = "true", matchIfMissing = true)
public class CorsAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(CorsAutoConfiguration.class);

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(CorsProperties properties) {
        log.info("Initializing CORS filter with properties: {}", properties);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Apply configuration from properties
        config.setAllowCredentials(properties.isAllowCredentials());
        config.setAllowedOrigins(properties.getAllowedOrigins());
        config.setAllowedMethods(properties.getAllowedMethods());
        config.setAllowedHeaders(properties.getAllowedHeaders());
        config.setExposedHeaders(properties.getExposedHeaders());
        config.setMaxAge(properties.getMaxAge());

        // Register for all paths
        source.registerCorsConfiguration("/**", config);

        CorsFilter corsFilter = new CorsFilter(source);

        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>(corsFilter);
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.addUrlPatterns("/*");

        log.info("CORS filter registered with HIGHEST_PRECEDENCE order");

        return registrationBean;
    }
}
