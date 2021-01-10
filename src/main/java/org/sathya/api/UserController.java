package org.sathya.api;

import lombok.extern.slf4j.Slf4j;
import org.sathya.user.User;
import org.sathya.user.UserException;
import org.sathya.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
      log.info("Saving the user detail: {} ",user);
      return userService.save(user);
    }

    @GetMapping
    public User getUser(@RequestParam("id") Long id) throws UserException {
        log.info("Fetching the user information for id: {} ",id);
        return userService.getUserById(id);
    }

    @GetMapping("/named-query")
    public User getUserByEmail(@RequestParam String email) {
        log.info("Fetch the user information based on email:{}",email);
        return userService.findByEmail(email);
    }

    @GetMapping("/native-query")
    public List<User> getUser(@RequestParam String name) {
        log.info("Fetch the user name: {}",name);
        return userService.getByUser(name);
    }
}
