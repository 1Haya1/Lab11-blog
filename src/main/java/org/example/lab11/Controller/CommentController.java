package org.example.lab11.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiResponse;
import org.example.lab11.Model.Comment;
import org.example.lab11.Service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;


@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get")
    public ResponseEntity getAllComment(){
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }


    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id,@RequestBody @Valid Comment comment,Errors errors){
        if(errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        commentService.updateComment(id, comment);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/comment/{post_id}")
    public ResponseEntity getAllCommentsByPostId(@PathVariable Integer post_Id) {
        return ResponseEntity.status(200).body(commentService.getAllCommentsByPostId(post_Id));
    }

    @GetMapping("/comment/date/{commentDate}")
    public ResponseEntity getCommentsByCommentDate(@PathVariable LocalDate commentDate) {
        return ResponseEntity.status(200).body(commentService.getCommentsByCommentDate(commentDate));
    }



}






