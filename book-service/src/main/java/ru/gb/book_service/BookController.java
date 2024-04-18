package ru.gb.book_service;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.timer.TimerCustomAnnotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {
    private final List<Book> books = new ArrayList<>();

    @PostConstruct
    public void generateBooks() {
        for (int i = 0; i < 15; i++) {
            Book book = new Book();
            Author author = new Author();
            book.setId(UUID.randomUUID());
            book.setName("Book: " + i);
            author.setId(UUID.randomUUID());
            author.setFirstName("FirstName: " + i);
            author.setLastName("LastName: " + i);
            book.setAuthor(author);
            books.add(book);
        }
    }

    @GetMapping()
    @TimerCustomAnnotation
    public List<Book> getAll() {
        return books;
    }

    @GetMapping("random")
    @TimerCustomAnnotation
    public Book getById() {
        Random random = new Random();

        return books.get(random.nextInt(books.size()));
    }
}
