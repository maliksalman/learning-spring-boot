package com.example.learningspringboot.heroes;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class HeroesService {

    private final HeroesConfig config;
    private final WebClient webClient;

    public HeroesService(HeroesConfig config) {
        this.config = config;
        this.webClient = WebClient.create(config.getBaseUrl());
    }

    public List<Hero> getOlderHeroes() {
        return webClient.get()
                .uri("/heroes/gt/{age}", config.getOldThreshold())
                .retrieve()
                .bodyToFlux(Hero.class)
                .collectList()
                .block();
    }

    public List<Hero> getYoungerHeroes() {
        return webClient.get()
                .uri("/heroes/lt/{age}", config.getOldThreshold())
                .retrieve()
                .bodyToFlux(Hero.class)
                .collectList()
                .block();
    }
}
