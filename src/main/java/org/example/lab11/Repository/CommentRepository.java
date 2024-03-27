package org.example.lab11.Repository;

import org.example.lab11.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query("select c from Comment c  where c.id=?1")
    Comment findCommentById(Integer id);

    @Query("SELECT c FROM Comment c WHERE c.post_Id = ?1")
    List<Comment> findCommentByPost_Id(Integer post_Id);

    List<Comment> findByCommentDate(LocalDate commentDate);

}
