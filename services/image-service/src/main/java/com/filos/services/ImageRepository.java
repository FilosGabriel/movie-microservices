package com.filos.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.filos.tenants.config.ImageConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public class ImageRepository {

    private final ImageConfiguration imageConfiguration;

    @SneakyThrows
    public Optional<byte[]> getImage(String fileName, String size) {
        Path pathOfFile = Path.of(imageConfiguration.getSourcePath(), fileName, size);
        if (Files.exists(pathOfFile)) {
            return Optional.of(Files.readAllBytes(pathOfFile));
        }
        return Optional.empty();
    }

    @SneakyThrows
    @Async
    public void saveImage(String fileName, String size, byte[] data) {
        Path folderPath = Path.of(imageConfiguration.getSourcePath(), fileName);
        if (!Files.exists(folderPath)) {
            Files.createDirectory(folderPath);
        }
        Path filePath = Path.of(imageConfiguration.getSourcePath(), fileName, size);
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }

        Files.write(filePath, data);
    }
}
