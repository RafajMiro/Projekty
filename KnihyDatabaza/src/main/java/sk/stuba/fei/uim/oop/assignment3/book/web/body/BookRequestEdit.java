package sk.stuba.fei.uim.oop.assignment3.book.web.body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestEdit {
    private String name;
    private String description;
    private Long author;
    private long pages;
}
