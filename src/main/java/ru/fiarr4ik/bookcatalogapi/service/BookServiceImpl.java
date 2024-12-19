package ru.fiarr4ik.bookcatalogapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fiarr4ik.bookcatalogapi.exception.BookNotFoundException;
import ru.fiarr4ik.bookcatalogapi.model.Book;
import ru.fiarr4ik.bookcatalogapi.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book, int id) {
        Book bookToUpdate = getBookById(id);
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setGenre(book.getGenre());
        bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBook(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
        } else {
            throw new BookNotFoundException("Книга не найдена с id " + id);
        }
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAllBook();
    }

    @Override
    public Book getBookById(int id) {
        Optional<Book> findBook = bookRepository.findBookById(id);
        return findBook.orElse(null);
    }

    @Override
    public Book getBookByTitle(String title) {
        Optional<Book> findBook = bookRepository.findBookByTitle(title);
        return findBook.orElse(null);
    }

    @Override
    public Book getBookByAuthor(String author) {
        Optional<Book> findBook = bookRepository.findBookByAuthor(author);
        return findBook.orElse(null);
    }

    @Override
    public Book getBookByGenre(String genre) {
        Optional<Book> findBook = bookRepository.findBookByGenre(genre);
        return findBook.orElse(null);
    }

}
