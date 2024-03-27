package org.example.lab11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition ="varchar(10) not null" )
    private String username;

    @NotNull(message = "cant be null")
    @Column(columnDefinition ="varchar(20) not null" )
    private String password;

    @NotEmpty(message = "Email can't be empty")
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotNull(message = "can't be null")
    @Column(columnDefinition = "date")
    private LocalDate registrationDate;

}
