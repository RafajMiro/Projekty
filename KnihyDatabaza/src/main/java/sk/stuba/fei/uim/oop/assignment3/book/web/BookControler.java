package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.logic.BookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookControler {
    @Autowired
    private BookService service;

    @GetMapping
    public List<BookResponse> getAllBooks(){
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request) throws NotFoundException {
        return new ResponseEntity<>(new BookResponse(this.service.create(request)), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id) throws NotFoundException {
        return new BookResponse(this.service.getBookById(id));
    }
    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable("id") Long id, @RequestBody BookRequestEdit request) throws NotFoundException{
        return new BookResponse(this.service.updateBook(id,request));
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) throws NotFoundException{
        this.service.deleteBook(id);
    }
    @GetMapping("/{id}/amount")
    public BookAmount getBookAmount(@PathVariable("id") Long id) throws NotFoundException{
        return new BookAmount(this.service.getBookAmount(id));
    }
    @PostMapping("/{id}/amount")
    public BookAmount addBookAmount(@PathVariable("id") Long id, @RequestBody BookAmount body) throws NotFoundException{
        return new BookAmount(this.service.addBookAmount(id, body.getAmount()));
    }
    @GetMapping("/{id}/lendCount")
    public BookAmount getBookLendCount(@PathVariable("id")Long id) throws NotFoundException{
        return new BookAmount(this.service.getBookLendCount(id));
    }
}
