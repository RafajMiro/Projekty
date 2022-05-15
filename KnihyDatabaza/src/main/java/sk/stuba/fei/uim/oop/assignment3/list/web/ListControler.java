package sk.stuba.fei.uim.oop.assignment3.list.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.list.logic.IListService;
import sk.stuba.fei.uim.oop.assignment3.list.web.body.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.list.web.body.ListResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class ListControler {

    @Autowired
    private IListService service;

    @GetMapping()
    public List<ListResponse> getAllLists(){
        return this.service.getAllLists().stream().map(ListResponse::new).collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<ListResponse> addList(){
        return new ResponseEntity<>(new ListResponse(this.service.create()), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ListResponse getListById(@PathVariable("id") Long id) throws NotFoundException {
        return  new ListResponse(this.service.getListById(id));
    }
    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable("id") Long id) throws NotFoundException{
        this.service.deleteList(id);
    }
    @PostMapping("/{id}/add")
    public ListResponse addBookToList(@PathVariable("id") Long bookId, @RequestBody BookIdRequest request) throws NotFoundException, IllegalOperationException {
        return new ListResponse(this.service.addBookToList(request, bookId));
    }
    @DeleteMapping("/{id}/remove")
    public ListResponse removeBookFromList(@PathVariable("id") Long bookId, @RequestBody BookIdRequest request) throws NotFoundException{
        return new ListResponse(this.service.removeBookFromList(request, bookId));
    }
    @GetMapping("/{id}/lend")
    public void setLendList(@PathVariable("id") Long id) throws NotFoundException,IllegalOperationException{
        this.service.setLendList(id);
    }
}
