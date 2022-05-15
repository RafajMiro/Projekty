package sk.stuba.fei.uim.oop.assignment3.list.logic;


import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.data.ListEntity;
import sk.stuba.fei.uim.oop.assignment3.list.web.body.BookIdRequest;

import java.util.List;

public interface IListService {
    List<ListEntity> getAllLists();
    ListEntity create();
    ListEntity getListById(Long id) throws NotFoundException;
    void deleteList(Long id) throws NotFoundException;
    ListEntity addBookToList(BookIdRequest bookId, Long listId) throws NotFoundException, IllegalOperationException;
    ListEntity removeBookFromList(BookIdRequest bookId, Long listId) throws NotFoundException;
    void setLendList(Long id) throws NotFoundException,IllegalOperationException;
}
