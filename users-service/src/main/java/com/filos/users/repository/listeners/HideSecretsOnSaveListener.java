package com.filos.users.repository.listeners;

import com.filos.users.repository.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(1)
public class HideSecretsOnSaveListener extends AbstractMongoEventListener<User> {
    @Qualifier("sha")
    private final DigestUtils digestUtils;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {

        User source = event.getSource();
        String password = source.getPassword();
        String secretKey = source.getSecurity().getSecretKey();
        if (StringUtils.isNotBlank(secretKey)) {
            source.getSecurity().setSecretKey(secretKey); //TODO a encryption
        }
        source.setPassword(digestUtils.digestAsHex(password));

        super.onBeforeConvert(event);
    }
}