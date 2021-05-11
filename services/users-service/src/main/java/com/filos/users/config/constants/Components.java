package com.filos.users.config.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Components {
    @UtilityClass
    public static class Encryption {
        public static final String SHA = "sha";
    }

    @UtilityClass
    public static class Validators {
        public static final String PASSWORD = "passwordValidator";
    }
}
