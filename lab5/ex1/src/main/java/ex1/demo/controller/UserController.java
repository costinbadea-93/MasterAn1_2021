package ex1.demo.controller;

import ex1.demo.model.User;
import ex1.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> usersList(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u = userService.save(user);
        return ResponseEntity.created(URI.create("/users/byId/" + u.getId())).body(u);
    }

    @DeleteMapping("/deleteById/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable int userId){
        userService.deleteById(userId);
        return ResponseEntity.ok().body("User with id " + userId + " was deleted with success!!!");
    }

    @GetMapping("/users/byId/{userId}")
    public ResponseEntity<User> userById(@PathVariable int userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }
}
