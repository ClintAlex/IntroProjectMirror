package com.internship.introproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.introproject.dto.AlbumsDTO;
import com.internship.introproject.repository.AlbumsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSaveAlbum() throws Exception {
        List<AlbumsDTO> albums = List.of(new AlbumsDTO(System.currentTimeMillis(), 100, "Test Album"));

        mockMvc.perform(post("/api/v1/db/saveAlbums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(albums)))
                .andExpect(status().isOk());
        System.out.println("testSaveAlbum completed successfully!");
    }

    @Test
    void testGetAlbums() throws Exception {
        mockMvc.perform(get("/api/v1/db/getAlbums"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        System.out.println("testGetAlbums completed successfully!");
    }
}
