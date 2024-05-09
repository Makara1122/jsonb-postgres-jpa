package org.example.hybernatev6jsonbjpa.restcontroller;

import lombok.RequiredArgsConstructor;
import org.example.hybernatev6jsonbjpa.domain.Address;
import org.example.hybernatev6jsonbjpa.domain.User;
import org.example.hybernatev6jsonbjpa.repo.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestCotroller {
    private final UserRepository userRepository;

    @PostMapping("")
    public String createUser(@RequestBody User user) {
        User user1 = new User();
        user1.setUserName(user.getUserName());
        userRepository.save(user1);

        return "User created";
    }

    @GetMapping("")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/city/{city}")
    public List<User> getUsersByCity(@PathVariable String city) {
        return userRepository.findByCityInUserName(city);
    }


    @PutMapping("/zipCode/{id}")
    public String updateZipCode(@PathVariable String id, @RequestParam String zipCode) {
        userRepository.updateZipCode(zipCode, id);
        return "Zip code updated";
    }

    @DeleteMapping("/city/{city}")
    public String deleteUserByCity(@PathVariable String city) {
        userRepository.deleteById(city);
        return "User deleted";
    }
}
