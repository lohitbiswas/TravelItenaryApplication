package com.example.TravelItenary.Repository;

import com.example.TravelItenary.Entity.Itinerary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends MongoRepository<Itinerary, String> {
    List<Itinerary> findByUserId(String userId);
    List<Itinerary> findByDestinationId(String userId);
}
