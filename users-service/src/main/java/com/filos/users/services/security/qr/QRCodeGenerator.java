package com.filos.users.services.security.qr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Component
@AllArgsConstructor
public class QRCodeGenerator {
    private final QRCodeWriter writer;
    private final String PNG_FORMAT = "PNG";

    public String createQRCode() {
        String secret = Token.generateSecure(32);
        String message = OneTimePassword.format("filos", "1223", secret);
        QRCode code = QRCode.of(message);
        return getBase64QRCode(code);
    }

    private String getBase64QRCode(@NonNull QRCode code) {
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = writer.encode(
                    code.getContent(),
                    BarcodeFormat.QR_CODE,
                    code.getWidth(),
                    code.getHeight());
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, PNG_FORMAT, stream);
            return Base64.getEncoder().encodeToString(stream.toByteArray());
        } catch (WriterException | IOException e) {
            throw new RuntimeException();
        }

    }

    public static void main(String[] args) {
        QRCodeGenerator generator = new QRCodeGenerator(new QRCodeWriter());
        System.out.println(generator.createQRCode());
    }
}
