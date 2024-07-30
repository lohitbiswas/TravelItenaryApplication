package com.example.TravelItenary.Repository;



import com.example.TravelItenary.Entity.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends MongoRepository<Destination, String> {
    // Custom query methods can be added here if needed
    List<Destination> findByNameContainingIgnoreCase(String name);
    List<Destination> getDestinationByCategories(String categories);
}
