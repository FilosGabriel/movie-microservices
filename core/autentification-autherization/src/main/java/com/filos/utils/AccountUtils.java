package com.filos.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class AccountUtils {
    public boolean accountExpired(LocalDate lastModification) {
        return LocalDate.now().until(lastModification, ChronoUnit.YEARS) > 1;
    }
}
