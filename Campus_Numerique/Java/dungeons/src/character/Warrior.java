package character;
import item.*;

/**
 * Warrior class extending Character class
 * @author lauric
 *
 */

public class Warrior extends Adventurer{
	/**
	 * First constructor with all params
	 * @param name
	 * @param health
	 * @param strength
	 * @param attackItem
	 * @param defenseItem
	 */
	public Warrior(String name, int health, int strength, Weapon attackItem, String defenseItem) {
		super(name, health, strength, attackItem, defenseItem);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Second constructor with name params
	 * Sets default values for other params
	 * @param name
	 */
	public Warrior(String name) {
		this(name,5, 5, new Weapon(), "Bouclier");
	}
	
	/**
	 * Third constructor with no params
	 * Sets default values for all params
	 */
	public Warrior() {
		super("Guerrier", 5, 5, new Weapon(), "Bouclier");
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Guerrier";
	}
}
