package org.example.lab11.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiResponse;
import org.example.lab11.Model.Post;

import org.example.lab11.Service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getAllPost(){
        return ResponseEntity.status(200).body(postService.getAllPost());
    }


    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id,@RequestBody @Valid Post post,Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        postService.updatePost(id, post);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }



    @GetMapping("/get-post/{user_Id}")
    public ResponseEntity getAllPostsByUserId(@PathVariable Integer user_Id){
        return ResponseEntity.status(200).body(postService.getAllPostsByUserId(user_Id));
    }

    @GetMapping("/get/{title}")
    public ResponseEntity getPostsByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(postService.getPostsByTitle(title));
    }

    @GetMapping("/post/{date}")
    public ResponseEntity getAllPostsBeforeDate(@PathVariable LocalDate date) {
        return ResponseEntity.status(200).body(postService.getAllPostsBeforeDate(date));
    }






}






