package ru.fiarr4ik.bookcatalogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ik.bookcatalogapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllBook();

    Optional<Book> findBookById(Integer id);

    Optional<Book> findBookByTitle(String title);

    Optional<Book> findBookByAuthor(String author);

    Optional<Book> findBookByGenre(String genre);

}
