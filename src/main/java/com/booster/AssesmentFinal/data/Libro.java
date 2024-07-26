package com.booster.AssesmentFinal.data;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "libros")
@Data
public class Libro {

    @MongoId
    private String id;

    @Indexed(unique = true)
    private String nombre;
}
