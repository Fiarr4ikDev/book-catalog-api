package ru.fiarr4ik.bookcatalogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fiarr4ik.bookcatalogapi.exception.BookNotFoundException;
import ru.fiarr4ik.bookcatalogapi.model.Book;
import ru.fiarr4ik.bookcatalogapi.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        try {
            bookService.getBookById(id);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @GetMapping("/get/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable("title") String title) {
       return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/get/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("author") String author) {
        return ResponseEntity.ok(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/get/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable("genre") String genre) {
        return ResponseEntity.ok(bookService.getBooksByGenre(genre));
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") int id) {
        try {
            bookService.deleteBook(id);
        } catch (BookNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

}
