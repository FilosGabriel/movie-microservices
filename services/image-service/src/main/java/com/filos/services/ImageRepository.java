package com.filos.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.filos.config.ImageConfiguration;
import com.filos.services.dto.ImageInformation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class ImageRepository {

    private final ImageConfiguration imageConfiguration;

    @SneakyThrows
    public Optional<byte[]> tryToGetLocalImage(ImageInformation imageInformation) {
        Path pathOfFile = Path.of(imageConfiguration.getSourcePath(), imageInformation.searchName());
        if (Files.exists(pathOfFile)) {
            return Optional.of(Files.readAllBytes(pathOfFile));
        }
        return Optional.empty();
    }

    @SneakyThrows
    public Optional<byte[]> loadOriginal(String fileName) {
        Path pathOfFile = Path.of(imageConfiguration.getSourcePath(), fileName, ImageInformation.ORIGINAL_JPG);
        if (Files.exists(pathOfFile)) {
            return Optional.of(Files.readAllBytes(pathOfFile));
        }
        return Optional.empty();
    }

    @SneakyThrows
    @Async
    public void saveImage(String idImage, String size, byte[] data) {
        Path folderPath = Path.of(imageConfiguration.getSourcePath(), idImage);
        if (!Files.exists(folderPath)) {
            Files.createDirectory(folderPath);
        }
        Path filePath = Path.of(imageConfiguration.getSourcePath(), idImage, size);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }

        Files.write(filePath, data);
    }
}
