package sk.stuba.fei.uim.oop.demo1.animal;

import lombok.Data;
import sk.stuba.fei.uim.oop.demo1.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String species;
//    @OneToOne
//    private Person person;
    @OneToMany
    private List<Person> person;

    public Animal() {
        this.person = new ArrayList<>();
    }
}
