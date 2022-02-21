package com.jumia.test.app.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CountryController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CountryControllerTests {

    @Autowired
    private MockMvc mvc;

    @InjectMocks
    private CountryController countryController;

    @Test
    void getAllCountries_Expect200() throws Exception {

        this.mvc.perform(get("http://localhost:8181/countries")
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[\"Morocco\",\"Uganda\",\"Mozambique\",\"Cameroon\",\"Ethiopia\"]\n"))
        ;

    }


}
