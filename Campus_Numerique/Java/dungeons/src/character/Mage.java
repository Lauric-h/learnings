package character;
import item.*;

/**
 * Mage class extending Character class
 * @author lauric
 *
 */
public class Mage extends Adventurer {

	/**
	 * First constructor with all params
	 * @param name
	 * @param health
	 * @param strength
	 * @param spell
	 * @param defenseItem
	 */
	public Mage(String name, int health, int strength, Spell spell, String defenseItem) {
		super(name, health, strength, spell, defenseItem);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Second constructor with name params
	 * Sets default values for other params
	 * @param name
	 */
	public Mage(String name) {
		this(name,3, 8, new Spell(),"Philtre");
	}
	
	/**
	 * Third constructor with no params
	 * Sets default values for all params
	 */
	public Mage() {
		this("Mage",3, 8, new Spell(),"Philtre");
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Mage";
	}
}
