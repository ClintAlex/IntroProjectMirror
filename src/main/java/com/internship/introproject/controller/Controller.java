package com.internship.introproject.controller;

import com.internship.introproject.dto.*;
import com.internship.introproject.entity.Users;
import com.internship.introproject.repository.*;
import com.internship.introproject.service.EntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/db")
public class Controller {

    AlbumsRepository albumsRepository;
    CommentsRepository commentsRepository;
    PhotosRepository photosRepository;
    PostsRepository postsRepository;
    TodosRepository todosRepository;
    UsersRepository usersRepository;
    ModelMapper modelMapper;
    EntityService entityService;

    @Autowired
    public Controller(AlbumsRepository albumsRepository, CommentsRepository commentsRepository, PhotosRepository photosRepository, PostsRepository postsRepository, TodosRepository todosRepository, UsersRepository usersRepository,
    ModelMapper modelMapper, EntityService entityService) {
        this.albumsRepository = albumsRepository;
        this.commentsRepository = commentsRepository;
        this.photosRepository = photosRepository;
        this.postsRepository = postsRepository;
        this.todosRepository = todosRepository;
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
        this.entityService = entityService;
    }

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("savePosts")
    public List<PostsDTO> savePosts(@RequestBody List<PostsDTO> postsDTOs) {
        return postsDTOs.stream()
                .map(entityService::savePosts)
                .collect(Collectors.toList());
    }

    @GetMapping("getPosts")
    public List<PostsDTO> getPosts() {
        return postsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(posts -> modelMapper.map(posts, PostsDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("saveComments")
    public List<CommentsDTO> saveComments(@RequestBody List<CommentsDTO> commentsDTOs) {
        return commentsDTOs.stream()
                .map(entityService::saveComments)
                .collect(Collectors.toList());
    }

    @GetMapping("getComments")
    public List<CommentsDTO> getComments() {
        return commentsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(comments -> modelMapper.map(comments, CommentsDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("saveAlbums")
    public List<AlbumsDTO> saveAlbums(@RequestBody List<AlbumsDTO> albumsDTOs) {
        return albumsDTOs.stream()
                .map(entityService::saveAlbums)
                .collect(Collectors.toList());
    }

    @GetMapping("getAlbums")
    public List<AlbumsDTO> getAlbums() {
        return albumsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(albums -> modelMapper.map(albums, AlbumsDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("savePhotos")
    public List<PhotosDTO> savePhotos(@RequestBody List<PhotosDTO> photosDTOs) {
        return photosDTOs.stream()
                .map(entityService::savePhotos)
                .collect(Collectors.toList());
    }

    @GetMapping("getPhotos")
    public List<PhotosDTO> getPhotos() {
        return photosRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(photos -> modelMapper.map(photos, PhotosDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("saveTodos")
    public List<TodosDTO> saveTodos(@RequestBody List<TodosDTO> todosDTOs) {
        return todosDTOs.stream()
                .map(entityService::saveTodos)
                .collect(Collectors.toList());
    }

    @GetMapping("getTodos")
    public List<TodosDTO> getTodos() {
        return todosRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(todos -> modelMapper.map(todos, TodosDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("saveUsers")
    public List<UsersDTO> saveUsers(@RequestBody List<UsersDTO> usersDTOs) {
        return usersDTOs.stream()
                .map(entityService::saveUsers)
                .collect(Collectors.toList());
    }

    @GetMapping("getUsers")
    public List<UsersDTO> getUsers() {
        return usersRepository.findAll(Sort.by(Sort.Direction.ASC, "id")).stream()
                .map(this::mapUserToDTO)
                .collect(Collectors.toList());
    }

    private UsersDTO mapUserToDTO(Users user) {
        UsersDTO dto = modelMapper.map(user, UsersDTO.class);

        if (user.getAddress() != null) {
            UsersDTO.AddressDTO addressDTO = new UsersDTO.AddressDTO();
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setSuite(user.getAddress().getSuite());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setZipcode(user.getAddress().getZipcode());

            if (user.getAddress().getGeo() != null) {
                UsersDTO.GeoDTO geoDTO = new UsersDTO.GeoDTO();
                geoDTO.setLat(user.getAddress().getGeo().getLat());
                geoDTO.setLng(user.getAddress().getGeo().getLng());
                addressDTO.setGeoDTO(geoDTO);
            }

            dto.setAddress(addressDTO);
        }

        return dto;
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

    @PostMapping("/updateEntity")
    public ResponseEntity<?> updateEntity(@RequestParam String type, @RequestBody Map<String, Object> payload) {
        try {
            Object updatedDto = entityService.updateEntity(type, payload);
            return ResponseEntity.ok(updatedDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
