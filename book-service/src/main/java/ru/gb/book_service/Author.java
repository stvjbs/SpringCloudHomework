package ru.gb.book_service;

import lombok.Data;

import java.util.UUID;
@Data
public class Author {
    UUID id;
    String firstName;
    String lastName;
}
