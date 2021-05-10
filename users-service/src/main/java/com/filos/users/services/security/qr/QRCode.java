package com.filos.users.services.security.qr;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class QRCode {
    private final String content;
    private final int width;
    private final int height;

    public static QRCode of(@Size(min = 10) String content, @Min(100) int width, @Min(100) int height) {
        return new QRCode(content, width, height);
    }

    public static QRCode of(String content) {
        return of(content, 1200, 1200);
    }
}
