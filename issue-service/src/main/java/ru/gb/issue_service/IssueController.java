package ru.gb.issue_service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.issue_service.provider.BookProvider;
import ru.gb.issue_service.provider.ReaderProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class IssueController {
    private List<Issue> list;
    private final BookProvider bookProvider;
    private final ReaderProvider readerProvider;

    @PostConstruct
    public void generateIssue(){
        list = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Issue issue = new Issue();
            issue.setId(UUID.randomUUID());
            issue.setReader(readerProvider.getRandomReader());
            issue.setBook(bookProvider.getRandomBook());

            list.add(issue);
        }
    }

    @GetMapping("refresh")
    public List<Issue> refresh(){
        generateIssue();
        return list;
    }

    @GetMapping("issue")
    public List<Issue> getAll() {
        return list;
    }
}
