package com.ness.ms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureWebMvc
public class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

//    @Test
//    void getDefaultOrderTest() {
//        mockMvc.perform(get("/defaultOrder")).andExpect().
//    }
}
