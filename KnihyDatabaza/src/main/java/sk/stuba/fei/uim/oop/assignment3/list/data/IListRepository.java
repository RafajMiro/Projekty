package sk.stuba.fei.uim.oop.assignment3.list.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface IListRepository extends JpaRepository<ListEntity, Long> {
    List<ListEntity> findAll();
    ListEntity findListById(Long id);

}
