package com.booster.AssesmentFinal.data;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "usuarios")
public class Usuario {

    @MongoId
    private String id;

    @Indexed(unique = true)
    private String email;

    private String password;

}
