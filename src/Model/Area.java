package Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Area class represents a game area where a player can move and encounter creatures.
 * It is responsible for displaying the game grid, handling player movements, and triggering battles.
 */
public class Area {


    /**
     * The player's inventory.
     */
    private Inventory inventory;

    /**
     * Indicates whether the player is currently in an active area.
     */
    private boolean isOnActiveArea;

    /**
     * The width of the area grid.
     */
    private int width;

    /**
     * The height of the area grid.
     */
    private int height;

    /**
     * The current position of the player on the area grid.
     */
    private int currentPosition;

    /**
     * List representing the area grid with player's current position marked.
     */
    private ArrayList<String> areaGrid;

    /**
     * The battle phase associated with the area.
     */
    private BattlePhase battlePhase;

    /**
     * List of creatures in the area.
     */
    private ArrayList<Creature> creatures;

    /**
     * Marker symbol used to indicate the player's position on the area grid.
     */
    private static final String MARKER = "X";

    /**
     * Constructs an Area object.
     * @param inventory 
     *     The player's inventory.
     * @param creatures 
     *     A list of creatures in the area.
     */
    public Area(Inventory inventory, ArrayList<Creature> creatures, int width, int height){
        this.width = width;
        this.height = height;
        this.creatures = creatures;
        this.inventory = inventory;
        this.areaGrid = new ArrayList<String>();
        this.isOnActiveArea = false;
        this.currentPosition = 0;
    }

    /**
     * Displays the active area to the player and handles player movements and interactions.
     */
    public void displayActiveArea(char opt) {
        boolean isPlaying = true;

        while (isPlaying) {
            displayAreaGrid();  //displays the grid
            System.out.println("Choose an Action");
            
            // valid player movement checker
            if (opt == 'w' && currentPosition > width - 1)
                playerMovement("UP");
            else if (opt == 'a' && (currentPosition + 1) % width - 1 != 0)
                playerMovement("LEFT");
            else if (opt == 's' && currentPosition < height * width - width)
                playerMovement("DOWN");
            else if (opt == 'd' && (currentPosition + 1) % width != 0)
                playerMovement("RIGHT");
            else if (opt == 'm') {
                isPlaying = false;
                currentPosition = 0; // Initialize current position back to 0
            }
        }
    }

    /**
     * Handles player movement within the area grid and triggers creature encounters.
     * @param direction 
     *     The direction in which the player wants to move ('UP', 'LEFT', 'DOWN', 'RIGHT').
     */
    public void playerMovement(String direction){
        
        if (direction == "UP")
            currentPosition -= width;
        else if (direction == "LEFT")
            currentPosition--;
        else if (direction == "DOWN")
            currentPosition += width;
        else if (direction == "RIGHT")
            currentPosition++;
        
        encounter(); // Try to encounter a creature
    }

    /**
     * Simulates a creature encounter based on a 40% chance and triggers a battle if applicable.
     */
    public void encounter() {

        int randomChance = new Random().nextInt(100) + 1;

        // 40% chance of encountering a creature
        if (randomChance <= 40) {
            System.out.println("Creature alert");
            this.battlePhase = new BattlePhase(inventory, creatures, this);
            //battlePhase.displayBattlePhase();
        }
    }

    /**
     * Displays the area grid with the player's current position marked.
     */
    public void displayAreaGrid(){

        int i, j;
        int tileNumber = 0;

        areaGrid.clear();

        for (i=0; i < height; i++) {   
            for(j=0; j < width; j++) {
                areaGrid.add(" ");
            }
        }

        areaGrid.set(currentPosition, MARKER);
        
        for (i=0; i < height; i++) {
            for(j=0; j < width; j++) {
                System.out.printf(" | %s |", areaGrid.get(tileNumber));
                tileNumber++;
            }

            System.out.println();
        }    
    }

    /**
     * Gets the current active area status.
     *
     * @return 
     *    true if the player is in an active area, false otherwise.
     */
    public boolean getIsOnActiveArea(){
        return this.isOnActiveArea;
    }

    /**
     * Gets the current battle phase.
     *
     * @return 
     *    The current battle phase.
     */
    public BattlePhase getBattlePhase(){
        return this.battlePhase;
    }

    /**
     * Sets the active area status.
     * @param isOnActiveArea 
     *     true to set the player in an active area, false otherwise.
     */
    public void setIsOnActiveArea(boolean isOnActiveArea){
        this.isOnActiveArea = isOnActiveArea;
    }
}