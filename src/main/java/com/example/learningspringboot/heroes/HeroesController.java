package com.example.learningspringboot.heroes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HeroesController {

    private final HeroesService heroesService;

    @GetMapping("/heroes/old")
    public List<Hero> getOlderHeroes() {
        return heroesService.getOlderHeroes();
    }

    @GetMapping("/heroes/young")
    public List<Hero> getYoungHeroes() {
        return heroesService.getYoungerHeroes();
    }
}
