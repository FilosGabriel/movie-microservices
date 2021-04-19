package com.filos.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.filos.api.clients.moviedb.ImageTheMovieDB;
import com.filos.services.dto.SizeImage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository repository;
    private final ImageProcessor imageProcessor;
    private final ImageTheMovieDB imageClient;

    public byte[] getImage(String fileId, SizeImage size) {
        Optional<byte[]> image = repository.getImage(fileId, size.toString());
        var imageBytes = image.orElseGet(() -> imageClient.getImage(fileId));
        repository.saveImage(fileId, SizeImage.ORIGINAL, imageBytes);
        var imageResized = imageProcessor.resize(imageBytes, size);
        repository.saveImage(fileId, size.toString(), imageResized);
        return imageResized;
    }

}
