package org.example.lab11.Model;

import jakarta.persistence.*;
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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition ="varchar(10) not null" )
    private String title;


    @NotEmpty(message = "cant be empty")
    @Column(columnDefinition ="text not null" )
    private String content;

    @NotNull(message = "can't be null")
    @Column(columnDefinition = "date")
    private LocalDate publishDate;

    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer category_Id;

    @NotNull(message = "cant be null")
    @Column(columnDefinition = "int not null")
    private Integer user_Id;


}
