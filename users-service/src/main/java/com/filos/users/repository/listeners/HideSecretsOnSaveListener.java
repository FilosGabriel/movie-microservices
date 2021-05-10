package com.filos.users.repository.listeners;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.filos.users.config.constants.Components;
import com.filos.users.repository.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Component
@RequiredArgsConstructor
public class HideSecretsOnSaveListener extends AbstractMongoEventListener<User> {
    @Qualifier(Components.Encryption.SHA)
    private final DigestUtils digestUtils;
    private final static String HIDE_PASSWORD = "Hiding password for user {}.";

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        User source = event.getSource();
        log.info(HIDE_PASSWORD, source.getContactInfo().getEmail());
        String password = source.getSecurity().getPassword();
        source.getSecurity().setPassword(digestUtils.digestAsHex(password));
        super.onBeforeConvert(event);
    }
}