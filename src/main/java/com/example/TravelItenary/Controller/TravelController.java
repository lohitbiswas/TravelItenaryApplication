package com.example.TravelItenary.Controller;



import com.example.TravelItenary.Entity.Destination;
import com.example.TravelItenary.Service.DestinationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/travel")
public class TravelController {

    @Autowired
    private DestinationService destinationService;

    // Endpoint to retrieve all destinations
    @GetMapping("/destinations")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Endpoint to retrieve a specific destination by ID
    @GetMapping("/destinations/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable String id) {
        Optional<Destination> destination = destinationService.getDestinationById(id);
        return destination.map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint to search for destinations by name
    @GetMapping("/destinations/search/{name}")
    public ResponseEntity<List<Destination>> searchDestinationsByName(@PathVariable String name) {
        List<Destination> destinations = destinationService.getDestinationsByName(name);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Endpoint to search for destinations by attraction
    @GetMapping("/destinations/category/{categories}")
    public ResponseEntity<List<Destination>> getDestinationByCategories(@PathVariable String categories) {

        List<Destination> destinations = destinationService.getDestinationByCategories(categories);
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    // Endpoint to create a new destination
    @PostMapping("/destinations")
    public ResponseEntity<Destination> createDestination(@RequestBody Destination destination) {
        Destination createdDestination = destinationService.createDestination(destination);
        return new ResponseEntity<>(createdDestination, HttpStatus.CREATED);
    }

    // Endpoint to update an existing destination
    @PutMapping("/destinations/{id}")
    public ResponseEntity<Destination> updateDestination(@PathVariable String id, @RequestBody Destination destination) {
        Destination updatedDestination = destinationService.updateDestination(id, destination);
        return updatedDestination != null ? new ResponseEntity<>(updatedDestination, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint to delete a destination
    @DeleteMapping("/destinations/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable String id) {
        destinationService.deleteDestination(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Placeholder for itinerary-related endpoints
    // Example: @PostMapping("/itineraries")
    // Example: @PutMapping("/itineraries/{id}")
    // Example: @GetMapping("/itineraries/{id}/recommendations")

    // Further implementation would go here based on the requirements for itineraries and recommendations

}

