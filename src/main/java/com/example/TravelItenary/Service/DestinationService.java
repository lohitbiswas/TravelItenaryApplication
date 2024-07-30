package com.example.TravelItenary.Service;



import com.example.TravelItenary.Entity.Destination;
import com.example.TravelItenary.Repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    // Create a new destination
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    // Get all destinations
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    // Get a specific destination by ID
    public Optional<Destination> getDestinationById(String id) {
        return destinationRepository.findById(id);
    }

    // Get destinations by name (case-insensitive)
    public List<Destination> getDestinationsByName(String name) {
        return destinationRepository.findByNameContainingIgnoreCase(name);
    }

    //get destination place by category
    public List<Destination> getDestinationByCategories(String categories) {
        return destinationRepository.getDestinationByCategories(categories);
    }
    // Update a destination
    public Destination updateDestination(String id, Destination destination) {
        if (destinationRepository.existsById(id)) {
            destination.setId(id); // Ensure the destination has the correct ID
            return destinationRepository.save(destination);
        } else {
            // Handle the case where the destination does not exist
            return null; // Or throw an exception
        }
    }

    // Delete a destination
    public void deleteDestination(String id) {
        destinationRepository.deleteById(id);
    }
}
