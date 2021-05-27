package com.filos.services;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import lombok.SneakyThrows;

@Service
public class ImageConversionService {
    @SneakyThrows
    public byte[] convertToWebp(byte[] data) {
        BufferedImage read = ImageIO.read(new ByteArrayInputStream(data));
        ByteArrayOutputStream byteOutput=new ByteArrayOutputStream();
        ImageIO.write(read,"webp",byteOutput);
        return byteOutput.toByteArray();

    }
}
