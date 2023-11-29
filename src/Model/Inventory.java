package Model;

import java.util.ArrayList;

public class Inventory {

    private Creature activeCreature;
    private ArrayList<Creature> capturedCreatures;
    private ArrayList<ArrayList<Object>> listOfCapturedCreatures;

    Creature selectedCreature1;
    Creature selectedCreature2;

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

    public ArrayList<Creature> getCapturedCreatures() {
        return this.capturedCreatures;
    }

    public Creature getActiveCreature() {
        return this.activeCreature;
    }

    public boolean setActiveCreature(Creature creature) {
        if (creature == activeCreature) {
            System.out.println("Creature is already active");
            return true;
        } else {
            this.activeCreature = creature;
            System.out.println(creature.getName() + " (" + creature + ") has been set to active creature!");
            return false;
        }
    }

    public boolean setSelectedCreature1(Creature selectedCreature1) {
        if (selectedCreature2 == selectedCreature1) {
            System.out.println("You can't set same creature object!");
            return false;
        } else {
            this.selectedCreature1 = selectedCreature1;
            System.out.println(selectedCreature1.getName() + " (" + selectedCreature1 + ") has been set as creature 1!");
            return true;
        }
    }

    public boolean setSelectedCreature2(Creature selectedCreature2) {
        if (selectedCreature2 == selectedCreature1) {
            System.out.println("You can't set same creature object!");
            return false;
        } else {
            this.selectedCreature2 = selectedCreature2;
            System.out.println(selectedCreature2.getName() + " (" + selectedCreature2 + ") has been set as creature 2!");
            return true;
        }
    }

    public Creature getSelectedCreature1() {
        return this.selectedCreature1;
    }

    public Creature getSelectedCreature2() {
        return this.selectedCreature2;
    }


    public boolean EvolveCreature() {

        // If neither of the selected creatures has been initialized
        if (selectedCreature1 == null || selectedCreature2 == null) {
            System.out.println("You didn't fully select creatures yet!");
            return false;
        // If creatures don't have the same family
        } else if (!selectedCreature1.getFamily().equals(selectedCreature2.getFamily())) {
            System.out.println("Creatures don't have the same family!");
            return false;
        // If creatures don't have the same level
        } else if (selectedCreature1.getEvolutionLevel() != selectedCreature2.getEvolutionLevel()) {
            System.out.println("Creatures don't have the same level!");
            return false;
        // If one or both of the creatures is already maxed
        } else if (selectedCreature1.getEvolutionLevel() == 3 || selectedCreature2.getEvolutionLevel() == 3) {
            System.out.println("One or both of the creatures is already maxed!");
            return false;
        } else {

            Creature evolvedCreature = null;

            // Evolve the creature
            for (Creature creature : CreaturemonModel.getAllCreatures()) {
                if (creature.getFamily().equals(selectedCreature1.getFamily()) && creature.getEvolutionLevel() == (selectedCreature1.getEvolutionLevel() + 1)) {
                    evolvedCreature = new Creature(
                        creature.getName(),
                        creature.getType(),
                        creature.getFamily(),
                        creature.getEvolutionLevel() 
                    );
                }
            }

            // Add evolved creature to inventory
            capturedCreatures.add(evolvedCreature); 
            System.out.println(evolvedCreature.getName() + " (" + evolvedCreature + ") has been added to inventory!");

            // Remove creatures that were merged
            capturedCreatures.remove(selectedCreature1);
            capturedCreatures.remove(selectedCreature2);
            System.out.println(selectedCreature1.getName() + " (" + selectedCreature1 + ") and " + selectedCreature2.getName() + " (" +
                               selectedCreature2 + ") has now been removed from the inventory!");

            // Set evolved creature as active
            setActiveCreature(evolvedCreature);
            
            return true;
        }

    }

}
