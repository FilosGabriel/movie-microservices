package com.filos.web.rest;

import com.google.common.util.concurrent.AbstractService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractBasicController{
    private final AbstractService service;
}
