package org.example.lab11.Repository;

import org.example.lab11.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query("select c from Post c  where c.id=?1")
    Post findPostById(Integer id);
    @Query("SELECT c FROM Post c WHERE c.user_Id = ?1")
    List<Post> findByUser_Id(Integer user_Id);

    List<Post> findByTitle(String title);

    List<Post> findByPublishDateBefore(LocalDate date);




}
