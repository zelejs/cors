package com.edu.cors;

import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * Condition that checks if CORS is enabled.
 * <p>
 * Matches when the {@code cors.enabled} property is true (default).
 * To disable CORS auto-configuration, set {@code cors.enabled=false}
 * in application properties.
 */
public class ConditionalOnCorsEnabled extends SpringBootCondition {

    private static final String ENABLED_PROPERTY = "cors.enabled";

    @Override
    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
        boolean enabled = isEnabled(context);
        String message = String.format("CORS is %s", enabled ? "enabled" : "disabled");
        return new ConditionOutcome(enabled, ConditionMessage.of(message));
    }

    private boolean isEnabled(ConditionContext context) {
        // Check if explicitly disabled via property
        Map<String, Object> properties = context.getEnvironment()
                .getSystemProperties();

        if (properties.containsKey(ENABLED_PROPERTY)) {
            return Boolean.parseBoolean(properties.get(ENABLED_PROPERTY).toString());
        }

        // Check environment
        String property = context.getEnvironment().getProperty(ENABLED_PROPERTY);
        if (property != null) {
            return Boolean.parseBoolean(property);
        }

        // Default to enabled
        return true;
    }
}
