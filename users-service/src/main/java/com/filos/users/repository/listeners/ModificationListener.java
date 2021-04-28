package com.filos.users.repository.listeners;

import com.filos.users.repository.model.User;
import com.filos.users.services.notifiers.api.ExternalNotifier;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@RequiredArgsConstructor
public class ModificationListener extends AbstractMongoEventListener<User> {

    private final ExternalNotifier notifier;

    @Override
    public void onAfterSave(AfterSaveEvent<User> event) {
        notifier.createUser(event.getSource().getId());
        super.onAfterSave(event);
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<User> event) {
        notifier.deleteUser(event.getSource().getString("id"));
        super.onAfterDelete(event);
    }
}
