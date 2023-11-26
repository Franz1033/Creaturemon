package Model;
public class CreaturemonModel {
    
    private final Inventory inventory;

    public CreaturemonModel() {
        this.inventory = new Inventory();
    }

    public void addCreatureToInventory(String creatureName) {
        switch (creatureName) {
            case "Strawander":
                this.inventory.addCreature(new Creature("Strawander", "Fire", "A", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Chocowool":
                this.inventory.addCreature(new Creature("Chocowool", "Fire", "B", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Parfwit":
                this.inventory.addCreature(new Creature("Parfwit", "Fire", "C", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Brownisaur":
                this.inventory.addCreature(new Creature("Brownisaur", "Grass", "D", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Frubat":
                this.inventory.addCreature(new Creature("Frubat", "Grass", "E", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Malts":
                this.inventory.addCreature(new Creature("Malts", "Grass", "F", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Squirpie":
                this.inventory.addCreature(new Creature("Squirpie", "Water", "G", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Chocolite":
                this.inventory.addCreature(new Creature("Chocolite", "Water", "H", 1));
                this.inventory.displayCapturedCreatures();
                break;
            case "Oshacone":
                this.inventory.addCreature(new Creature("Oshacone", "Water", "I", 1));
                this.inventory.displayCapturedCreatures();
                break;
            default:
                break;
        }
    }
}

