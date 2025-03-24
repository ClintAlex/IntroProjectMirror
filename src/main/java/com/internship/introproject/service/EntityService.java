package com.internship.introproject.service;

import com.internship.introproject.dto.*;
import com.internship.introproject.entity.*;
import com.internship.introproject.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@org.springframework.stereotype.Service
public class EntityService {

    private final ModelMapper modelMapper;
    private final PostsRepository postsRepository;
    private final CommentsRepository commentsRepository;
    private final AlbumsRepository albumsRepository;
    private final PhotosRepository photosRepository;
    private final TodosRepository todosRepository;
    private final UsersRepository usersRepository;
    private final EntityManager entityManager;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public EntityService(ModelMapper modelMapper, PostsRepository postsRepository, CommentsRepository commentsRepository, AlbumsRepository albumsRepository, PhotosRepository photosRepository, TodosRepository todosRepository, UsersRepository usersRepository, EntityManager entityManager){
        this.modelMapper = modelMapper;
        this.postsRepository = postsRepository;
        this.commentsRepository = commentsRepository;
        this.albumsRepository = albumsRepository;
        this.photosRepository = photosRepository;
        this.todosRepository = todosRepository;
        this.usersRepository = usersRepository;
        this.entityManager = entityManager;
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
            throw new RuntimeException("Users med id " + UsersDTO.getId() + " findes allerede");
        }

        Users users = modelMapper.map(UsersDTO, Users.class);
        users = usersRepository.save(users);

        return modelMapper.map(users, UsersDTO.class);
    }

    @Transactional
    public void dropTable(String tableName) {
        String sql = "TRUNCATE TABLE " + tableName;
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Transactional
    public Object updateEntity(String type, Map<String, Object> payload) {
        try {
            switch (type.trim().toLowerCase()) {
                case "albums":
                    AlbumsDTO albumsDTO = objectMapper.convertValue(payload, AlbumsDTO.class);
                    return updateAlbums(albumsDTO);
                case "users":
                    UsersDTO usersDTO = objectMapper.convertValue(payload, UsersDTO.class);
                    return updateUsers(usersDTO);
                case "posts":
                    PostsDTO postsDTO = objectMapper.convertValue(payload, PostsDTO.class);
                    return updatePosts(postsDTO);
                case "comments":
                    CommentsDTO commentsDTO = objectMapper.convertValue(payload, CommentsDTO.class);
                    return updateComments(commentsDTO);
                case "photos":
                    PhotosDTO photosDTO = objectMapper.convertValue(payload, PhotosDTO.class);
                    return updatePhotos(photosDTO);
                case "todos":
                    TodosDTO todosDTO = objectMapper.convertValue(payload, TodosDTO.class);
                    return updateTodos(todosDTO);
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to convert payload: " + e.getMessage());
        }
    }

    @Transactional
    public AlbumsDTO updateAlbums(AlbumsDTO albumsDTO) {
        if (!albumsRepository.existsById(albumsDTO.getId())) {
            throw new IllegalArgumentException("Album with id " + albumsDTO.getId() + " does not exist.");
        }
        Albums album = modelMapper.map(albumsDTO, Albums.class);
        album = albumsRepository.save(album);
        return modelMapper.map(album, AlbumsDTO.class);
    }

    @Transactional
    public UsersDTO updateUsers(UsersDTO usersDTO) {
        if (!usersRepository.existsById(usersDTO.getId())) {
            throw new IllegalArgumentException("User with id " + usersDTO.getId() + " does not exist.");
        }
        Users user = modelMapper.map(usersDTO, Users.class);
        user = usersRepository.save(user);
        return modelMapper.map(user, UsersDTO.class);
    }

    @Transactional
    public PostsDTO updatePosts(PostsDTO postsDTO) {
        if (!postsRepository.existsById(postsDTO.getId())) {
            throw new IllegalArgumentException("Post with id " + postsDTO.getId() + " does not exist.");
        }
        Posts post = modelMapper.map(postsDTO, Posts.class);
        post = postsRepository.save(post);
        return modelMapper.map(post, PostsDTO.class);
    }

    @Transactional
    public CommentsDTO updateComments(CommentsDTO commentsDTO) {
        if (!commentsRepository.existsById(commentsDTO.getId())) {
            throw new IllegalArgumentException("Comment with id " + commentsDTO.getId() + " does not exist.");
        }
        Comments comment = modelMapper.map(commentsDTO, Comments.class);
        comment = commentsRepository.save(comment);
        return modelMapper.map(comment, CommentsDTO.class);
    }

    @Transactional
    public PhotosDTO updatePhotos(PhotosDTO photosDTO) {
        if (!photosRepository.existsById(photosDTO.getId())) {
            throw new IllegalArgumentException("Photo with id " + photosDTO.getId() + " does not exist.");
        }
        Photos photo = modelMapper.map(photosDTO, Photos.class);
        photo = photosRepository.save(photo);
        return modelMapper.map(photo, PhotosDTO.class);
    }

    @Transactional
    public TodosDTO updateTodos(TodosDTO todosDTO) {
        if (!todosRepository.existsById(todosDTO.getId())) {
            throw new IllegalArgumentException("Todo with id " + todosDTO.getId() + " does not exist.");
        }
        Todos todo = modelMapper.map(todosDTO, Todos.class);
        todo = todosRepository.save(todo);
        return modelMapper.map(todo, TodosDTO.class);
    }

}
