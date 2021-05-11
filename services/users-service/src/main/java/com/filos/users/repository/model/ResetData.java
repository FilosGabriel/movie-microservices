package com.filos.users.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
@AllArgsConstructor(staticName = "of")
public class ResetData {
    @Id
    private String id;
    @Indexed(expireAfter = "24h")
    private String secret;
}
