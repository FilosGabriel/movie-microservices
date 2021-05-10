package com.filos.users.services.user;

import org.springframework.stereotype.Service;

import com.filos.api.outbound.EmailSender;
import com.filos.users.repository.model.ResetData;
import com.filos.users.repository.model.User;
import com.filos.users.repository.mongo.UserRepositoryMongo;
import com.filos.users.services.security.password.ResetPasswordService;
import com.filos.users.web.exceptions.UserNotFound;
import com.filos.users.web.requests.ChangePasswordRequest;
import com.filos.users.web.requests.UserResetRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ManagementUserService {
    private final EmailSender emailSender;
    private final UserRepositoryMongo userRepository;
    private final ResetPasswordService resetPasswordService;

    public void sendResetLink(UserResetRequest resetRequest) {
        User user = userRepository.findByContactInfo_PhoneNumberOrContactInfo_Email(resetRequest.getContact(), resetRequest.getContact())
                                  .orElseThrow(UserNotFound::new);
        ResetData generateResetCode = resetPasswordService.generateResetCode(user);
        emailSender.sendEmailResetPassword(generateResetCode.getId(), generateResetCode.getSecret());
    }

    public void changePassword(@NonNull ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByContactInfo_Email(changePasswordRequest.getEmail())
                                  .orElseThrow(UserNotFound::new);
        user.getSecurity().setPassword(changePasswordRequest.getPassword());
        emailSender.sendEmailChangePassword();
    }
}
