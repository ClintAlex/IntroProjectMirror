package com.internship.introproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internship.introproject.dto.*;
import com.internship.introproject.dto.PostsDTO;
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
    public void testSaveAlbum() throws Exception {
        List<AlbumsDTO> albums = List.of(new AlbumsDTO(System.currentTimeMillis(), 100, "Test Album"));

        mockMvc.perform(post("/api/v1/db/saveAlbums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(albums)))
                .andExpect(status().isOk());
        System.out.println("testSaveAlbum completed successfully!");
    }

    @Test
    public void testGetAlbums() throws Exception {
        mockMvc.perform(get("/api/v1/db/getAlbums"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        System.out.println("testGetAlbums completed successfully!");
    }

    @Test
    public void testSaveComment() throws Exception {
        List<CommentsDTO> comments = List.of(new CommentsDTO(System.currentTimeMillis(), 99999, "Test Album", "Test Album", "Test Album"));

        mockMvc.perform(post("/api/v1/db/saveComments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comments)))
                .andExpect(status().isOk());
        System.out.println("testSaveComments completed successfully!");
    }

    @Test
    public void testGetComments() throws Exception {
        mockMvc.perform(get("/api/v1/db/getComments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        System.out.println("testGetComments completed successfully!");
    }

    @Test
    public void testSavePost() throws Exception {
        List<PostsDTO> posts = List.of(new PostsDTO(System.currentTimeMillis(), 99999, "Test Album", "Test Album"));

        mockMvc.perform(post("/api/v1/db/savePosts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(posts)))
                .andExpect(status().isOk());
        System.out.println("testSavePosts completed successfully!");
    }

    @Test
    public void testGetPost() throws Exception {
        mockMvc.perform(get("/api/v1/db/getPosts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        System.out.println("testGetPosts completed successfully!");
    }

    @Test
    public void testSavePhotos() throws Exception {
        List<PhotosDTO> photos = List.of(new PhotosDTO(System.currentTimeMillis(), 99999, "Test Album", "Test Album", "Test Album"));

        mockMvc.perform(post("/api/v1/db/savePhotos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(photos)))
                .andExpect(status().isOk());
        System.out.println("testSavePhotos completed successfully!");
    }

    @Test
    public void testGetPhotos() throws Exception {
        mockMvc.perform(get("/api/v1/db/getPhotos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        System.out.println("testGetPhotos completed successfully!");
    }

    @Test
    public void testSaveTodos() throws Exception {
        List<TodosDTO> todos = List.of(new TodosDTO(System.currentTimeMillis(), 99999, "Test Album", false));

        mockMvc.perform(post("/api/v1/db/saveTodos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(todos)))
                .andExpect(status().isOk());
        System.out.println("testSaveTodos completed successfully!");
    }

    @Test
    public void testGetTodos() throws Exception {
        mockMvc.perform(get("/api/v1/db/getTodos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
        System.out.println("testGetTodos completed successfully!");
    }
}
