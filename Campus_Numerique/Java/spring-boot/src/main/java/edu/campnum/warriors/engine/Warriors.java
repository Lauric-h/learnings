package edu.campnum.warriors.engine;

import edu.campnum.warriors.board.Board;
import edu.campnum.warriors.board.Cell;
import edu.campnum.warriors.board.Dice;
import edu.campnum.warriors.contracts.*;
import edu.campnum.warriors.db.DatabaseConnection;
import edu.campnum.warriors.db.JsonDb;
import edu.campnum.warriors.game.Game;
import edu.campnum.warriors.persona.Adventurer;
import edu.campnum.warriors.repositories.AdventurerRepository;
import edu.campnum.warriors.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Warrior class implements main API
 *
 * @author lauric
 */
@Component
public class Warriors implements WarriorsAPI {
    @Autowired
    private AdventurerRepository adventurerRepository;

    private List<Adventurer> adventurers;

    @Autowired
    private BoardRepository boardRepository;

    private List<Board> maps;

    private GameState game;
    private final Dice dice;

    @Autowired
    private JsonDb jsonDb;

    /**
     * Constructor
     * Adds heroes and maps
     */
    public Warriors() {
        this.dice = new Dice();


        // Add debug map - NOT WORKING
        // this.maps.add(new Board("Map debug"));

    }

    public void saveJson() {
        jsonDb.saveJsonToDb();
    }

    /**
     * Fetches heroes from DB
     * @return list of Adventurer
     */
    public void fetchHeroes() {
        adventurers = (List<Adventurer>) adventurerRepository.findAll();
    }

    /**
     * Fetches maps from DB
     * @return list of Board
     */
    public void fetchBoards() {
        this.maps = (List<Board>) boardRepository.findAll();
    }

    @Override
    public List<? extends Map> getMaps() {
        return this.maps;
    }

    @Override
    public List<? extends Adventurer> getHeroes() {
        return adventurers;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        game = new Game(playerName, hero, map);
        return game;
    }

    /**
     * Launches dice to play next turn
     * Checks next cell for item / monster
     * @param gameID represents the current game played
     * @return game object
     */
    @Override
    public GameState nextTurn(String gameID) {
        int diceNumber = this.dice.launch();
        System.out.println("Vous avez fait " + diceNumber);
        System.out.println("Vous passe de la case " + game.getCurrentCase() + " à la case " + (game.getCurrentCase() + diceNumber));

        ((Game) game).setCurrentCase(game.getCurrentCase() + diceNumber);

        // Gets current cell number
        // fetches the corresponding cell object
        // checks for the item on cell
        int currentCase = game.getCurrentCase();
        Cell currentCell = (Cell) ((Board) game.getMap()).findByCellNumber(currentCase);
        ((Game) game).checkCell(currentCell.getItem());

        return game;
    }
}
