package com.example.TravelItenary.Service;



import com.example.TravelItenary.Entity.Itinerary;
import com.example.TravelItenary.Repository.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    public Itinerary createItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public Optional<Itinerary> getItineraryById(String id) {
        return itineraryRepository.findById(id);
    }

    public List<Itinerary> getItinerariesByUserId(String userId) {
        return itineraryRepository.findByUserId(userId);
    }

    public Itinerary updateItinerary(String id, Itinerary itinerary) {
        if (itineraryRepository.existsById(id)) {
            itinerary.setId(id);
            return itineraryRepository.save(itinerary);
        } else {
            return null; // Or throw an exception
        }
    }

    public void deleteItinerary(String id) {
        itineraryRepository.deleteById(id);
    }
}

