package sk.stuba.fei.uim.oop.assignment3.author.logic;

import sk.stuba.fei.uim.oop.assignment3.author.web.body.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author create(AuthorRequest request);
    Author getAuthorById(Long id) throws NotFoundException;
    Author updateAuthor(Long id, AuthorRequest request) throws NotFoundException;
    void deleteAuthor(Long id) throws NotFoundException;
    void deleteBookFromAuthor(Long bookId, Long AuthorId) throws NotFoundException;
}
