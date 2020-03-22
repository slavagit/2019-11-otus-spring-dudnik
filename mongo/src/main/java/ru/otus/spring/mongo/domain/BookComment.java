package ru.otus.spring.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "comment")
@Data
@AllArgsConstructor
public class BookComment {
    @Id
    private String id;
    private String text;
    private LocalDateTime time;
    @DBRef
    private Book book;

    public BookComment() {
        time = LocalDateTime.now();
    }

    public BookComment(String text, Book book) {
        this();
        this.text = text;
        this.book = book;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", time, text);
    }
}
