package sk.stuba.fei.uim.oop.demo1.person;

import lombok.Getter;

@Getter
public class PersonResponse {
    private Long id;
    private String name;
    private Long animalId;
    public PersonResponse(Person person){
        this.id = person.getId();
        this.name = person.getName();
        this.animalId = person.getAnimal() == null ? null : person.getAnimal().getId();
    }
}
