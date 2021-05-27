package com.filos.web.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filos.services.ImageService;
import com.filos.services.dto.ImageInformation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @GetMapping(value = "/{xSize}/{ySize}/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(final ImageInformation imageInfo) {
        return ResponseEntity.ok()
                             .contentType(imageInfo.asWebp() ? MediaType.parseMediaType("image/webp") : MediaType.IMAGE_JPEG)
                             .body(imageService.getImage(imageInfo));
    }
}
