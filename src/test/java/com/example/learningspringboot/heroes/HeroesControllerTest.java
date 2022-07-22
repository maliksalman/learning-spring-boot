package com.example.learningspringboot.heroes;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HeroesControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HeroesService heroesService;

    @Test
    void testOlderHeroesReturned() throws Exception {

        // GIVEN
        List<Hero> list = List.of(Hero.builder()
                        .id(123l)
                        .name("superman")
                        .age(30)
                        .build(),
                Hero.builder()
                        .id(456l)
                        .name("batman")
                        .age(40)
                        .build());
        Mockito
                .when(heroesService.getOlderHeroes())
                .thenReturn(list);

        // WHEN
        MvcResult result = mockMvc.perform(get("/heroes/old"))
                .andExpect(status().isOk())
                .andReturn();

        // THEN
        String expected = "[\n" +
                "  {\n" +
                "    \"id\": 123,\n" +
                "    \"name\": \"superman\",\n" +
                "    \"age\": 30\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 456,\n" +
                "    \"name\": \"batman\",\n" +
                "    \"age\": 40\n" +
                "  }\n" +
                "]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);

    }

}