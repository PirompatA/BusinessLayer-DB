package com.kbtg.apidesign01.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @GetMapping("api/users")
    public List<User> getUsers(@RequestParam("active") Optional<Boolean> active) {
        return userService.getUsers(active);
    }

    @PostMapping("api/users")
    public User createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("api/users/{id}")
    public Optional<User> editUser(@PathVariable("id") int id, @RequestBody UserRequest request) {
        return userService.editUser(id, request);
    }

    @DeleteMapping("api/users/{id}")
    public List<User> deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }
}

record UserRequest(String name, int age) {
}

class User {
    private int id;
    private String name;
    private int age;
    private Boolean active;

    public User(int id, String name, int age, Boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}


