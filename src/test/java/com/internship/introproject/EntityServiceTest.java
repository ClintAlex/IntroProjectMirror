package com.internship.introproject;

import com.internship.introproject.dto.AlbumsDTO;
import com.internship.introproject.entity.Albums;
import com.internship.introproject.repository.AlbumsRepository;
import com.internship.introproject.service.EntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EntityServiceTest {

    @Mock
    private AlbumsRepository albumsRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EntityService entityService;

    @Test
    void testSaveAlbum_Success() {
        AlbumsDTO albumsDTO = new AlbumsDTO();
        albumsDTO.setId(1L);
        albumsDTO.setUserId(100);
        albumsDTO.setTitle("Test Album");

        Albums album = new Albums(1L, 100, "Test Album");

        when(albumsRepository.existsById(1L)).thenReturn(false);
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
    void testSaveAlbum_AlreadyExists() {
        AlbumsDTO albumsDTO = new AlbumsDTO();
        albumsDTO.setId(1L);

        when(albumsRepository.existsById(1L)).thenReturn(true);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> entityService.saveAlbums(albumsDTO));
        assertEquals("Album med id 1 findes allerede", exception.getMessage());

        System.out.println("testSaveAlbum_AlreadyExists completed successfully!");
    }
}
