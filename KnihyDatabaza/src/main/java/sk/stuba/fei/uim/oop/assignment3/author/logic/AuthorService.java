package sk.stuba.fei.uim.oop.assignment3.author.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.web.body.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.IAuthorRepository;

import sk.stuba.fei.uim.oop.assignment3.book.logic.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository repository;

    @Autowired
    private IBookService bookService;

    @Autowired
    public AuthorService(IAuthorRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author a = new Author();
        a.setName(request.getName());
        a.setSurname(request.getSurname());
        return this.repository.save(a);
    }

    @Override
    public Author getAuthorById(Long id) throws NotFoundException {
        Author a = this.repository.findAuthorById(id);
        if(a == null){
            throw new NotFoundException();
        }
        return a;
    }

    @Override
    public Author updateAuthor(Long id, AuthorRequest request) throws NotFoundException{
        Author a = this.repository.findAuthorById(id);
        if (a == null){
            throw new NotFoundException();
        }
        if(request.getName() != null){
            a.setName(request.getName());
        }
        if(request.getSurname() != null){
            a.setSurname(request.getSurname());
        }
        return this.repository.save(a);
    }

    @Override
    public void deleteAuthor(Long id) throws NotFoundException{
        Author a = this.repository.findAuthorById(id);
        if (a == null){
            throw new NotFoundException();
        }
        this.repository.delete(a);
    }

    @Override
    public void deleteBookFromAuthor(Long bookId, Long authorId) throws NotFoundException {
        if(bookId == null){
            throw new NotFoundException();
        }
        this.repository.findAuthorById(authorId).getBooks().remove(this.bookService.getBookById(bookId));
    }
}
