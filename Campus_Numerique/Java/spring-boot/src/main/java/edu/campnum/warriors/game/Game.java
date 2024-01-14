package edu.campnum.warriors.game;

import edu.campnum.warriors.board.Board;
import edu.campnum.warriors.contracts.GameStatus;
import edu.campnum.warriors.contracts.Map;
import edu.campnum.warriors.contracts.Hero;
import edu.campnum.warriors.persona.Adventurer;
import edu.campnum.warriors.items.*;
import edu.campnum.warriors.persona.monsters.Monster;

import java.lang.reflect.InvocationTargetException;


/**
 * Game class
 * Implements GameState
 * Represents current state of the game
 * @author lauric
 *
 */
public class Game implements edu.campnum.warriors.contracts.GameState {
	private String playerName;
	private Adventurer hero;
	private Board map;
	private GameStatus gameStatus;
	private String gameId;
	private String lastLog;
	private int currentCase;
	
	/**
	 * Constructor
	 * Launches game by changing GameStatus
	 * @param playerName String
	 * @param hero character chosen
	 * @param map board chosen
	 */
	public Game(String playerName, Hero hero, Map map) {
		super();
		this.playerName = playerName;
		this.hero = (Adventurer) hero;
		this.map = (Board) map;
		this.gameId = "1";
		this.gameStatus = GameStatus.IN_PROGRESS;
		this.currentCase = 1;
	}

	public String getPlayerName() {
		return playerName;
	}

	public Adventurer getHero() {
		return hero;
	}

	public Board getMap() {
		return map;
	}

	public String getGameId() {
		return gameId;
	}

	public GameStatus getGameStatus() {
		return gameStatus;
	}
	
	/**
	 * Change game status
	 * @param gameStatus sets status of game
	 */
	public void setGameStatus(GameStatus gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	public int getCurrentCase() {
		return currentCase;
	}

	public String toString() {
		return "Game [playerName=" + playerName + ", hero=" + hero + ", map=" + map + ", gameStatus=" + gameStatus
				+ ", gameId=" + gameId + ", lastLog=" + lastLog + ", currentCase=" + currentCase + "]";
	}
	
	/**
	 * Get last position of player
	 * Displays game finished if position is end of board
	 */
	public String getLastLog() {
		this.lastLog = this.currentCase + "/64";
		if (this.gameStatus == GameStatus.FINISHED) {
			this.lastLog = "================== Partie terminée ================ \n ~~~~~~~~~~~~~~ Vous avez gagné ! ~~~~~~~~~~~~~~";
		}
		return lastLog;
	}	

	/**
	 * Defines current cell where player is
	 * If current cell is 64, ends game
	 * @param currentCase int 
	 */
	public void setCurrentCase(int currentCase) {
		// Ends game if player reaches 64
		if (currentCase >= 64) {
			currentCase = 64;
			this.gameStatus = GameStatus.FINISHED;
			return;
		}
		this.currentCase = currentCase;
	}
	
	/**
	 * Checks what's on the current cell
	 * Either empty, bonus(item) or fight 
	 * @param onCell Object of what's on the cell
	 */
	public void checkCell(Item onCell) {
		if(onCell.getBonusType().contains("enemy")) {
			// builds a monster object if the item on cell is an enemy
			Class<?> cls = null;
			Monster monster = null;
			try {
				cls = Class.forName("edu.campnum.persona.monsters." + onCell.getName());
				Object o = cls.getConstructor().newInstance();
				monster = (Monster) o;
			} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

			Fight fight = new Fight(monster, hero);
			fight.fight();
			if (hero.getLife() <= 0) {
				System.out.println("Vous avez perdu ! Partie terminée !");
				this.gameStatus = GameStatus.FINISHED;
			}
		} else {
			System.out.println("Vous êtes tombé sur un " + onCell.getName());
			this.checkBonus(onCell);
			System.out.println("Vous reprenez votre chemin...");
		}
	}
	
	/**
	 * Checks the item on the cell 
	 * @param item attack, potion or empty
	 */
	private void checkBonus(Item item) {
		switch(item.getBonusType()) {
			case "strength":
			case "spell":
				this.addAttack(item);
				break;
			case "life":
				this.addPotion(item);
				break;
			default:
				break;
		}
	}
	
	/**
	 * Checks if hero can get the item
	 * Adds bonus to hero
	 * @param item weapon or spell
	 */
	private void addAttack(Item item) {
		if (	(hero.getType().contains("Wizard") && item.getBonusType().contains("spell")) ||
				(hero.getType().contains("Warrior") && item.getBonusType().contains("strength"))
		) {
			hero.setStrength(hero.getStrength() + item.getBonus());
			System.out.println("Vous faites maintenant " + hero.getStrength() + " dégâts.");
		} else {
			System.out.println("Vous ne pouvez pas prendre cet objet !");
		}
	}
	
	/**
	 * Adds life to hero
	 * @param potion kind of potion
	 */
	private void addPotion(Item potion) {
		hero.setLife(hero.getLife() + potion.getBonus());
		System.out.println("Vous avez maintenant " + hero.getLife() + " points de vie.");
	}
	
	
}
