package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String description;
    private Long author;
    private long pages;
    private long amount;
    private long lendCount;

}
