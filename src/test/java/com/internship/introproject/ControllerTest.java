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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlbumsRepository albumsRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testSaveAlbum() throws Exception {
        AlbumsDTO albumDTO = new AlbumsDTO();
        albumDTO.setId(1L);
        albumDTO.setUserId(100);
        albumDTO.setTitle("Test Album");

        mockMvc.perform(post("/api/v1/db/saveAlbums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(albumDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetAlbums() throws Exception {
        mockMvc.perform(get("/api/v1/db/getAlbums"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0))); // Assuming database is empty initially
    }
}
