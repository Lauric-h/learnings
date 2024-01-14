package edu.campnum.warriors.repositories;

import edu.campnum.warriors.persona.Adventurer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventurerRepository extends CrudRepository<Adventurer, Long> {
    List<Adventurer> findByName(String name);
}
