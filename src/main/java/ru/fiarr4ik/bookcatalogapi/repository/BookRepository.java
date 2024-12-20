package ru.fiarr4ik.bookcatalogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.fiarr4ik.bookcatalogapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b")
    List<Book> findAllBook();

    Optional<Book> findBookById(Integer id);

    List<Book> findBooksByTitle(String title);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBooksByGenre(String genre);

}
