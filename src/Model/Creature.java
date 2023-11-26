package Model;

/**
 * The Creature class represents a creature in the game, with properties like name, type, family, and evolution level.
 */
public class Creature {

    /**
     * The name of the creature.
     */
    private String name;

    /**
     * The type of the creature (e.g., Fire, Water, Grass).
     */
    private String type;

    /**
     * The family to which the creature belongs.
     */
    private String family;

    /**
     * The evolution level of the creature.
     */
    private int evolutionLevel;

    /**
     * Constructs a Creature object with the specified attributes.
     * @param name           
     *     The name of the creature.
     * @param type           
     *     The type of the creature (e.g., Fire, Water, Grass).
     * @param family         
     *     The family to which the creature belongs.
     * @param evolutionLevel 
     *     The evolution level of the creature.
     */

    public Creature(String name, String type, String family, int evolutionLevel) {
        this.name = name;
        this.type = type;
        this.family = family;
        this.evolutionLevel = evolutionLevel;
    }

    /**
     * Gets the name of the creature.
     *
     * @return 
     *    The name of the creature.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the type of the creature.
     *
     * @return 
     *    The type of the creature (e.g., Fire, Water, Grass).
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the family to which the creature belongs.
     *
     * @return 
     *    The family of the creature.
     */
    public String getFamily() {
        return this.family;
    }

    /**
     * Gets the evolution level of the creature.
     *
     * @return 
     *    The evolution level of the creature.
     */
    public int getEvolutionLevel() {
        return this.evolutionLevel;
    }

    /**
     * Sets the evolution level of the creature.
     * @param evolutionLevel 
     *     The new evolution level to set.
     */
    public void setEvolutionLevel(int evolutionLevel) {
        this.evolutionLevel = evolutionLevel;
    }


}