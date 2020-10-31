package com.filos.users.users.utils.security;

import com.google.zxing.qrcode.QRCodeWriter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QRCodeGenerator {
    private final QRCodeWriter writer;

    public String createQRCode() {
        String secret = Token.generateSecure(32);
        String message = OneTimePassword.format("filos", "1223", secret);
        QRCode code = QRCode.of(message);
        return getBase64QRCode(code);
    }

    private String getBase64QRCode(QRCode code) {
//        BitMatrix bitMatrix = null;
//        try {
//            bitMatrix = writer.encode(
//                    code.getContent(),
//                    BarcodeFormat.QR_CODE,
//                    code.getWidth(),
//                    code.getHeight());
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", stream);
//            return Base64.getEncoder().encodeToString(stream.toByteArray());
            return null;
//        } catch (WriterException e) {
////            log.("Fail to create QRCode", e);
//            throw new RuntimeException();
//        }

    }

    public static void main(String[] args) {
        QRCodeGenerator generator = new QRCodeGenerator(new QRCodeWriter());
        System.out.println(generator.createQRCode());
    }
}
