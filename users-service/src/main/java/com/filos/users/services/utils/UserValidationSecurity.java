package com.filos.users.services.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.filos.domain.dto.UserDto;
import com.filos.users.repository.model.User;
import com.filos.users.web.exceptions.MissingRequiredInformation;

@Component
public class UserValidationSecurity {
    public void checkIfHasAllNecessaryDataForSMS2FA(User user) {
        if (StringUtils.isBlank(user.getPhoneNumber())) {
            throw new MissingRequiredInformation("User doesn't have a phone number.");
        }
        if (!user.getSecurity().getDetailsSMS2FA().isConfirmed()) {
            throw new MissingRequiredInformation("Phone number is not confirmed.");
        }
    }
}
