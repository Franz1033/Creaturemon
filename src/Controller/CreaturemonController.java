package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

import Exceptions.OutOfBoundsMovementException;
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
						creaturemonModel.addCreatureToInventory("Chocowool");
						creaturemonModel.addCreatureToInventory("Strawander");
						creaturemonModel.addCreatureToInventory("Chocowool");
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

		// Add mouse listener for select starter creature view
		this.creaturemonView.getStarterView().setStarterCreatureBtnMouseListener(new java.awt.event.MouseAdapter() {
			private Color originalColor;
			private Border originalBorder;

			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				JButton source = (JButton) evt.getSource();
				originalColor = source.getBackground();
				originalBorder = source.getBorder();
				creaturemonView.getStarterView().changeBtnBackgroundColor(source.getActionCommand(), new Color(144, 238, 144)); 
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				JButton source = (JButton) evt.getSource();
				source.setBackground(originalColor);
				source.setBorder(originalBorder);
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
						creaturemonModel.getArea1().displayAreaGrid();
						creaturemonView.getAreaTypeOneView().setImageIcon(creaturemonModel.getInventory().getActiveCreature().getName(), String.valueOf(creaturemonModel.getInventory().getActiveCreature().getEvolutionLevel()));
						creaturemonView.getAreaTypeOneView().markCell();
						creaturemonView.getAreaTypeOneView().showAreaTypeOneView();
						creaturemonView.getAreaTypeOneView().requestFocusOnArea();
						break;
					case "areaTypeTwoBtn":
						System.out.println("User clicked Area Type Two!");
						creaturemonModel.getArea2().displayAreaGrid();
						creaturemonView.getAreaTypeTwoView().setImageIcon(creaturemonModel.getInventory().getActiveCreature().getName(), String.valueOf(creaturemonModel.getInventory().getActiveCreature().getEvolutionLevel()));
						creaturemonView.getAreaTypeTwoView().markCell();
						creaturemonView.getAreaTypeTwoView().showAreaTypeTwoView();
						creaturemonView.getAreaTypeTwoView().requestFocusOnArea();
						break;
					case "areaTypeThreeBtn":
						System.out.println("User clicked Area Type Three!");
						creaturemonModel.getArea3().displayAreaGrid();
						creaturemonView.getAreaTypeThreeView().setImageIcon(creaturemonModel.getInventory().getActiveCreature().getName(), String.valueOf(creaturemonModel.getInventory().getActiveCreature().getEvolutionLevel()));
						creaturemonView.getAreaTypeThreeView().markCell();
						creaturemonView.getAreaTypeThreeView().showAreaTypeThreeView();
						creaturemonView.getAreaTypeThreeView().requestFocusOnArea();
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

				// Try to evolve the creature
				if (creaturemonModel.getInventory().EvolveCreature()) {
					creaturemonView.getMyCreaturesView().setListOfCapturedCreatures(creaturemonModel.getInventory().getListOfCapturedCreatures());
					creaturemonView.getMyCreaturesView().initializeUI();
					setMyCreaturesBtnsActionListener();
					creaturemonView.getMyCreaturesView().showMyCreatures();
				} 
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

		// Controls for explore area type 1
		this.creaturemonView.getAreaTypeOneView().setAreaTypeOneViewKeyListener(new KeyListener() {
			
			@Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
				creaturemonView.getAreaTypeOneView();

				int curPos = creaturemonView.getAreaTypeOneView().getCurPos();

				try {
				
					if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("I moved left!");
						creaturemonModel.getArea1().displayActiveArea('a');
						int newCurPos = curPos - 1;
						creaturemonView.getAreaTypeOneView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeOneView().markCell();
					} else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("I moved right!");
						creaturemonModel.getArea1().displayActiveArea('d');
						int newCurPos = curPos + 1;
						creaturemonView.getAreaTypeOneView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeOneView().markCell();
					} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						creaturemonView.getAreaTypeOneView().setCurPos(0);
						creaturemonView.getMainMenuView().showMainMenu();
					}
				} catch (OutOfBoundsMovementException ex) {
					creaturemonView.getAreaTypeOneView().setCurPos(curPos);
					creaturemonView.getAreaTypeOneView().markCell();
				}
				
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
            }
		});
		
		// Controls explore for area type 2
		this.creaturemonView.getAreaTypeTwoView().setAreaTypeOneViewKeyListener(new KeyListener() {
			
			@Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
				creaturemonView.getAreaTypeTwoView();

				int curPos = creaturemonView.getAreaTypeTwoView().getCurPos();

				try {
				
					if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("I moved left!");
						creaturemonModel.getArea2().displayActiveArea('a');
						int newCurPos = curPos - 1;
						creaturemonView.getAreaTypeTwoView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeTwoView().markCell();
					} else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("I moved right!");
						creaturemonModel.getArea2().displayActiveArea('d');
						int newCurPos = curPos + 1;
						creaturemonView.getAreaTypeTwoView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeTwoView().markCell();
					} else if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyCode() == KeyEvent.VK_UP) {
						System.out.println("I moved up!");
						creaturemonModel.getArea2().displayActiveArea('w');
						int newCurPos = curPos - 3;
						creaturemonView.getAreaTypeTwoView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeTwoView().markCell(); 
					} else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyCode() == KeyEvent.VK_DOWN) {
						System.out.println("I moved down!");
						creaturemonModel.getArea2().displayActiveArea('s');
						int newCurPos = curPos + 3;
						creaturemonView.getAreaTypeTwoView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeTwoView().markCell();
					} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						creaturemonView.getAreaTypeTwoView().setCurPos(0);
						creaturemonView.getMainMenuView().showMainMenu();
					}
				} catch (OutOfBoundsMovementException ex) {
					creaturemonView.getAreaTypeTwoView().setCurPos(curPos);
					creaturemonView.getAreaTypeTwoView().markCell();
				} 
				
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
            }
		});

		// Controls for explore area type 3
		this.creaturemonView.getAreaTypeThreeView().setAreaTypeOneViewKeyListener(new KeyListener() {
			
			@Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
				creaturemonView.getAreaTypeThreeView();

				int curPos = creaturemonView.getAreaTypeThreeView().getCurPos();

				try {
					if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == KeyEvent.VK_LEFT) {
						System.out.println("I moved left!");
						creaturemonModel.getArea3().displayActiveArea('a');
						int newCurPos = curPos - 1;
						creaturemonView.getAreaTypeThreeView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeThreeView().markCell();
					} else if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == KeyEvent.VK_RIGHT) {
						System.out.println("I moved right!");
						creaturemonModel.getArea3().displayActiveArea('d');
						int newCurPos = curPos + 1;
						creaturemonView.getAreaTypeThreeView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeThreeView().markCell();
					} else if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyCode() == KeyEvent.VK_UP) {
						System.out.println("I moved up!");
						creaturemonModel.getArea3().displayActiveArea('w');
						int newCurPos = curPos - 4;
						creaturemonView.getAreaTypeThreeView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeThreeView().markCell();
					} else if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyCode() == KeyEvent.VK_DOWN) {
						System.out.println("I moved down!");
						creaturemonModel.getArea3().displayActiveArea('s');
						int newCurPos = curPos + 4;
						creaturemonView.getAreaTypeThreeView().setCurPos(newCurPos);
						creaturemonView.getAreaTypeThreeView().markCell();
					} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
						creaturemonView.getAreaTypeThreeView().setCurPos(0);
						creaturemonView.getMainMenuView().showMainMenu();
					}

				} catch (OutOfBoundsMovementException ex) {
					creaturemonView.getAreaTypeTwoView().setCurPos(curPos);
					creaturemonView.getAreaTypeTwoView().markCell();
				} 
				
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
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
					// If selected creature is already active
					if (creaturemonModel.getInventory().setActiveCreature(creaturemonModel.getInventory().getCapturedCreatures().get(index))) {
						JOptionPane.showMessageDialog(null, "Creature is already active!", "Creature Already Active Exception", JOptionPane.ERROR_MESSAGE);					
					// Else, set that creature as new active creature
					} else {
						creaturemonModel.getInventory().setActiveCreature(creaturemonModel.getInventory().getCapturedCreatures().get(index));
						creaturemonView.getChangeActiveCreatureView().setActiveCreature((creaturemonModel.getInventory().getCapturedCreatures().get(index).getName()));
						creaturemonView.getChangeActiveCreatureView().updateActiveCreatureLabel(); 
						JOptionPane.showMessageDialog(null, creaturemonModel.getInventory().getCapturedCreatures().get(index).getName() + " (" + creaturemonModel.getInventory().getCapturedCreatures().get(index) + ") is now the active creature!", "New Active Creature Set!", JOptionPane.INFORMATION_MESSAGE);
					}
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

				if (creaturemonModel.getInventory().setSelectedCreature1(creaturemonModel.getInventory().getCapturedCreatures().get(Integer.parseInt(actionCommand)))) {
					creaturemonView.getEvolveCratureView().setCreatureImage1(creaturemonModel.getInventory().getSelectedCreature1().getName(), String.valueOf(creaturemonModel.getInventory().getSelectedCreature1().getEvolutionLevel()));
					selectCreatureView1.closeFrame();
				}
			}
		});
	}

	// Button click action listner for the select creature view for evolving the creature
	public void setSelectCreatureView2CreatureBtnsActionListener() {

		this.selectCreatureView2.setCreatureBtnsActionListener(new ActionListener() {
			
			@Override 
			public void actionPerformed(ActionEvent e) {

				String actionCommand = e.getActionCommand();

				if (creaturemonModel.getInventory().setSelectedCreature2(creaturemonModel.getInventory().getCapturedCreatures().get(Integer.parseInt(actionCommand)))) {
					creaturemonView.getEvolveCratureView().setCreatureImage2(creaturemonModel.getInventory().getSelectedCreature2().getName(), String.valueOf(creaturemonModel.getInventory().getSelectedCreature2().getEvolutionLevel()));
					selectCreatureView2.closeFrame();
				}
			}
		});
	}

}
