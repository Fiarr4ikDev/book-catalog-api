package ru.fiarr4ik.bookcatalogapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fiarr4ik.bookcatalogapi.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
