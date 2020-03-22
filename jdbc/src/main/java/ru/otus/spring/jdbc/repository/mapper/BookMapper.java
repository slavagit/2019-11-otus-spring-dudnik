package ru.otus.spring.jdbc.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.spring.jdbc.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        final Book book = new Book(resultSet.getLong("id"), resultSet.getString("name"));
        return book;
    }
}
