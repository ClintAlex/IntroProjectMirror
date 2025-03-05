package com.internship.introproject.service;

import com.internship.introproject.dto.*;
import com.internship.introproject.entity.*;
import com.internship.introproject.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private PostsRepository postsRepository;
    @Transactional
    public PostsDTO savePosts(PostsDTO postsDTO) {
        if (postsRepository.existsById(postsDTO.getId())) {
            throw new RuntimeException("Post med id " + postsDTO.getId() + " findes allerede");
        }

        Posts posts = modelMapper.map(postsDTO, Posts.class);
        posts = postsRepository.save(posts);

        return modelMapper.map(posts, PostsDTO.class);
    }

    @Autowired
    private CommentsRepository commentsRepository;
    @Transactional
    public CommentsDTO saveComments(CommentsDTO commentsDTO) {
        if (commentsRepository.existsById(commentsDTO.getId())) {
            throw new RuntimeException("Kommentar med id " + commentsDTO.getId() + " findes allerede");
        }

        Comments comments = modelMapper.map(commentsDTO, Comments.class);
        comments = commentsRepository.save(comments);

        return modelMapper.map(comments, CommentsDTO.class);
    }

    @Autowired
    private AlbumsRepository albumsRepository;
    @Transactional
    public AlbumsDTO saveAlbums(AlbumsDTO albumsDTO) {
        if (albumsRepository.existsById(albumsDTO.getId())) {
            throw new RuntimeException("Album med id " + albumsDTO.getId() + " findes allerede");
        }

        Albums albums = modelMapper.map(albumsDTO, Albums.class);
        albums = albumsRepository.save(albums);

        return modelMapper.map(albums, AlbumsDTO.class);
    }

    @Autowired
    private PhotosRepository photosRepository;
    @Transactional
    public PhotosDTO savePhotos(PhotosDTO photosDTO) {
        if (photosRepository.existsById(photosDTO.getId())) {
            throw new RuntimeException("Photo med id " + photosDTO.getId() + " findes allerede");
        }

        Photos photos = modelMapper.map(photosDTO, Photos.class);
        photos = photosRepository.save(photos);

        return modelMapper.map(photos, PhotosDTO.class);
    }

    @Autowired
    private TodosRepository todosRepository;
    @Transactional
    public TodosDTO saveTodos(TodosDTO todosDTO) {
        if (todosRepository.existsById(todosDTO.getId())) {
            throw new RuntimeException("Todo med id " + todosDTO.getId() + " findes allerede");
        }

        Todos todos = modelMapper.map(todosDTO, Todos.class);
        todos = todosRepository.save(todos);

        return modelMapper.map(todos, TodosDTO.class);
    }
}
