package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiException;
import org.example.lab11.Model.Comment;
import org.example.lab11.Model.Post;
import org.example.lab11.Model.User;
import org.example.lab11.Repository.CommentRepository;
import org.example.lab11.Repository.PostRepository;
import org.example.lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository ;
    private final PostRepository postRepository ;
    public List<Comment> getAllComment(){
        return commentRepository.findAll();
    }


    public void addComment(Comment comment){
        User user = userRepository.findUserById(comment.getUser_Id());
        Post post = postRepository.findPostById(comment.getPost_Id());

        if (user == null || post == null){
            throw new ApiException("Invalid id");
        }
        comment.setCommentDate(LocalDate.now());
        comment.setUser_Id(comment.getUser_Id());
        comment.setPost_Id(comment.getPost_Id());
        commentRepository.save(comment);
    }



    public void updateComment(Integer id, Comment comment) {
        Comment c = commentRepository.findCommentById(id);

        if (c == null) {
            throw new ApiException("wrong id");
        }

        c.setCommentDate(comment.getCommentDate());
        c.setContent(comment.getContent());
        c.setUser_Id(comment.getUser_Id());
        c.setPost_Id(comment.getPost_Id());
        commentRepository.save(c);

    }


    public void deleteComment(Integer id) {
        Comment c = commentRepository.findCommentById(id);
        if (c == null) {
            throw new ApiException("wrong id");
        }
        commentRepository.delete(c);
    }


    public List<Comment> getAllCommentsByPostId(Integer post_Id) {
        return commentRepository.findCommentByPost_Id(post_Id);
    }

    public List<Comment> getCommentsByCommentDate(LocalDate commentDate) {
        List<Comment> comments = commentRepository.findByCommentDate(commentDate);
        if (comments.isEmpty()) {
            throw new ApiException("No comments found for the date: " + commentDate);
        }
        return comments;

    }






}



