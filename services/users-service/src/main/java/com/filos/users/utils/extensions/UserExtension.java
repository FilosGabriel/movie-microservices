package com.filos.users.utils.extensions;

import java.util.function.Consumer;
import java.util.function.Supplier;

import com.filos.users.repository.model.User;
import com.filos.users.repository.status.SecurityLevel;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class UserExtension {
    public static Alternative checkSecurityLevel(User user, SecurityLevel level) {
        return new Alternative(user.getSecurity().getLevel() == level, user);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Alternative {
        private boolean shouldThrow;
        private User user;

        public void ifEqualsThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
            if (shouldThrow) {
                throw exceptionSupplier.get();
            }
        }

        public void doAction(Consumer<User> consumer) {
            consumer.accept(user);
        }
    }
}
