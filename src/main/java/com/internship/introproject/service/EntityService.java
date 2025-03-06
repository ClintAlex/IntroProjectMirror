package com.internship.introproject.service;

import com.internship.introproject.dto.*;
import com.internship.introproject.entity.*;
import com.internship.introproject.repository.*;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class EntityService {

    private final ModelMapper modelMapper;
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;
    private final AlbumsRepository albumsRepository;
    private final PhotosRepository photosRepository;
    private final TodosRepository todosRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public EntityService(ModelMapper modelMapper, PostsRepository postsRepository, CommentsRepository commentsRepository, AlbumsRepository albumsRepository, PhotosRepository photosRepository, TodosRepository todosRepository, UsersRepository usersRepository){
        this.modelMapper = modelMapper;
        this.postsRepository = postsRepository;
        this.commentsRepository = commentsRepository;
        this.albumsRepository = albumsRepository;
        this.photosRepository = photosRepository;
        this.todosRepository = todosRepository;
        this.usersRepository = usersRepository;
    }

    @Transactional
    public PostsDTO savePosts(PostsDTO postsDTO) {
        if (postsRepository.existsById(postsDTO.getId())) {
            throw new RuntimeException("Post med id " + postsDTO.getId() + " findes allerede");
        }

        Posts posts = modelMapper.map(postsDTO, Posts.class);
        posts = postsRepository.save(posts);

        return modelMapper.map(posts, PostsDTO.class);
    }

    @Transactional
    public CommentsDTO saveComments(CommentsDTO commentsDTO) {
        if (commentsRepository.existsById(commentsDTO.getId())) {
            throw new RuntimeException("Kommentar med id " + commentsDTO.getId() + " findes allerede");
        }

        Comments comments = modelMapper.map(commentsDTO, Comments.class);
        comments = commentsRepository.save(comments);

        return modelMapper.map(comments, CommentsDTO.class);
    }

    @Transactional
    public AlbumsDTO saveAlbums(AlbumsDTO albumsDTO) {
        if (albumsRepository.existsById(albumsDTO.getId())) {
            throw new RuntimeException("Album med id " + albumsDTO.getId() + " findes allerede");
        }

        Albums albums = modelMapper.map(albumsDTO, Albums.class);
        albums = albumsRepository.save(albums);

        return modelMapper.map(albums, AlbumsDTO.class);
    }

    @Transactional
    public PhotosDTO savePhotos(PhotosDTO photosDTO) {
        if (photosRepository.existsById(photosDTO.getId())) {
            throw new RuntimeException("Photo med id " + photosDTO.getId() + " findes allerede");
        }

        Photos photos = modelMapper.map(photosDTO, Photos.class);
        photos = photosRepository.save(photos);

        return modelMapper.map(photos, PhotosDTO.class);
    }

    @Transactional
    public TodosDTO saveTodos(TodosDTO todosDTO) {
        if (todosRepository.existsById(todosDTO.getId())) {
            throw new RuntimeException("Todo med id " + todosDTO.getId() + " findes allerede");
        }

        Todos todos = modelMapper.map(todosDTO, Todos.class);
        todos = todosRepository.save(todos);

        return modelMapper.map(todos, TodosDTO.class);
    }

    @Transactional
    public UsersDTO saveUsers(UsersDTO UsersDTO) {
        if (usersRepository.existsById(UsersDTO.getId())) {
            throw new RuntimeException("Todo med id " + UsersDTO.getId() + " findes allerede");
        }

        Users users = modelMapper.map(UsersDTO, Users.class);
        users = usersRepository.save(users);

        return modelMapper.map(users, UsersDTO.class);
    }
}
