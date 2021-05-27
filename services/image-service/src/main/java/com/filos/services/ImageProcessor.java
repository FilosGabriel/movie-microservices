package com.filos.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.filos.services.dto.ImageInformation;
import lombok.SneakyThrows;
import net.coobird.thumbnailator.Thumbnailator;

@Service
public class ImageProcessor {

    @SneakyThrows
    public byte[] resize(byte[] data, ImageInformation size) {
        InputStream inputStream = new ByteArrayInputStream(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Thumbnailator.createThumbnail(inputStream, outputStream, size.getXSize(), size.getYSize());
        return outputStream.toByteArray();
    }

    public byte[] getThumbnail(byte[] data) {
        return null;
    }
}
