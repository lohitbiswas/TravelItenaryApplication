package com.example.TravelItenary.Controller;


import com.example.TravelItenary.Entity.Itinerary;
import com.example.TravelItenary.Service.ItineraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Itinerary")
public class ItineraryController {

    @Autowired
    private ItineraryService itineraryService;

    // Endpoint to create a new itinerary
    @PostMapping("/itineraries")
    public ResponseEntity<Itinerary> createItinerary(@RequestBody Itinerary itinerary) {
        Itinerary createdItinerary = itineraryService.createItinerary(itinerary);
        return new ResponseEntity<>(createdItinerary, HttpStatus.CREATED);
    }

    // Endpoint to retrieve an itinerary by ID
    @GetMapping("/itineraries/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable String id) {
        Optional<Itinerary> itinerary = itineraryService.getItineraryById(id);
        return itinerary.map(i -> new ResponseEntity<>(i, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to retrieve itineraries by user ID
    @GetMapping("/itineraries/user/{userId}")
    public ResponseEntity<List<Itinerary>> getItinerariesByUserId(@PathVariable String userId) {
        List<Itinerary> itineraries = itineraryService.getItinerariesByUserId(userId);
        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }

    @GetMapping("/itineraries/destination/{destinationId}")
    public ResponseEntity<List<Itinerary>> getItinerariesByDestinationId(@PathVariable String destinationId) {
        List<Itinerary> itineraries = itineraryService.getItinerariesByDestinationId(destinationId);
        return new ResponseEntity<>(itineraries, HttpStatus.OK);
    }

    // Endpoint to update an existing itinerary
    @PutMapping("/itineraries/{id}")
    public ResponseEntity<Itinerary> updateItinerary(@PathVariable String id, @RequestBody Itinerary itinerary) {
        Itinerary updatedItinerary = itineraryService.updateItinerary(id, itinerary);
        return updatedItinerary != null ? new ResponseEntity<>(updatedItinerary, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint to delete an itinerary
    @DeleteMapping("/itineraries/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable String id) {
        itineraryService.deleteItinerary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

