package uz.pdp.g33springbootdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.g33springbootdatajpa.domain.User;
import uz.pdp.g33springbootdatajpa.repo.UserRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping
    public User update(@RequestBody User userUpdate){
        User user = userRepository.findById(userUpdate.getId()).orElse(null);
        if (user == null){
            return null;
        }

        if (userUpdate.getUsername() != null){
            user.setUsername(userUpdate.getUsername());
        }

        if (userUpdate.getEmail() != null) {
            user.setEmail(userUpdate.getEmail());
        }

        if (userUpdate.getPassword() != null){
            user.setPassword(userUpdate.getPassword());
        }

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return "Successfully deleted";
    }
}