package sk.stuba.fei.uim.oop.assignment3.book.logic;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request) throws NotFoundException, IllegalOperationException;
    Book getBookById(Long id) throws NotFoundException;
    Book updateBook(Long id, BookRequestEdit request) throws NotFoundException;
    void deleteBook(Long id) throws NotFoundException;
    long getBookAmount(Long id) throws NotFoundException;
    long addBookAmount(Long id, Long increment) throws NotFoundException;
    long getBookLendCount(Long id) throws NotFoundException;
    Book lendCount(Long bookId, boolean switcher) throws NotFoundException;
}
