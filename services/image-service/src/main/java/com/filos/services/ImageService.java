package com.filos.services;

import org.springframework.stereotype.Service;

import com.filos.moviedb.ImageTheMovieDB;
import com.filos.services.dto.ImageInformation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {
    private final ImageRepository repository;
    private final ImageProcessor imageProcessor;
    private final ImageTheMovieDB theMovieDBApi;
    private final ImageConversionService conversionService;

    public byte[] getImage(ImageInformation imageInformation) {
        var imageData = repository.tryToGetLocalImage(imageInformation)
                                  .orElseGet(() -> makeANewImage(imageInformation));
        return imageInformation.asWebp() ? conversionService.convertToWebp(imageData) : imageData;
    }

    private byte[] makeANewImage(ImageInformation imageInformation) {
        var imageBytes = repository.loadOriginal(imageInformation.getId())
                                   .orElseGet(() -> loadOriginalImageFromApi(imageInformation));
        return transformOriginalImage(imageInformation, imageBytes);
    }

    private byte[] loadOriginalImageFromApi(ImageInformation imageInformation) {
        var imageBytes = theMovieDBApi.getImage(imageInformation.getId());
        repository.saveImage(imageInformation.getId(), ImageInformation.ORIGINAL_JPG, imageBytes);
        return imageBytes;
    }

    private byte[] transformOriginalImage(ImageInformation imageInfo, byte[] imageBytes) {
        log.info("Transforming image {} from original size to {}x{}", imageInfo.debug());
        var imageResized = imageProcessor.resize(imageBytes, imageInfo);
        repository.saveImage(imageInfo.getId(), imageInfo.nameForSave(), imageResized);
        return imageResized;
    }
}
