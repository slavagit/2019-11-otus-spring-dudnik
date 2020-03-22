package ru.otus.spring.mongo.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.otus.spring.mongo.domain.BookComment;
import ru.otus.spring.mongo.domain.Genre;
import ru.otus.spring.mongo.exception.DaoException;
import ru.otus.spring.mongo.repository.AuthorRepository;
import ru.otus.spring.mongo.repository.BookCommentRepository;
import ru.otus.spring.mongo.repository.BookRepository;
import ru.otus.spring.mongo.repository.GenreRepository;
import ru.otus.spring.mongo.domain.Author;
import ru.otus.spring.mongo.domain.Book;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibraryReaderServiceImpl implements LibraryReaderService {
    private final BookRepository bookRepository;
    private final BookCommentRepository commentRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public List<Book> getAllBooksSortedByName() {
        return bookRepository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    @Override
    public List<Book> getBooksByNameLike(String name) {
        return bookRepository.findAllByNameLike(name);
    }

    @Override
    public List<BookComment> getBookComments(String bookId){
        return commentRepository.findAllByBook_Id(bookId);
    }

    @Override
    public Optional<BookComment> commentBook(String bookId, String comment) throws DaoException {
        final Optional<Book> book = bookRepository.findById(bookId);
        return book.map(bookValue
                -> Optional.of(commentRepository.save(new BookComment(comment, bookValue)))
        ).orElseThrow(() -> new DaoException("Book was not found"));
    }
}
