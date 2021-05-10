package com.filos.api.outbound;

public interface EmailSender {
    void sendEmailCreatingAccount();

    void sendEmailDeleteAccount();

    void sendEmailChangePassword();

    void sendEmailResetPassword(String userId, String token);
}
