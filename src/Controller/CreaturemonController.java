package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import Model.Creature;
import Model.CreaturemonModel;
import Views.CreaturemonView;
import Views.SelectCreatureView;

public class CreaturemonController {

	private final CreaturemonView creaturemonView;
  	private final CreaturemonModel creaturemonModel;

	private SelectCreatureView selectCreatureView1;
	private SelectCreatureView selectCreatureView2;

	public CreaturemonController(CreaturemonView creaturemonView, CreaturemonModel creaturemonModel) {

		this.creaturemonView = creaturemonView;
    	this.creaturemonModel = creaturemonModel;

		selectCreatureView1 = new SelectCreatureView("Select First Creature");
		selectCreatureView2 = new SelectCreatureView("Select Second Creature");

		this.creaturemonView.getStarterView().showStarterView(); // Initially show the starter view

		// Add action listener for selecting starting creature
		this.creaturemonView.getStarterView().setStarterCreatureBtnActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String actionCommand = e.getActionCommand();
			
				switch (actionCommand) {
					case "StrawanderBtn":
						System.out.println("User chose Strawander!");
						creaturemonModel.addCreatureToInventory("Strawander");
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

		// Add action listener for main menu buttons
		this.creaturemonView.getMainMenuView().setMainMenuBtnsActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String actionCommand = e.getActionCommand();
		
				switch (actionCommand) {
					case "viewInventoryBtn":
						System.out.println("User clicked View Inventory!");
						creaturemonView.getInventoryMenuView().showInventoryMenu();
						break;
					case "exploreAreaBtn":
						System.out.println("User clicked Explore Area!");
						creaturemonView.getAreaMenuView().showAreaMenu();
						break;
					case "evolveCreatureBtn":
						System.out.println("User clicked Evolve Creatures!");
						creaturemonView.getEvolveCratureView().showEvolveCreatureView();
						break;
					case "exitBtn":
						System.out.println("User clicked Exit!");
						creaturemonView.dispose();
						break;
					default:
						break;
				}
			}
		});

		// Add action listener for inventory menu buttons
		this.creaturemonView.getInventoryMenuView().setInventoryMenuBtnsActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String actionCommand = e.getActionCommand();
		
				switch (actionCommand) {
					case "displayMyCreaturesBtn":
						System.out.println("User clicked Display My Creatures!");
						creaturemonView.getMyCreaturesView().setListOfCapturedCreatures(creaturemonModel.getInventory().getListOfCapturedCreatures());
						creaturemonView.getMyCreaturesView().initializeUI();
						setMyCreaturesBtnsActionListener();
						creaturemonView.getMyCreaturesView().showMyCreatures();
						break;
					case "changeActiveCreatureBtn":
						System.out.println("User clicked Change Active Creature!");
						creaturemonView.getChangeActiveCreatureView().setListOfCapturedCreatures(creaturemonModel.getInventory().getListOfCapturedCreatures());
						creaturemonView.getChangeActiveCreatureView().setActiveCreature(creaturemonModel.getInventory().getActiveCreature().getName());
						creaturemonView.getChangeActiveCreatureView().initializeUI();
						setChangeActiveCreatureBtnsActionListener();
						creaturemonView.getChangeActiveCreatureView().showChangeActiveCreatureView();
						break;
					case "goBackToMainMenuBtn":
						System.out.println("User clicked Go Back To Main Menu!");
						creaturemonView.getMainMenuView().showMainMenu();
						break;
					default:
						break;
				}
			}
		});

		// Add action listener for area menu buttons
		this.creaturemonView.getAreaMenuView().setAreaMenuBtnsActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String actionCommand = e.getActionCommand();
		
				switch (actionCommand) {
					case "areaTypeOneBtn":
						System.out.println("User clicked Area Type One!");
						// Add logic for handling Evolve Creatures action
						break;
					case "areaTypeTwoBtn":
						System.out.println("User clicked Area Type Two!");
						// Add logic for handling Evolve Creatures action
						break;
					case "areaTypeThreeBtn":
						System.out.println("User clicked Area Type Three!");
						// Add logic for handling Evolve Creatures action
						break;
					case "goBackToMainMenuBtn":
						System.out.println("User clicked Go Back To Main Menu!");
						creaturemonView.getMainMenuView().showMainMenu();
						break;
					default:
						break;
				}
			}
		});

		// Add action listner when user selects first creatures when evolving
		this.creaturemonView.getEvolveCratureView().setCreature1ImageBtnActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User is selecting first creature to evolve!");
				selectCreatureView1.closeFrame();
				selectCreatureView1.setListOfCapturedCreatures(creaturemonModel.getInventory().getListOfCapturedCreatures());
				selectCreatureView1.initializeUI();
				setSelectCreatureView1CreatureBtnsActionListener();
			}
		});

		// Add action listner when user selects first creatures when evolving
		this.creaturemonView.getEvolveCratureView().setCreature2ImageBtnActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User is selecting second creature to evolve!");
				selectCreatureView2.closeFrame();
				selectCreatureView2.setListOfCapturedCreatures(creaturemonModel.getInventory().getListOfCapturedCreatures());
				selectCreatureView2.initializeUI();
				setSelectCreatureView2CreatureBtnsActionListener();
			}
		});

		// Add action listener to evolve button
		this.creaturemonView.getEvolveCratureView().setEvolveButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User clicked evolve button!");
				creaturemonModel.getInventory().EvolveCreature(); // Try to evolve the creature
			}
		});

		// Add action listener so that evolve creature view can go back to main menu
		this.creaturemonView.getEvolveCratureView().setGoBackToMainMenuButtonActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User clicked Go Back To Main Menu!");
				creaturemonView.getMainMenuView().showMainMenu();
			}
		});
	}

	public void setMyCreaturesBtnsActionListener() {

		this.creaturemonView.getMyCreaturesView().setGoBackToInventoryMenuBtnActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User clicked Go Back To Inventory Menu!");
				creaturemonView.getInventoryMenuView().showInventoryMenu();
			}
		});
	}

	public void setChangeActiveCreatureBtnsActionListener() {

		this.creaturemonView.getChangeActiveCreatureView().setGoBackToInventoryMenuBtnActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("User clicked Go Back To Inventory Menu!");
				creaturemonView.getInventoryMenuView().showInventoryMenu();
			}
		});

		for (int i = 0; i < this.creaturemonModel.getInventory().getCapturedCreatures().size(); i++) {

			final int index = i; 

			this.creaturemonView.getChangeActiveCreatureView().setSelectBtnActionListener(new ActionListener() { 

				@Override
				public void actionPerformed(ActionEvent e) {
					creaturemonModel.getInventory().setActiveCreature(creaturemonModel.getInventory().getCapturedCreatures().get(index));
				}

			}, i);
		}
	}

	// Button click action listner for the select creature view for evolving the creature
	public void setSelectCreatureView1CreatureBtnsActionListener() {

		this.selectCreatureView1.setCreatureBtnsActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {
				String actionCommand = e.getActionCommand();
				creaturemonModel.getInventory().setSelectedCreature1(creaturemonModel.getInventory().getCapturedCreatures().get(Integer.parseInt(actionCommand)));
				creaturemonView.getEvolveCratureView().setCreatureImage1(creaturemonModel.getInventory().getSelectedCreature1().getName(), String.valueOf(creaturemonModel.getInventory().getSelectedCreature1().getEvolutionLevel()));
				selectCreatureView1.closeFrame();
			}
		});
	}

	// Button click action listner for the select creature view for evolving the creature
	public void setSelectCreatureView2CreatureBtnsActionListener() {

		this.selectCreatureView2.setCreatureBtnsActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {

				String actionCommand = e.getActionCommand();
				creaturemonModel.getInventory().setSelectedCreature2(creaturemonModel.getInventory().getCapturedCreatures().get(Integer.parseInt(actionCommand)));
				creaturemonView.getEvolveCratureView().setCreatureImage2(creaturemonModel.getInventory().getSelectedCreature2().getName(), String.valueOf(creaturemonModel.getInventory().getSelectedCreature2().getEvolutionLevel()));
				selectCreatureView2.closeFrame();
			}
		});
	}

}
