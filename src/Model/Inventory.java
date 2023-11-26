package Model;

import java.util.ArrayList;

public class Inventory {

    private Creature activeCreature;
    private ArrayList<Creature> capturedCreatures;

    public Inventory() {
        this.activeCreature = null;
        this.capturedCreatures = new ArrayList<Creature>();
    }

    public void addCreature(Creature creature) {
        this.capturedCreatures.add(creature);

        if (this.capturedCreatures.size() == 1) 
            activeCreature = creature;
    }

    public void displayCapturedCreatures() {
        for (Creature c : capturedCreatures) {
            System.out.println("Creature:" + c);
        }
    }

    public Creature getActiveCreature() {
        return this.activeCreature;
    }

    public void setActiveCreature(Creature creature) {
        this.activeCreature = creature;
    }

}
