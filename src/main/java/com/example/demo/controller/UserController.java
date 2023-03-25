package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user_) {
        User res;
        if(user_.getLogin().length() > 0 && user_.getPassword().length() > 0) {
            res = userRepository.findByLoginAndPassword(user_.getLogin(), user_.getPassword());
            System.out.println((res));
            if(res == null) {
                User user = userRepository.save(new User(user_.getLogin(), user_.getPassword(), user_.getEmail()));
                return new ResponseEntity<>(user, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Użytkownik istnieje", HttpStatus.FOUND);
            }
        } else {
            return new ResponseEntity<>("Wprowadzone dane nie są odpowiedniej długości",HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @GetMapping("/list")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> logIn(@RequestBody User user_) {
        User res;
        LinkedHashMap<String, String> map_res = new LinkedHashMap<>();
        if(user_.getLogin().length() > 0 && user_.getPassword().length() > 0) {
            res = userRepository.findByLoginAndPassword(user_.getLogin(), user_.getPassword());
            map_res.put("msg","Konto nie istnieje lub podano błędne dane");

            if(res == null) return new ResponseEntity<>(map_res, HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(res, HttpStatus.FOUND);
        } else {
            map_res.put("msg","Wprowadzone dane nie są odpowiedniej długości");
            return new ResponseEntity<>(map_res,HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
