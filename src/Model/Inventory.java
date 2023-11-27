package Model;

import java.util.ArrayList;

public class Inventory {

    private Creature activeCreature;
    private ArrayList<Creature> capturedCreatures;
    private ArrayList<ArrayList<Object>> listOfCapturedCreatures;

    public Inventory() {
        this.activeCreature = null;
        this.capturedCreatures = new ArrayList<Creature>();
        this.listOfCapturedCreatures = new ArrayList<>();
    }

    public void addCreature(Creature creature) {
        this.capturedCreatures.add(creature);

        if (this.capturedCreatures.size() == 1) 
            activeCreature = creature;

        System.out.println(creature.getName() + " (" + creature + ") has been added to user inventory!");
    }

    public ArrayList<ArrayList<Object>> getListOfCapturedCreatures() {
        
        listOfCapturedCreatures.clear();
    
        for (Creature capturedCreature : capturedCreatures) {
            ArrayList<Object> capturedCreatureData = new ArrayList<>();
            capturedCreatureData.add(capturedCreature.getName());
            capturedCreatureData.add(capturedCreature.getType());
            capturedCreatureData.add(capturedCreature.getFamily());
            capturedCreatureData.add(capturedCreature.getEvolutionLevel());
    
            listOfCapturedCreatures.add(capturedCreatureData);
        }
    
        return this.listOfCapturedCreatures;
    }
    

    public Creature getActiveCreature() {
        return this.activeCreature;
    }

    public void setActiveCreature(Creature creature) {
        this.activeCreature = creature;
    }

}
