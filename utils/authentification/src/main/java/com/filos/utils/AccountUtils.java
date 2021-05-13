package com.filos.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountUtils {
    public boolean accountExpired(LocalDate lastModification) {
        return LocalDate.now().until(lastModification, ChronoUnit.YEARS) > 1;
    }
}
