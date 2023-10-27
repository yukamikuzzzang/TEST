package com.example.test.folder;

import com.example.test.folder.vo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final List<User> users = new ArrayList<>();
    private final JwtUtil jwtUtil = new JwtUtil();

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        users.add(user);
        return "User registered successfully.";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        User storedUser = users.stream()
                .filter(u -> u.getName().equals(user.getName()) && u.getPassword().equals(user.getPassword()))
                .findFirst()
                        .orElse(new User());

       /* if (storedUser != null) {
            return jwtUtil.generateToken(user.getName());
        } else {
            return "Invalid credentials";
        }*/

    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst()
                .orElse(new User());
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User updatedUser) {
        User userToUpdate = users.stream()
                .filter(user -> user.getName().equals(updatedUser.getName()))
                .findFirst()
                .orElse(new User());

        if (userToUpdate != null) {
            userToUpdate.setPassword(updatedUser.getPassword());
            /*userToUpdate.setEmail(updatedUser.getEmail());*/
            return "User updated successfully.";
        } else {
            return "User not found";
        }
    }

    @DeleteMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        User userToDelete = users.stream()
                .filter(user -> user.getName().equals(username))
                .findFirst()
                .orElse(new User());

        if (userToDelete != null) {
            users.remove(userToDelete);
            return "User deleted successfully.";
        } else {
            return "User not found";
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return users;
    }
}

