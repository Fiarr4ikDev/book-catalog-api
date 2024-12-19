package ru.fiarr4ik.bookcatalogapi.service;

import ru.fiarr4ik.bookcatalogapi.model.Book;

import java.util.List;

public interface BookService {

    void addBook(Book book);

    void updateBook(Book book, int id);

    void deleteBook(int id);

    List<Book> getBooks();

    Book getBookById(int id);

    Book getBookByTitle(String title);

    Book getBookByAuthor(String author);

    Book getBookByGenre(String genre);

}
