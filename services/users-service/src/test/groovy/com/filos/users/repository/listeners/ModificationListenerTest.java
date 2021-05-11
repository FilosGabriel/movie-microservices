package com.filos.users.repository.listeners;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.bson.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;

import com.filos.users.repository.model.User;
import com.filos.users.services.notifiers.api.ExternalNotifier;
import com.filos.users.utils.generators.UsersGenerator;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
@DisplayName("When user is changed")
class ModificationListenerTest {

    @Mock
    ExternalNotifier notifier;
    // When
    private final Document document = Document.parse("{'id':'1'}");
    private final UsersGenerator generator = new UsersGenerator();

    @Test
    @DisplayName(" then it should notify that user was deleted.")
    public void testMethodDelete() {
        // Given
        ModificationListener modificationListener = new ModificationListener(notifier);
        modificationListener.onAfterDelete(new AfterDeleteEvent<>(document, null, null));
        // Then
        verify(notifier, times(1)).deleteUser("1");
    }

    @Test
    @DisplayName(" then it should notify that user was created.")
    public void testMethodCreate() {
        // Given
        ModificationListener modificationListener = new ModificationListener(notifier);
        User user = generator.createUser();
        // When
        modificationListener.onAfterSave(new AfterSaveEvent<>(user, null, null));
        // Then
        verify(notifier, times(1)).createUser(ArgumentMatchers.anyString());
    }
}