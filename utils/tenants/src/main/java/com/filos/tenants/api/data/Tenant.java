package com.filos.tenants.api.data;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

@Data
public class Tenant{
    protected String id;
    protected List<Boolean> permission;

    public String getValuesPermissions(){
        return permission.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }
}
