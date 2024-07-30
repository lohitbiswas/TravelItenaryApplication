package com.example.TravelItenary.Entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Document(collection = "itineraries")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Itinerary {

    @Id
    private String id;

    private String userId;
    private String name;
    private List<String> destinations; // List of destination IDs
  //  private List<String> activities;   // List of activity descriptions or IDs
    private String startDate;
    private String endDate;
}

