package ru.otus.spring.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.jdbc.repository.BookRepository;

import java.sql.SQLException;

@SpringBootApplication
public class JdbcDaoApplication {

    public static void main(String[] args) throws SQLException {
        final ApplicationContext applicationContext = SpringApplication.run(JdbcDaoApplication.class, args);
        BookRepository bookRepository=applicationContext.getBean(BookRepository.class);


    }

}
