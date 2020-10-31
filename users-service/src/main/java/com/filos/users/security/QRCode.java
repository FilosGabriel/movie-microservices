package com.filos.users.security;

import lombok.Data;

import static com.google.common.base.Preconditions.checkArgument;

@Data
public class QRCode {
    private final String content;
    private final int width;
    private final int height;

    public static QRCode of(String content, int width, int height) {
        checkArgument(width > 100);
        checkArgument(height > 100);
        checkArgument(content.length() > 10);
        return new QRCode(content, width, height);
    }

    public static QRCode of(String content) {
        return of(content, 200, 200);
    }
}
