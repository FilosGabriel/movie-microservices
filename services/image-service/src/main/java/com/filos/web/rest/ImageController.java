package com.filos.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filos.services.ImageService;
import com.filos.services.dto.SizeImage;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{imageId}")
    public byte[] getImage(@PathVariable(name = "imageId") final String imageId, SizeImage sizeImage) {
        return imageService.getImage(imageId, sizeImage);
    }
}
