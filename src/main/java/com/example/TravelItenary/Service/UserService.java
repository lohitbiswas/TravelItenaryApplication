package com.example.TravelItenary.Service;



import com.example.TravelItenary.Entity.User;
import com.example.TravelItenary.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            // Handle the case where the user does not exist
            return null; // Or throw an exception
        }
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
