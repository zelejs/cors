package com.edu.cors;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * CORS Configuration Properties.
 * <p>
 * Configure CORS settings via application properties:
 * <pre>
 * cors.enabled=true
 * cors.allowed-origins=*
 * cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
 * cors.allowed-headers=*
 * cors.allow-credentials=true
 * cors.exposed-headers=Content-Disposition,Content-Type
 * cors.max-age=3600
 * </pre>
 */
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {

    /**
     * Enable or disable CORS auto-configuration.
     */
    private boolean enabled = true;

    /**
     * List of allowed origins for CORS requests.
     * Use "*" to allow all origins.
     */
    private List<String> allowedOrigins = new ArrayList<>();

    /**
     * List of allowed HTTP methods for CORS requests.
     */
    private List<String> allowedMethods = List.of("GET", "POST", "PUT", "DELETE", "OPTIONS");

    /**
     * List of allowed headers for CORS requests.
     * Use "*" to allow all headers.
     */
    private List<String> allowedHeaders = List.of("*");

    /**
     * List of headers that should be exposed to the browser.
     */
    private List<String> exposedHeaders = new ArrayList<>();

    /**
     * Whether credentials (cookies, authorization headers) are allowed.
     */
    private boolean allowCredentials = true;

    /**
     * How long (in seconds) the response from a pre-flight request can be cached.
     */
    private Long maxAge = 3600L;

    /**
     * List of path patterns to apply CORS configuration.
     */
    private List<String> pathPatterns = List.of("/**");

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public List<String> getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(List<String> allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public List<String> getExposedHeaders() {
        return exposedHeaders;
    }

    public void setExposedHeaders(List<String> exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }

    public boolean isAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

    public List<String> getPathPatterns() {
        return pathPatterns;
    }

    public void setPathPatterns(List<String> pathPatterns) {
        this.pathPatterns = pathPatterns;
    }
}
