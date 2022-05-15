package sk.stuba.fei.uim.oop.demo1.animal;

import sk.stuba.fei.uim.oop.demo1.animal.Animal;
import sk.stuba.fei.uim.oop.demo1.animal.AnimalRequest;

import java.util.List;

public interface IAnimalService {
    List<Animal> getAll();
    Animal create(AnimalRequest request);
    List<Animal> getAllByNames(String name);
    Animal addPersonToAnimal(Long animalId, Long personId);
}
