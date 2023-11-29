package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The BattlePhase class represents a battle phase in the game where the player faces an enemy creature.
 * It manages actions such as attacking, swapping creatures, capturing creatures, and running away.
 */
public class BattlePhase {

    /**
     * The game area where the battle takes place.
     */
    private Area area;

    /**
     * The player's inventory.
     */
    private Inventory inventory;

    /**
     * The enemy creature that the player is currently facing.
     */
    private Creature enemyCreature;

    /**
     * The current health of the enemy creature.
     */
    private double enemyHealth;

    /**
     * A list of enemy creatures available for the battle.
     */
    private ArrayList<Creature> enemyCreatures;

    /**
     * The number of actions the player has left in the battle.
     */
    private int actionsLeft = 3;

    /**
     * Constructs a BattlePhase object for a battle with an enemy creature.
     * @param inventory 
     *     The player's inventory.
     * @param creatures 
     *     A list of enemy creatures.
     * @param area 
     *     The game area where the battle takes place.
     */
    public BattlePhase (Inventory inventory, ArrayList<Creature> creatures, Area area){
        this.enemyCreatures = creatures;
        this.inventory = inventory;
        this.area = area;
        this.setEnemyCreature(); // Set an enemy creature
        this.enemyHealth = 50;
        this.actionsLeft = 3;
    }

    /**
     * Displays the battle phase to the player, including available actions and creature information.
     */
    public void displayBattlePhase(int nOpt) {
       
            // Initiate attack
            if (nOpt == 1) {
                attack(inventory.getActiveCreature());
                System.out.println("I att: " + actionsLeft);
            // Swap active creature
            } else if (nOpt == 2) 
                swap();
            // Try to capture the creature
            else if (nOpt == 3) 
                capture(inventory.getCapturedCreatures());
            // Run away from the battle phase
            else if (nOpt == 4) { 
                System.out.println();
                System.out.println("Player Runs Away");
                System.out.println();
                //area.displayActiveArea();
            }
     
         if (actionsLeft < 0)   {
            System.out.println();
            System.out.println(getEnemyCreature().getName() + " Runs Away!!");
            System.out.println();
         }
        //area.displayActiveArea();
    }

    /**
     * Initiates an attack by the player's active creature on the enemy creature.
     * @param activeCreature 
     *     The player's active creature.
     */
    private void attack(Creature activeCreature) {

        double typeMultiplier;
        int randomNumber = new Random().nextInt(10) + 1;
        double damage;

        if (activeCreature.getType().equals("Fire") && enemyCreature.getType().equals("Grass"))
            typeMultiplier = 1.5;
        else if (activeCreature.getType().equals("Grass") && enemyCreature.getType().equals("Water")) 
            typeMultiplier = 1.5;
        else if (activeCreature.getType().equals("Water") && enemyCreature.getType().equals("Fire")) 
            typeMultiplier = 1.5;
        else
            typeMultiplier = 1;

        damage = randomNumber * activeCreature.getEvolutionLevel() * typeMultiplier;
        enemyHealth -= damage;

        System.out.println();
        System.out.println("You did " + damage + " damage");

        if(enemyHealth < 0){
            System.out.println();
            System.out.println("Enemy's HP has reached 0");
            System.out.println(enemyCreature.getName() + " has died");
            System.out.println();
            //area.displayActiveArea();
        }

        actionsLeft--;
    }

    /**
     * Allows the player to swap the active creature.
     */
    private void swap() {
        
    }

    /**
     * Allows the player to attempt to capture the enemy creature.
     * @param capturedCreatures 
     *     A list of captured creatures.
     */
    private void capture(ArrayList<Creature> capturedCreatures) {
        
        int randomChance = new Random().nextInt(100) + 1;
        int successRate = 90;

        successRate -= enemyHealth;

        if (randomChance <= successRate) {
            System.out.println(getEnemyCreature().getName() + " has been Captured");
            capturedCreatures.add(enemyCreature);
            //area.displayActiveArea();
        } else {
            System.out.println("Failed to Capture Creature");
        }

        actionsLeft--;
    }

    /**
     * Gets the current health of the enemy creature.
     *
     * @return 
     *    The health of the enemy creature.
     */
    public double getEnemyHealth() {
        return this.enemyHealth;
    }

    /**
     * Gets the enemy creature that the player is facing.
     *
     * @return 
     *    The enemy creature.
     */
    public Creature getEnemyCreature(){
        return this.enemyCreature;
    }

    /**
     * Sets the enemy creature for the battle phase.
     */
    public void setEnemyCreature(){
        Creature selectedCreature;
        int randomIndex = new Random().nextInt(enemyCreatures.size());

        selectedCreature = enemyCreatures.get(randomIndex);
        enemyCreature = new Creature(selectedCreature.getName(), selectedCreature.getType(), selectedCreature.getFamily(), selectedCreature.getEvolutionLevel());
    }

    public int getActionsLeft() {
        return this.actionsLeft;
    }
}