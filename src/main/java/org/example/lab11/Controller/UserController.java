package org.example.lab11.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiResponse;
import org.example.lab11.Model.User;
import org.example.lab11.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUser(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }


    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user,Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }





    @GetMapping("/get-email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
            return ResponseEntity.status(200).body(userService.getUserByEmail(email));
        }


    @GetMapping("/get-registration-date/{registrationDate}")
    public ResponseEntity getUsersByRegistrationDate(@PathVariable LocalDate registrationDate) {

        return ResponseEntity.status(200).body(userService.getUsersByRegistrationDate(registrationDate));
    }





}






