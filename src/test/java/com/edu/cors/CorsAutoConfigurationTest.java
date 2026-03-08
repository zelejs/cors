package com.edu.cors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link CorsAutoConfiguration}.
 */
@SpringBootTest(classes = CorsAutoConfiguration.class)
@TestPropertySource(properties = {
        "cors.enabled=true",
        "cors.allowed-origins=*",
        "cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS",
        "cors.allowed-headers=*",
        "cors.allow-credentials=true",
        "cors.max-age=3600"
})
class CorsAutoConfigurationTest {

    @Test
    void contextLoads() {
        // Test that the context loads successfully
        assertThat(true).isTrue();
    }

    @Test
    void testCorsProperties() {
        CorsProperties properties = new CorsProperties();
        properties.setEnabled(true);
        properties.setAllowCredentials(true);
        properties.setMaxAge(3600L);

        assertThat(properties.isEnabled()).isTrue();
        assertThat(properties.isAllowCredentials()).isTrue();
        assertThat(properties.getMaxAge()).isEqualTo(3600L);
    }
}
