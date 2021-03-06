package sk.stuba.fei.uim.oop.demo1.person;

import java.util.List;

public interface IPersonService {
    List<Person> getAll();

    Person getById(Long id);

    Person save(Person p);
}
