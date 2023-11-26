package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CreaturemonModel;
import Views.StarterView;

public class CreaturemonController {

	private final StarterView starterView;
  	private final CreaturemonModel creaturemonModel;

	public CreaturemonController(StarterView starterView, CreaturemonModel creaturemonModel) {

		this.starterView = starterView;
    	this.creaturemonModel = creaturemonModel;

		this.starterView.setStarterCreatureBtnActionListener(new ActionListener() {
			
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
			}			
		});
	}

}
