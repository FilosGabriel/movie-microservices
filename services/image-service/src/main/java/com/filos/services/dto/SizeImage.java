package com.filos.services.dto;

import lombok.Data;

@Data
public class SizeImage {
    private final int xSize;
    private final int ySize;
    public static final String ORIGINAL = "original";

    @Override
    public String toString() {
        return "" + xSize + ":ySize=" + ySize;
    }
}
