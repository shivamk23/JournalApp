package com.companyproject.journalApp.controller;

import com.companyproject.journalApp.api.response.WeatherResponse;
import com.companyproject.journalApp.entity.User;
import com.companyproject.journalApp.repository.UserRepository;
import com.companyproject.journalApp.services.UserService;
import com.companyproject.journalApp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUsername(userName);
        if(userInDb!=null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewEntry(userInDb);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> greetings() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse = weatherService.getWeather("Delhi");
        String greeting = "Hi " + authentication.getName();

        if (weatherResponse != null && weatherResponse.getData().get(0)!= null) {
            greeting += ", Weather feels like " + weatherResponse.getData().get(0).getCityName()+" "+weatherResponse.getData().get(0).getTemp();
        } else {
            greeting += ", but the weather information is currently unavailable.";
        }

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}
