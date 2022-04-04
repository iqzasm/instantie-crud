package com.avinty.instantie.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider", modifyOnCreate = false)
public class JpaAuditorConfig {

    /**
     * Used for AANGEMAAKT_DOOR static user ID
     */
    @Value("${app.backend_user}")
    private String backendApiUser;

    /**
     * Using a static User ID for JPA Entity Create and Update.
     * This can also be read from SecurityContext when available
     */
    @Bean
    public AuditorAware<String> auditorProvider(){
        return () -> Optional.of(backendApiUser);
    }
}
