package com.example.library.api;

import com.example.library.entity.UserRole;
import com.example.library.service.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserRoleController {
    private final UserRoleService user_roleService;

    public UserRoleController(UserRoleService user_roleService) {
        this.user_roleService = user_roleService;
    }


    @PostMapping(value = "/user_role")
    @ResponseBody
    public void createUserRole(@RequestBody UserRole user_role){

        user_roleService.createUserRole(user_role);
    }

    @GetMapping(value = "/user_roles")
    @ResponseBody
    public List<UserRole> getUserRoles(){

        return user_roleService.getUserRoles();
    }

    @GetMapping(value = "/user_role/{id}")
    @ResponseBody
    public UserRole findById(@PathVariable("id") int id){

        return user_roleService.findById(id);
    }

    @PutMapping(value = "/user_role/{id}")
    @ResponseBody
    public void updateUserRole(@PathVariable("id") int id, @RequestBody UserRole updatedUserRole){

        user_roleService.updateUserRole(id, updatedUserRole);
    }
}
