package ru.fiarr4ik.bookcatalogapi.service;

import ru.fiarr4ik.bookcatalogapi.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    void updateBook(Book book, int id);

    void deleteBook(int id);

    List<Book> getBooks();

    Book getBookById(int id);

    List<Book> getBooksByTitle(String title);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByGenre(String genre);

}
