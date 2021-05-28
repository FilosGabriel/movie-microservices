package com.filos.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.filos.services.dto.ImageInformation;
import lombok.SneakyThrows;

class ImageProcessorTest {

    @Test
    @SneakyThrows
    public void testResize() {
        ImageProcessor imageProcessor = new ImageProcessor();

        ClassLoader classLoader = getClass().getClassLoader();
        Path path = new File(classLoader.getResource("test1.jpg")
                                        .getFile()).toPath();
        var mockImage = Files.readAllBytes(path);

        byte[] webp = imageProcessor.resize(mockImage, new ImageInformation("", 100, 100));
        Assertions.assertTrue(webp.length < mockImage.length);
    }

}