package com.example.TravelItenary.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @Autowired
    private String Id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
