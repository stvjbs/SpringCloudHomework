package ru.gb;

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
@RequestMapping("reader")

public class ReaderController {
    private final List<Reader> readers = new ArrayList<>();

    @PostConstruct
    public void generateReaders() {
        for (int i = 0; i < 15; i++) {
            Reader reader = new Reader();
            reader.setId(UUID.randomUUID());
            reader.setName("Reader: " + i);

            readers.add(reader);
        }
    }
    @TimerCustomAnnotation
    @GetMapping()
    public List<Reader> getAll() {
        return readers;
    }
    @TimerCustomAnnotation
    @GetMapping("random")
    public Reader getById() {
        Random random = new Random();
        return readers.get(random.nextInt(readers.size()));
    }
}
