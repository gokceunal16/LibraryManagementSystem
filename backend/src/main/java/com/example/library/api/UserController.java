package com.example.library.api;

import com.example.library.entity.User;
import com.example.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/user")
    @ResponseBody
    public void createUser(@RequestBody User user){

        userService.createUser(user);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> getUsers(){

        return userService.getUsers();
    }

    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public User findById(@PathVariable("id") int id){

        return userService.findById(id);
    }

    @PutMapping(value = "/user/{id}")
    @ResponseBody
    public void updateUser(@PathVariable("id") int id, @RequestBody User updatedUser){

        userService.updateUser(id, updatedUser);
    }
}
