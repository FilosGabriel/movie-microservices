package com.filos.services.dto;

import lombok.Data;

@Data
public class ImageInformation {
    private final String imageName;
    private final int xSize;
    private final int ySize;
    public static final String ORIGINAL = "original";
    public static final String ORIGINAL_JPG = "original.jpg";

    @Override
    public String toString() {
        return "%dx%d".formatted(xSize, ySize);
    }

    public String getId() {
        return imageName.split("\\.")[0];
    }

    public String nameForSave() {
        return getSize() + ".jpg";
    }

    public String[] searchName() {
        return new String[] {
                getId(), getSize()+".jpg"
        };
    }

    public boolean asWebp() {
        return imageName.split("\\.")[1].equals("webp");
    }

    public String getSize() {
        return "%dx%d".formatted(xSize, ySize);
    }

    public Object[] debug() {
        return new Object[] {
                imageName, xSize, ySize
        };
    }
}
