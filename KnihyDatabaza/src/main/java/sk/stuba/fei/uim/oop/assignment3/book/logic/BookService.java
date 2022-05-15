package sk.stuba.fei.uim.oop.assignment3.book.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.logic.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.IBookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.body.BookRequestEdit;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;


@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository repository;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    public BookService(IBookRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) throws  NotFoundException {
        Book b = new Book();
        Author a = this.authorService.getAuthorById(request.getAuthor());
        b.setName(request.getName());
        b.setDescription(request.getDescription());
        if (this.authorService.getAuthorById(request.getAuthor()) == null){
            throw new NotFoundException();
        }
        b.setAuthor(request.getAuthor());
        b.setPages(request.getPages());
        b.setAmount(request.getAmount());
        b.setLendCount(request.getLendCount());

        a.getBooks().add(b);

        return this.repository.save(b);
    }

    @Override
    public Book getBookById(Long id) throws NotFoundException{
        Book b = this.repository.findBookById(id);
        if(b == null ){
            throw new NotFoundException();
        }
        return b;
    }

    @Override
    public Book updateBook(Long id, BookRequestEdit request) throws NotFoundException{
        Book b = this.repository.findBookById(id);

        if(this.repository.findBookById(id) == null){
            throw new NotFoundException();
        }
        if(request.getName() != null){
            b.setName(request.getName());
        }
        if(request.getDescription() != null){
            b.setDescription(request.getDescription());
        }
        if(request.getAuthor() != null && request.getAuthor() != 0){
            this.authorService.getAuthorById(this.repository.findBookById(id).getAuthor()).getBooks().remove(this.repository.findBookById(id));
            b.setAuthor(request.getAuthor());
            this.authorService.getAuthorById(this.repository.findBookById(id).getAuthor()).getBooks().add(b);
        }
        if(request.getPages() > 0){
            b.setPages(request.getPages());
        }

        return this.repository.save(b);
    }

    @Override
    public void deleteBook(Long id) throws NotFoundException{
        if (this.repository.findBookById(id) == null){
            throw new NotFoundException();
        }
        this.authorService.deleteBookFromAuthor(id, this.repository.findBookById(id).getAuthor());
        this.repository.delete(this.repository.findBookById(id));

    }

    @Override
    public long getBookAmount(Long id) throws NotFoundException{
        Book b = this.repository.findBookById(id);
        if (b == null){
            throw new NotFoundException();
        }
        return b.getAmount();
    }

    @Override
    public long addBookAmount(Long id, Long increment) throws NotFoundException{
        Book b = this.repository.findBookById(id);
        if (this.repository.findBookById(id) == null){
            throw new NotFoundException();
        }
        b.setAmount(b.getAmount() + increment);
        this.repository.save(b);
        return b.getAmount();
    }

    @Override
    public long getBookLendCount(Long id) throws NotFoundException{
        Book b = this.repository.findBookById(id);
        if (this.repository.findBookById(id) == null){
            throw new NotFoundException();
        }
        return b.getLendCount();
    }

    @Override
    public Book lendCount(Long bookId, boolean switcher) throws NotFoundException{
        Book b = this.repository.findBookById(bookId);
        if(b == null){
            throw new NotFoundException();
        }
        if(switcher) {
            b.setLendCount(b.getLendCount() + 1);
        }else{
            b.setLendCount(b.getLendCount() - 1);
        }
        return b;
    }
}
