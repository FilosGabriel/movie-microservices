package com.filos.users.web.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "with")
public class TwoResponse {
    private final String method;
    private final String status;
}
