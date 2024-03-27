package org.example.lab11.Repository;


import org.example.lab11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select c from User c  where c.id=?1")
    User findUserById(Integer id);

    User findByEmail(String email);
    List<User> findByRegistrationDate(LocalDate registrationDate);

}

