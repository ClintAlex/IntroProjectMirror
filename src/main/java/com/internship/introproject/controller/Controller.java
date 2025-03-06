package com.internship.introproject.controller;

import com.internship.introproject.dto.*;
import com.internship.introproject.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/db")
public class Controller {

    @Autowired
    EntityService entityService;

    @PostMapping("savePosts")
    public List<PostsDTO> savePosts(@RequestBody List<PostsDTO> postsDTOs) {
        return postsDTOs.stream()
                .map(entityService::savePosts)
                .collect(Collectors.toList());
    }

    @PostMapping("saveComments")
    public List<CommentsDTO> saveComments(@RequestBody List<CommentsDTO> commentsDTOs) {
        return commentsDTOs.stream()
                .map(entityService::saveComments)
                .collect(Collectors.toList());
    }

    @PostMapping("saveAlbums")
    public List<AlbumsDTO> saveAlbums(@RequestBody List<AlbumsDTO> albumsDTOs) {
        return albumsDTOs.stream()
                .map(entityService::saveAlbums)
                .collect(Collectors.toList());
    }

    @PostMapping("savePhotos")
    public List<PhotosDTO> savePhotos(@RequestBody List<PhotosDTO> photosDTOs) {
        return photosDTOs.stream()
                .map(entityService::savePhotos)
                .collect(Collectors.toList());
    }

    @PostMapping("saveTodos")
    public List<TodosDTO> saveTodos(@RequestBody List<TodosDTO> todosDTOs) {
        return todosDTOs.stream()
                .map(entityService::saveTodos)
                .collect(Collectors.toList());
    }

    @PostMapping("saveUsers")
    public List<UsersDTO> saveUsers(@RequestBody List<UsersDTO> usersDTOs) {
        return usersDTOs.stream()
                .map(entityService::saveUsers)
                .collect(Collectors.toList());
    }

    @PostMapping("/truncateTable")
    public ResponseEntity<String> truncateTable(@RequestBody Map<String, String> request) {
        String tableName = request.get("tableName");
        if (tableName == null || tableName.isEmpty()) {
            return ResponseEntity.badRequest().body("Du skal angive et tabel navn");
        }
        entityService.dropTable(tableName);
        return ResponseEntity.ok("Tabel " + tableName + " truncated");
    }
}