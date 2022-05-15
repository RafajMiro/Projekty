package sk.stuba.fei.uim.oop.assignment3.list.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Service
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Book> lendingList;
    private boolean lended;
    public ListEntity(){
        lendingList = new ArrayList<>();
    }
}
