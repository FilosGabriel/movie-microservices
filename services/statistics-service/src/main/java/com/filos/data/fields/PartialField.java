package com.filos.data.fields;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PartialField {
    private final String value;

    public String mapped(PartialFieldType type) {
        return type.value + value;
    }

    @RequiredArgsConstructor
    static enum PartialFieldType {
        GENRE("GENRE_NO_FOR_");
        private final String value;
    }
}
