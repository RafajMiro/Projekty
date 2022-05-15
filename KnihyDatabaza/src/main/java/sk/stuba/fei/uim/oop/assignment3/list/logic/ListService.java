package sk.stuba.fei.uim.oop.assignment3.list.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.logic.IBookService;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.IListRepository;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListEntity;
import sk.stuba.fei.uim.oop.assignment3.list.web.body.BookIdRequest;

import java.util.List;

@Service
public class ListService implements IListService {

    @Autowired
    private IListRepository repository;

    @Autowired
    private IBookService bookService;

    @Autowired
    public ListService(IListRepository repository){
        this.repository = repository;
    }

    @Override
    public List<ListEntity> getAllLists() {
        return this.repository.findAll();
    }

    @Override
    public ListEntity create() {
        ListEntity l = new ListEntity();
        l.setLendingList(l.getLendingList());
        return this.repository.save(l);
    }

    @Override
    public ListEntity getListById(Long id) throws NotFoundException{
        ListEntity l = this.repository.findListById(id);
        if(l == null){
            throw new NotFoundException();
        }
        return l;
    }

    @Override
    public void deleteList(Long id) throws NotFoundException{
        if(this.repository.findListById(id) == null){
            throw new NotFoundException();
        }
        if(this.repository.findListById(id).isLended()){
            for(int i = 0; i < this.repository.findListById(id).getLendingList().size(); i++){
                this.bookService.lendCount(this.repository.findListById(id).getLendingList().get(i).getId(), false);
            }
        }
        this.repository.delete(this.repository.findListById(id));
    }

    @Override
    public ListEntity addBookToList(BookIdRequest bookId, Long listId) throws NotFoundException, IllegalOperationException {
        if(this.repository.findListById(listId) == null){
            throw new NotFoundException();
        }
        if(this.bookService.getBookById(bookId.getId()) == null){
            throw new NotFoundException();
        }
        ListEntity l = this.repository.findListById(listId);
        if(this.repository.findListById(listId).isLended()){
            throw new IllegalOperationException();
        }
        if(this.repository.findListById(listId).getLendingList().contains(this.bookService.getBookById(bookId.getId()))){
            throw new IllegalOperationException();
        }
        l.getLendingList().add(this.bookService.getBookById(bookId.getId()));
        return  l;
    }

    @Override
    public ListEntity removeBookFromList(BookIdRequest bookId, Long listId) throws NotFoundException {
        ListEntity l = this.repository.findListById(listId);
        if(this.repository.findListById(listId) == null){
            throw new NotFoundException();
        }
        if(this.bookService.getBookById(bookId.getId()) == null){
            throw new NotFoundException();
        }
        l.getLendingList().remove(this.bookService.getBookById(bookId.getId()));
        return l;
    }

    @Override
    public void setLendList(Long id) throws NotFoundException, IllegalOperationException {
        if(this.repository.findListById(id) == null){
            throw new NotFoundException();
        }
        if(this.repository.findListById(id).isLended()){
            throw new IllegalOperationException();
        }
        for(int i = 0; i < this.repository.findListById(id).getLendingList().size(); i++){
            this.bookService.lendCount(this.repository.findListById(id).getLendingList().get(i).getId(), true);
        }
        this.repository.findListById(id).setLended(true);
    }


}