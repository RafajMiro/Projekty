package sk.stuba.fei.uim.oop.demo1.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.demo1.animal.Animal;

import java.util.List;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal,Long> {
    List<Animal> findAll();

    List<Animal> findAllByName(String name);
}
