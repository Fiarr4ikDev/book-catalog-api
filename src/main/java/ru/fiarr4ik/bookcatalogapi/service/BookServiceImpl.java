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
    public Book addBook(Book book) {
        return bookRepository.save(book);
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
        if (findBook.isPresent()) {
            return findBook.get();
        } else {
            throw new BookNotFoundException("Книга не найдена с id" + id);
        }
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre);
    }

}
