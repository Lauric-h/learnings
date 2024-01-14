package edu.campnum.warriors.controllers;

import edu.campnum.warriors.board.Board;
import edu.campnum.warriors.contracts.WarriorsAPI;
import edu.campnum.warriors.engine.Warriors;
import edu.campnum.warriors.items.Item;
import edu.campnum.warriors.persona.Adventurer;
import edu.campnum.warriors.repositories.AdventurerRepository;
import edu.campnum.warriors.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class GameController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private AdventurerRepository adventurerRepository;

    @Autowired
    private Warriors warriors;


    @GetMapping("/api/game")
    public List<Item> getItems() throws SQLException {
        //warriors.saveJson();
        warriors.fetchBoards();
        warriors.fetchHeroes();


        return (List<Item>) itemRepository.findAll();
    }

    @GetMapping("/api/hero")
    public List<Adventurer> getHeroes() {
        return (List<Adventurer>) adventurerRepository.findAll();
    }

    @GetMapping("/api/game/{id}")
    public Optional<Item> getItem(@PathVariable Long id) {
        return itemRepository.findById(id);

    }

    @GetMapping("/api/item/{name}")
    public Item getName(@PathVariable String name) {
        return itemRepository.findByName(name);
    }



}
