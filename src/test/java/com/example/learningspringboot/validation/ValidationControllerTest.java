package com.example.learningspringboot.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testValidFooInput() throws Exception {

        // GIVEN
        String input = "{\n" +
                "    \"email\": \"foo@email.com\",\n" +
                "    \"name\": \"Salman\",\n" +
                "    \"ssn\": \"123-45-9876\",\n" +
                "    \"year\": 1980\n" +
                "}";


        // WHEN
        MvcResult result = mockMvc.perform(post("/validation/foo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().isOk())
                .andReturn();

        // THEN
        Assertions.assertThat(result.getResponse().getContentType()).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        JSONAssert.assertEquals(input, result.getResponse().getContentAsString(), true);
    }

    @Test
    void testInvalidFooInput_invalidSSN() throws Exception {

        // GIVEN
        String input = "{\n" +
                "    \"email\": \"foo@email.com\",\n" +
                "    \"name\": \"Salman\",\n" +
                "    \"ssn\": \"123-450-9876\",\n" +
                "    \"year\": 1980\n" +
                "}";


        // WHEN + THEN
        mockMvc.perform(post("/validation/foo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(input))
                .andExpect(status().is(417));
    }
}
