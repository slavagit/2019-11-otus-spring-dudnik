package ru.otus.spring.jdbc.repository.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.otus.spring.jdbc.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreMapper implements RowMapper<Genre> {

    @Override
    public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new Genre(id, name);
    }
}
