package com.filos.users.services.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.filos.users.repository.model.User;
import com.filos.users.utils.other.Consumer;
import com.filos.users.web.exceptions.MissingRequiredInformation;
import lombok.NonNull;

@Component
public class UserValidationSecurity {
    public void checkIfHasAllNecessaryDataForSMS2FA(@NonNull User user) {

        testCond(() -> StringUtils.isNotBlank(user.getContactInfo().getPhoneNumber()), "Phone number is not confirmed.");
        testCond(() -> StringUtils.isNotBlank(user.getContactInfo().getEmail()), "Phone number is not confirmed.");
        testCond(() -> !user.getContactInfo().isPhoneConfirm(), "Phone number is not confirmed.");
        testCond(() -> !user.getContactInfo().isEmailConfirm(), "Email is not confirmed.");
    }

    private void testCond(Consumer<Boolean> consumer, String message) {
        if (consumer.test()) {
            throw new MissingRequiredInformation(message);
        }
    }

}
