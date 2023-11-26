package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CreaturemonModel;
import Views.CreaturemonView;

public class CreaturemonController {

	private final CreaturemonView creaturemonView;
  	private final CreaturemonModel creaturemonModel;

	public CreaturemonController(CreaturemonView creaturemonView, CreaturemonModel creaturemonModel) {

		this.creaturemonView = creaturemonView;
    	this.creaturemonModel = creaturemonModel;

		creaturemonView.getStarterView().showStarterView(); // Initially show the starter view

		// Add action listener for selecting starting creature
		this.creaturemonView.getStarterView().setStarterCreatureBtnActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String actionCommand = e.getActionCommand();
			
				switch (actionCommand) {
					case "StrawanderBtn":
						System.out.println("User chose Strawander!");
						creaturemonModel.addCreatureToInventory("Strawander");
						break;
					case "ChocowoolBtn":
						System.out.println("User chose Chocowool!");
						creaturemonModel.addCreatureToInventory("Chocowool");
						break;
					case "ParfwitBtn":
						System.out.println("User chose Parfwit!");
						creaturemonModel.addCreatureToInventory("Parfwit");
						break;
					case "BrownisaurBtn":
						System.out.println("User chose Brownisaur!");
						creaturemonModel.addCreatureToInventory("Brownisaur");
						break;
					case "FrubatBtn":
						System.out.println("User chose Frubat!");
						creaturemonModel.addCreatureToInventory("Frubat");
						break;
					case "MaltsBtn":
						System.out.println("User chose Malts!");
						creaturemonModel.addCreatureToInventory("Malts");
						break;
					case "SquirpieBtn":
						System.out.println("User chose Squirpie!");
						creaturemonModel.addCreatureToInventory("Squirpie");
						break;
					case "ChocoliteBtn":
						System.out.println("User chose Chocolite!");
						creaturemonModel.addCreatureToInventory("Chocolite");
						break;
					case "OshaconeBtn":
						System.out.println("User chose Oshacone!");
						creaturemonModel.addCreatureToInventory("Oshacone");
						break;
					default:
						break;
				}		

				// Redirect to main menu
				creaturemonView.getMainMenuView().showMainMenu();
			}			
		});

		// Add action listener for menu buttons
		this.creaturemonView.getMainMenuView().setMainMenuBtnsActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String actionCommand = e.getActionCommand();
		
				switch (actionCommand) {
					case "viewInventoryBtn":
						System.out.println("User clicked View Inventory!");
						creaturemonView.getMainMenuView().getInventoryMenuView().showInventoryMenu();
						break;
					case "exploreAreaBtn":
						System.out.println("User clicked Explore Area!");
						creaturemonView.getMainMenuView().getAreaMenuView().showAreaMenu();
						break;
					case "evolveCreatureBtn":
						System.out.println("User clicked Evolve Creatures!");
						// Add logic for handling Evolve Creatures action
						break;
					case "exitBtn":
						System.out.println("User clicked Exit!");
						// Add logic for handling Exit action
						break;
					default:
						break;
				}
			}
		});
	}

}
