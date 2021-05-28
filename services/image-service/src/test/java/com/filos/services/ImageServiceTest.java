package com.filos.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.filos.moviedb.ImageTheMovieDB;
//import com.filos.services.dto.SizeImage;

@ExtendWith(MockitoExtension.class)
@DisplayName("When image service ")
@Disabled
class ImageServiceTest {

//    private final SizeImage size = new SizeImage("", 10, 10);
    private static final String fileName = "test1.jpg";

    @Mock
    private ImageProcessor imageProcessor;
    @Mock
    private ImageTheMovieDB webClient;
    @Mock
    private ImageRepository imageRepository;
    //    Subject
    private ImageService imageService;
    private byte[] mockImage;

    @BeforeEach
    public void init() throws IOException {
        //        imageService = new ImageService(imageRepository, imageProcessor, webClient);

        ClassLoader classLoader = getClass().getClassLoader();
        Path path = new File(classLoader.getResource(fileName)
                                        .getFile()).toPath();
        mockImage = Files.readAllBytes(path);

    }

    @Test
    @DisplayName(" load image from local storage it should return the file from storage ")
    public void loadFromLocalStorage() {
        // Given
//        Mockito.lenient()
//               .when(imageRepository.tryToGetLocalImage(fileName, size.toString()))
//               .thenReturn(Optional.of(mockImage));

        // When
        //        byte[] imageReturnedByService = imageService.getImage( size);
        // Then
    }
}