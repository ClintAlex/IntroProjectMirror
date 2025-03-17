package com.internship.introproject;

import com.internship.introproject.dto.*;
import com.internship.introproject.entity.*;
import com.internship.introproject.repository.*;
import com.internship.introproject.service.EntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@Transactional
@ExtendWith(MockitoExtension.class)
class EntityServiceTest {

    @Mock
    private AlbumsRepository albumsRepository;

    @Mock
    private CommentsRepository commentsRepository;

    @Mock
    private PhotosRepository photosRepository;

    @Mock
    private PostsRepository postsRepository;

    @Mock
    private TodosRepository todosRepository;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EntityService entityService;

    @Test
    public void testSaveAlbum_Success() {
        AlbumsDTO albumsDTO = new AlbumsDTO();
        albumsDTO.setId(99999L);
        albumsDTO.setUserId(99999);
        albumsDTO.setTitle("Test Album");

        Albums album = new Albums(99999L, 99999, "Test Album");

        when(albumsRepository.existsById(99999L)).thenReturn(false);
        when(modelMapper.map(albumsDTO, Albums.class)).thenReturn(album);
        when(albumsRepository.save(album)).thenReturn(album);
        when(modelMapper.map(album, AlbumsDTO.class)).thenReturn(albumsDTO);

        AlbumsDTO savedAlbum = entityService.saveAlbums(albumsDTO);

        assertNotNull(savedAlbum);
        assertEquals(albumsDTO.getTitle(), savedAlbum.getTitle());
        verify(albumsRepository, times(1)).save(album);

        System.out.println("testSaveAlbum_Success completed successfully!");
    }

