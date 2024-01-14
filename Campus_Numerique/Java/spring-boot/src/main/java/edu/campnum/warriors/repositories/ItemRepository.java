package edu.campnum.warriors.repositories;

import edu.campnum.warriors.items.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findByName(String name);
}
