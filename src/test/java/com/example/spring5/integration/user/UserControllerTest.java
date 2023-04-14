package com.example.spring5.integration.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

//    @Test
//    void findById() throws Exception {
//        mockMvc.perform(get("/users/1"))
//                .andExpect(MockMvcResultMatchers.status().isN);
//    }

//    @Test
//    void save() throws Exception {
//        mockMvc.perform(post("/users/")
//                        .param("username", "tets@user")
//                        .param("birthDate", "2022-11-22")
//                        .param("firstname", "first")
//                        .param("lastname", "last")
//                        .param("role", "admin"))
//                .andExpectAll(MockMvcResultMatchers.status().is2xxSuccessful());
//    }
}