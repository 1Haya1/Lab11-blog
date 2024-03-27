package org.example.lab11.Service;

import lombok.RequiredArgsConstructor;
import org.example.lab11.Api.ApiException;
import org.example.lab11.Model.Category;
import org.example.lab11.Model.Post;
import org.example.lab11.Model.User;
import org.example.lab11.Repository.CategoryRepository;
import org.example.lab11.Repository.PostRepository;
import org.example.lab11.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    public List<Post> getAllPost(){
        return postRepository.findAll();
    }


    public void addPost(Post post){
        Category c=categoryRepository.findCategoryById(post.getCategory_Id());
        User u=userRepository.findUserById(post.getUser_Id());
        if(c==null || u==null){
            throw new ApiException("wrong id");
        }
        post.setCategory_Id(post.getCategory_Id());
        post.setUser_Id(post.getUser_Id());
        postRepository.save(post);
    }


    public void updatePost(Integer id, Post post) {
        Post c = postRepository.findPostById(id);

        if (c == null) {
            throw new ApiException("wrong id");
        }

        c.setTitle(post.getTitle());
        c.setContent(post.getContent());
        c.setPublishDate(post.getPublishDate());
        c.setUser_Id(post.getUser_Id());
        c.setCategory_Id(post.getCategory_Id());
        postRepository.save(c);

    }


    public void deletePost(Integer id) {
        Post c = postRepository.findPostById(id);
        if (c == null) {
            throw new ApiException("wrong id");
        }
        postRepository.delete(c);
    }

    public List<Post> getAllPostsByUserId(Integer user_Id) {
        List<Post> posts = postRepository.findByUser_Id(user_Id);
        if (posts.isEmpty()) {
            throw new ApiException("No posts found for the user ID: " + user_Id);
        }
        return posts;
    }



    public List<Post> getPostsByTitle(String title) {
        List<Post> posts = postRepository.findByTitle(title);

        if (posts.isEmpty()){
            throw new ApiException("empty");
        }
        return posts;

    }


    public List<Post> getAllPostsBeforeDate(LocalDate date) {

        List<Post> posts = postRepository.findByPublishDateBefore(date);
        if (posts.isEmpty()){
            throw new ApiException("empty");
        }
        return posts;

    }




}


