package Model;

import java.util.ArrayList;

public class CreaturemonModel {
    
    private final Inventory inventory;
    public static ArrayList<Creature> creatures = new ArrayList<Creature>();

    public CreaturemonModel() {
        this.inventory = new Inventory();

        ArrayList<Creature> levelOneCreatures = new ArrayList<Creature>();
        ArrayList<Creature> levelTwoCreatures = new ArrayList<Creature>();
        ArrayList<Creature> levelThreeCreatures = new ArrayList<Creature>();

        Area area1 = new Area(inventory, levelOneCreatures, 5, 1);
        Area area2 = new Area(inventory, levelTwoCreatures, 3, 3);
        Area area3 = new Area(inventory, levelThreeCreatures, 4, 4);

        createCreatures(creatures);
        setAreaOneCreatures(creatures, levelOneCreatures);
        setAreaTwoCreatures(creatures, levelTwoCreatures);
        setAreaThreeCreatures(creatures, levelThreeCreatures);
    }

    public void addCreatureToInventory(String creatureName) {
        switch (creatureName) {
            case "Strawander":
                this.inventory.addCreature(new Creature("Strawander", "Fire", "A", 1));
                break;
            case "Chocowool":
                this.inventory.addCreature(new Creature("Chocowool", "Fire", "B", 1));
                break;
            case "Parfwit":
                this.inventory.addCreature(new Creature("Parfwit", "Fire", "C", 1));
                break;
            case "Brownisaur":
                this.inventory.addCreature(new Creature("Brownisaur", "Grass", "D", 1));
                break;
            case "Frubat":
                this.inventory.addCreature(new Creature("Frubat", "Grass", "E", 1));
                break;
            case "Malts":
                this.inventory.addCreature(new Creature("Malts", "Grass", "F", 1));
                break;
            case "Squirpie":
                this.inventory.addCreature(new Creature("Squirpie", "Water", "G", 1));
                break;
            case "Chocolite":
                this.inventory.addCreature(new Creature("Chocolite", "Water", "H", 1));
                break;
            case "Oshacone":
                this.inventory.addCreature(new Creature("Oshacone", "Water", "I", 1));
                break;
            default:
                break;
        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setAreaOneCreatures(ArrayList<Creature> creatures, ArrayList<Creature> levelOneCreatures) {

        for (Creature creature : creatures) {
            if (creature.getEvolutionLevel() == 1 || creature.getEvolutionLevel() == 1) {
                levelOneCreatures.add(creature);
            }
        }
    }

    public void setAreaTwoCreatures(ArrayList<Creature> creatures, ArrayList<Creature> levelTwoCreatures) {

        for (Creature creature : creatures) {
            if (creature.getEvolutionLevel() == 1 || creature.getEvolutionLevel() == 2) {
                levelTwoCreatures.add(creature);
            }
        }
    }

    public void setAreaThreeCreatures(ArrayList<Creature> creatures, ArrayList<Creature> levelThreeCreatures) {

        for (Creature creature : creatures) {
            if (creature.getEvolutionLevel() == 1 || creature.getEvolutionLevel() == 2 || creature.getEvolutionLevel() == 3) {
                levelThreeCreatures.add(creature);
            }
        }
    }

    
    static void createCreatures(ArrayList<Creature> creatures) {

        // Create creature objects
        Creature creature1 = new Creature("Strawander", "Fire", "A", 1);
        Creature creature2 = new Creature("Chocowool", "Fire", "B", 1);
        Creature creature3 = new Creature("Parfwit", "Fire", "C", 1);
        Creature creature4 = new Creature("Brownisaur", "Grass", "D", 1);
        Creature creature5 = new Creature("Frubat", "Grass", "E", 1);
        Creature creature6 = new Creature("Malts", "Grass", "F", 1);
        Creature creature7 = new Creature("Squirpie", "Water", "G", 1);
        Creature creature8 = new Creature("Chocolite", "Water", "H", 1);
        Creature creature9 = new Creature("Oshacone", "Water", "I", 1);

        Creature creature10 = new Creature("Strawleon", "Fire", "A", 2);
        Creature creature11 = new Creature("Chocofluff", "Fire", "B", 2);
        Creature creature12 = new Creature("Parfure", "Fire", "C", 2);
        Creature creature13 = new Creature("Chocosaur", "Grass", "D", 2);
        Creature creature14 = new Creature("Golberry", "Grass", "E", 2);
        Creature creature15 = new Creature("Kirlicake", "Grass", "F", 2);
        Creature creature16 = new Creature("Tartortle", "Water", "G", 2);
        Creature creature17 = new Creature("Chocolish", "Water", "H", 2);
        Creature creature18 = new Creature("Dewice", "Water", "I", 2);

        Creature creature19 = new Creature("Strawizard", "Fire", "A", 3);
        Creature creature20 = new Creature("Candaros", "Fire", "B", 3);
        Creature creature21 = new Creature("Parfelure", "Fire", "C", 3);
        Creature creature22 = new Creature("Fudgasaur", "Grass", "D", 3);
        Creature creature23 = new Creature("Croberry", "Grass", "E", 3);
        Creature creature24 = new Creature("Velvevor", "Grass", "F", 3);
        Creature creature25 = new Creature("Piestoise", "Water", "G", 3);
        Creature creature26 = new Creature("Icesundae", "Water", "H", 3);
        Creature creature27 = new Creature("Samurcone", "Water", "I", 3);

        // Add to creatures array list
        creatures.add(creature1);
        creatures.add(creature2);
        creatures.add(creature3);
        creatures.add(creature4);
        creatures.add(creature5);
        creatures.add(creature6);
        creatures.add(creature7);
        creatures.add(creature8);
        creatures.add(creature9);

        creatures.add(creature10);
        creatures.add(creature11);
        creatures.add(creature12);
        creatures.add(creature13);
        creatures.add(creature14);
        creatures.add(creature15);
        creatures.add(creature16);
        creatures.add(creature17);
        creatures.add(creature18);

        creatures.add(creature19);
        creatures.add(creature20);
        creatures.add(creature21);
        creatures.add(creature22);
        creatures.add(creature23);
        creatures.add(creature24);
        creatures.add(creature25);
        creatures.add(creature26);
        creatures.add(creature27);
    }  

    public static ArrayList<Creature> getAllCreatures() {
        return creatures;
    }

}