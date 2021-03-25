package com.filos.api.data;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Tenant{
    protected String id;
    protected List<Boolean> permission;

    public String getValuesPermissions(){
        return permission.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
