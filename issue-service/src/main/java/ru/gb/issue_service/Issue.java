package ru.gb.issue_service;

import ru.gb.issue_service.dto.Book;
import ru.gb.issue_service.dto.Reader;
import lombok.Data;

import java.util.UUID;

@Data
public class Issue {
    private UUID id;
    private Book book;
    private Reader reader;
}
