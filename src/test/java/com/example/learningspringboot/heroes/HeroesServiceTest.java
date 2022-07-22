package com.example.learningspringboot.heroes;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

class HeroesServiceTest {


    @Test
    void testSomething() throws Exception {

        // GIVEN
        WireMockConfiguration wireMockConfiguration = options().dynamicPort();
        WireMockServer wireMockRule = new WireMockServer(wireMockConfiguration);
        wireMockRule.start();

        HeroesConfig config = new HeroesConfig();
        config.setBaseUrl(wireMockRule.baseUrl());
        config.setOldThreshold(25);

        String jsonString = """
                [
                    { "id": 123, "name": "superman", "age": 25 } 
                ]
                """;
        wireMockRule.stubFor(get(urlEqualTo("/heroes/gt/25"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(jsonString)));

        // WHEN
        HeroesService underTest = new HeroesService(config);
        List<Hero> olderHeroes = underTest.getOlderHeroes();

        // THEN
        Assertions.assertThat(olderHeroes).isNotNull();
        Assertions.assertThat(olderHeroes).hasSize(1);

        Hero hero = olderHeroes.get(0);
        Assertions.assertThat(hero.getAge()).isEqualTo(25);
        Assertions.assertThat(hero.getName()).isEqualTo("superman");
        Assertions.assertThat(hero.getId()).isEqualTo(123);

        // CLEANUP
        wireMockRule.shutdown();
    }

}