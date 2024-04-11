package ru.gb.issue_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Author {
    UUID id;
    String firstName;
    String lastName;
}
