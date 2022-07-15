package com.example.learningspringboot.heroes;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "heroes")
public class HeroesConfig {

    private int oldThreshold;
    private String baseUrl;
}
