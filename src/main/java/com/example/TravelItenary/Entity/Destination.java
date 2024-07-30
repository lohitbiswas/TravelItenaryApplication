package com.example.TravelItenary.Entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Document(collection = "destinations")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Destination {

    @Id
    private String id;

    private String name;
    private String location;
    private String description;
    private List<String> attractions;
    private String categories; // e.g., beach, mountains, city, etc.
}
