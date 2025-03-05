package com.internship.introproject.controller;

import com.internship.introproject.dto.*;
import com.internship.introproject.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/save")
public class Controller {

    @Autowired
    Service Service;

    @PostMapping("savePosts")
    public List<PostsDTO> savePosts(@RequestBody List<PostsDTO> postsDTOs) {
        List<PostsDTO> savedPosts = new ArrayList<>();
        for (PostsDTO postsDTO : postsDTOs) {
            savedPosts.add(Service.savePosts(postsDTO));
        }
        return savedPosts;
    }

    @PostMapping("saveComments")
    public List<CommentsDTO> saveComments(@RequestBody List<CommentsDTO> userDTOs) {
        List<CommentsDTO> savedComments = new ArrayList<>();
        for (CommentsDTO commentsDTO : userDTOs) {
            savedComments.add(Service.saveComments(commentsDTO));
        }
        return savedComments;
    }

    @PostMapping("saveAlbums")
    public List<AlbumsDTO> saveAlbums(@RequestBody List<AlbumsDTO> userDTOs) {
        List<AlbumsDTO> savedAlbums = new ArrayList<>();
        for (AlbumsDTO albumsDTO : userDTOs) {
            savedAlbums.add(Service.saveAlbums(albumsDTO));
        }
        return savedAlbums;
    }

    @PostMapping("savePhotos")
    public List<PhotosDTO> savePhotos(@RequestBody List<PhotosDTO> photosDTOs) {
        List<PhotosDTO> savedPhotos = new ArrayList<>();
        for (PhotosDTO photosDTO : photosDTOs) {
            savedPhotos.add(Service.savePhotos(photosDTO));
        }
        return savedPhotos;
    }

    @PostMapping("saveTodos")
    public List<TodosDTO> saveTodos(@RequestBody List<TodosDTO> todosDTOs) {
        List<TodosDTO> savedTodos = new ArrayList<>();
        for (TodosDTO todosDTO : todosDTOs) {
            savedTodos.add(Service.saveTodos(todosDTO));
        }
        return savedTodos;
    }
}