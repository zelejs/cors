package com.edu.cors;

import lombok.Data;
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
@Data
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
    private List<String> allowedHeaders = new ArrayList<>();

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
}
