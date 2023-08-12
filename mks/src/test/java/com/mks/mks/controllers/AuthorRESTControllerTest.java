package com.mks.mks.controllers;

import com.mks.mks.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class AuthorRESTControllerTest {

    public static final MediaType JSON = MediaType.APPLICATION_JSON;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void getHTTPRequestTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(JSON))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getHTTPRequestAuthorInfoTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(JSON))
                .andExpect(jsonPath("$.name", is("Лев")))
                .andExpect(jsonPath("$.surname", is("Толстой")));
    }
}