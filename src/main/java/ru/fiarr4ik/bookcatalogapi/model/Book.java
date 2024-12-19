package ru.fiarr4ik.bookcatalogapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(
        name = "books"
)
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "book_id"
    )
    private int id;

    @Column(
            name = "book_title"
    )
    private String title;

    @Column(
            name = "book_author"
    )
    private String author;

    @Column(
            name = "book_genre"
    )
    private String genre;

}