    @Test
    public void testSaveAlbum_AlreadyExists() {
        AlbumsDTO albumsDTO = new AlbumsDTO();
        albumsDTO.setId(99999L);

        when(albumsRepository.existsById(99999L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.saveAlbums(albumsDTO));
        assertEquals("Album med id 99999 findes allerede", exception.getMessage());

        System.out.println("testSaveAlbum_AlreadyExists completed successfully!");
    }

    @Test
    public void testSaveComments_Success() {
        CommentsDTO commentsDTO = new CommentsDTO();
        commentsDTO.setId(99999L);
        commentsDTO.setPostId(99999);
        commentsDTO.setName("Test Name");
        commentsDTO.setEmail("test@example.com");
        commentsDTO.setBody("Test comment body");

        Comments comment = new Comments(99999L, 99999, "Test Name", "test@example.com", "Test comment body");

        when(commentsRepository.existsById(99999L)).thenReturn(false);
        when(modelMapper.map(commentsDTO, Comments.class)).thenReturn(comment);
        when(commentsRepository.save(comment)).thenReturn(comment);
        when(modelMapper.map(comment, CommentsDTO.class)).thenReturn(commentsDTO);

        CommentsDTO savedComment = entityService.saveComments(commentsDTO);

        assertNotNull(savedComment);
        assertEquals(commentsDTO.getName(), savedComment.getName());
        verify(commentsRepository, times(1)).save(comment);

        System.out.println("testSaveComments_Success completed successfully!");
    }

    @Test
    public void testSaveComments_AlreadyExists() {
        CommentsDTO commentsDTO = new CommentsDTO();
        commentsDTO.setId(99999L);

        when(commentsRepository.existsById(99999L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.saveComments(commentsDTO));
        assertEquals("Kommentar med id 99999 findes allerede", exception.getMessage());

        System.out.println("testSaveComments_AlreadyExists completed successfully!");
    }


    @Test
    public void testSavePhotos_Success() {
        PhotosDTO photosDTO = new PhotosDTO();
        photosDTO.setId(99999L);
        photosDTO.setAlbumId(99999);
        photosDTO.setTitle("Test Photo");
        photosDTO.setUrl("http://test.com/photo.jpg");
        photosDTO.setThumbnailUrl("http://test.com/thumb.jpg");

        Photos photo = new Photos(99999L, 99999, "Test Photo", "http://test.com/photo.jpg", "http://test.com/thumb.jpg");

        when(photosRepository.existsById(99999L)).thenReturn(false);
        when(modelMapper.map(photosDTO, Photos.class)).thenReturn(photo);
        when(photosRepository.save(photo)).thenReturn(photo);
        when(modelMapper.map(photo, PhotosDTO.class)).thenReturn(photosDTO);

        PhotosDTO savedPhoto = entityService.savePhotos(photosDTO);

        assertNotNull(savedPhoto);
        assertEquals(photosDTO.getTitle(), savedPhoto.getTitle());
        verify(photosRepository, times(1)).save(photo);

        System.out.println("testSavePhotos_Success completed successfully!");
    }

    @Test
    public void testSavePhotos_AlreadyExists() {
        PhotosDTO photosDTO = new PhotosDTO();
        photosDTO.setId(99999L);

        when(photosRepository.existsById(99999L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.savePhotos(photosDTO));
        assertEquals("Photo med id 99999 findes allerede", exception.getMessage());

        System.out.println("testSavePhotos_AlreadyExists completed successfully!");
    }


    @Test
    public void testSavePosts_Success() {
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setId(99999L);
        postsDTO.setUserId(99999);
        postsDTO.setTitle("Test Post");
        postsDTO.setBody("This is a test post.");

        Posts post = new Posts(99999L, 99999, "Test Post", "This is a test post.");

        when(postsRepository.existsById(99999L)).thenReturn(false);
        when(modelMapper.map(postsDTO, Posts.class)).thenReturn(post);
        when(postsRepository.save(post)).thenReturn(post);
        when(modelMapper.map(post, PostsDTO.class)).thenReturn(postsDTO);

        PostsDTO savedPost = entityService.savePosts(postsDTO);

        assertNotNull(savedPost);
        assertEquals(postsDTO.getTitle(), savedPost.getTitle());
        verify(postsRepository, times(1)).save(post);

        System.out.println("testSavePosts_Success completed successfully!");
    }

    @Test
    public void testSavePosts_AlreadyExists() {
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setId(99999L);

        when(postsRepository.existsById(99999L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.savePosts(postsDTO));
        assertEquals("Post med id 99999 findes allerede", exception.getMessage());

        System.out.println("testSavePosts_AlreadyExists completed successfully!");
    }


    @Test
    public void testSaveTodos_Success() {
        TodosDTO todosDTO = new TodosDTO();
        todosDTO.setId(99999L);
        todosDTO.setUserId(99999);
        todosDTO.setTitle("Test Todo");
        todosDTO.setCompleted(true);

        Todos todo = new Todos(99999L, 99999, "Test Todo", true);

        when(todosRepository.existsById(99999L)).thenReturn(false);
        when(modelMapper.map(todosDTO, Todos.class)).thenReturn(todo);
        when(todosRepository.save(todo)).thenReturn(todo);
        when(modelMapper.map(todo, TodosDTO.class)).thenReturn(todosDTO);

        TodosDTO savedTodo = entityService.saveTodos(todosDTO);

        assertNotNull(savedTodo);
        assertEquals(todosDTO.getTitle(), savedTodo.getTitle());
        verify(todosRepository, times(1)).save(todo);

        System.out.println("testSaveTodos_Success completed successfully!");
    }

    @Test
    public void testSaveTodos_AlreadyExists() {
        TodosDTO todosDTO = new TodosDTO();
        todosDTO.setId(99999L);

        when(todosRepository.existsById(99999L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.saveTodos(todosDTO));
        assertEquals("Todo med id 99999 findes allerede", exception.getMessage());

        System.out.println("testSaveTodos_AlreadyExists completed successfully!");
    }


    @Test
    public void testSaveUsers_Success() {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(99999L);
        usersDTO.setName("Test User");
        usersDTO.setUsername("testuser");
        usersDTO.setEmail("test@example.com");

        Users user = new Users(99999L, "Test User", "testuser", "test@example.com", null, "123456789", "test.com", null);

        when(usersRepository.existsById(99999L)).thenReturn(false);
        when(modelMapper.map(usersDTO, Users.class)).thenReturn(user);
        when(usersRepository.save(user)).thenReturn(user);
        when(modelMapper.map(user, UsersDTO.class)).thenReturn(usersDTO);

        UsersDTO savedUser = entityService.saveUsers(usersDTO);

        assertNotNull(savedUser);
        assertEquals(usersDTO.getName(), savedUser.getName());
        verify(usersRepository, times(1)).save(user);

        System.out.println("testSaveUsers_Success completed successfully!");
    }

    @Test
    public void testSaveUsers_AlreadyExists() {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(99999L);

        when(usersRepository.existsById(99999L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.saveUsers(usersDTO));
        assertEquals("Users med id 99999 findes allerede", exception.getMessage());

        System.out.println("testSaveUsers_AlreadyExists completed successfully!");
    }
}
