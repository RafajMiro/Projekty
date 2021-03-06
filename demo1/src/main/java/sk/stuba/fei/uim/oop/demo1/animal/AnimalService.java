package sk.stuba.fei.uim.oop.demo1.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.demo1.person.IPersonService;
import sk.stuba.fei.uim.oop.demo1.person.Person;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService implements IAnimalService {

    private IAnimalRepository repository;

    @Autowired
    private IPersonService personService ;

    @Autowired
    public AnimalService(IAnimalRepository repository) {
        this.repository = repository;
        Animal a1 = new Animal();
        a1.setSpecies("Pes");
        a1.setName("Luna");
        Animal a2 = new Animal();
        a2.setSpecies("Macka");
        a2.setName("Muro");
        this.repository.save(a1);
        this.repository.save(a2);
        //this.repository.delete(a2);
    }

    @Override
    public List<Animal> getAll(){
        return this.repository.findAll();
    }

    @Override
    public Animal create(AnimalRequest request) {
        Animal a = new Animal();
        a.setSpecies(request.getSpecies());
        a.setName(request.getName());
        return this.repository.save(a);
    }

    @Override
    public List<Animal> getAllByNames(String name) {
        return  this.repository.findAllByName(name);
    }

    @Override
    public Animal addPersonToAnimal(Long animalId, Long personId) {
        Optional<Animal> animalOpt = this.repository.findById(animalId);
        Animal animal = animalOpt.get();
        Person person =this.personService.getById(personId);
//        animal.setPerson(person);
        animal.getPerson().add(person);
        person.setAnimal(animal);
        this.personService.save(person);
        return this.repository.save(animal);
    }
}
