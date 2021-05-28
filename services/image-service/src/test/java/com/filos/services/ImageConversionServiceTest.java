package com.filos.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;

@Tags({ @Tag("conversion") })
@DisplayName("When conversion service is called")
class ImageConversionServiceTest {

    @Test
    @SneakyThrows
    @DisplayName("it should convert to webp")
    public void convertImage() {
        ImageConversionService imageConversionService = new ImageConversionService();

        ClassLoader classLoader = getClass().getClassLoader();
        Path path = new File(classLoader.getResource("test1.jpg")
                                        .getFile()).toPath();
        var mockImage = Files.readAllBytes(path);

        byte[] webp = imageConversionService.convertToWebp(mockImage);
        Assertions.assertTrue(webp.length < mockImage.length);

    }
}