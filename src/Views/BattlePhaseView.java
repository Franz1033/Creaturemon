package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BattlePhaseView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel battlePhaseViewPanel;

    private JPanel activeCreaturePanel;
    private JPanel enemyCreaturePanel;
    private JPanel controlPanel;

    private String enemyCreatureName;
    private String activeCreatureName;

    private String enemyCreatureLvl;
    private String activeCreatureLvl;

    JButton attackButton;
    JButton swapButton;
    JButton catchButton;
    JButton runButton;

    private String enemyHealth;

    public BattlePhaseView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.battlePhaseViewPanel = new JPanel(new BorderLayout());

        cardPanel.add(battlePhaseViewPanel, "Battle Phase View");
    }

    public void showBattlePhaseView() {
        cardLayout.show(cardPanel, "Battle Phase View");
    }

    public void setEnemyCreatureNameAndLvl(String name, String lvl) {
        this.enemyCreatureName = name;
        this.enemyCreatureLvl = lvl;
    }

    public void setActiveCreatureNameAndLvl(String name, String lvl) {
        this.activeCreatureName = name;
        this.activeCreatureLvl= lvl;
    }

    public void createAndShowGUI() {

        battlePhaseViewPanel.removeAll();
    
        activeCreaturePanel = createCreaturePanel(activeCreatureName, activeCreatureLvl, "NE");
        enemyCreaturePanel = createCreaturePanel(enemyCreatureName, enemyCreatureLvl, "E");
        controlPanel = createControlPanel();
    
        battlePhaseViewPanel.add(activeCreaturePanel, BorderLayout.WEST);
        battlePhaseViewPanel.add(enemyCreaturePanel, BorderLayout.EAST);
        battlePhaseViewPanel.add(controlPanel, BorderLayout.SOUTH);

        battlePhaseViewPanel.revalidate();
        battlePhaseViewPanel.repaint();
    }

    private JPanel createCreaturePanel(String creatureName, String evolutionLevel, String indicator) {
        JPanel creaturePanel = new JPanel(new GridBagLayout());
        creaturePanel.setPreferredSize(new Dimension(200, 100)); // Set fixed size
    
        ImageIcon creatureImage = new ImageIcon("media/lvl" + evolutionLevel + "_creatures/" + creatureName + ".png");
        JLabel imageLabel = new JLabel(creatureImage);
    
        JLabel nameLabel = new JLabel("Name: " + creatureName);
        JLabel evolutionLabel = new JLabel("Evolution Level: " + evolutionLevel);
    
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 0); // Set top margin
    
        creaturePanel.add(imageLabel, gbc);
    
        gbc.gridy = 1;
        creaturePanel.add(nameLabel, gbc);
    
        gbc.gridy = 2;
        creaturePanel.add(evolutionLabel, gbc);

        if (indicator.equals("E")) {
            JLabel enemyHealthLabel = new JLabel("Enemy health: " + enemyHealth);
            gbc.gridy = 3;
            creaturePanel.add(enemyHealthLabel, gbc);
        } else if (indicator.equals("NE")) {
            JLabel actionsLeftLabel = new JLabel("Actions left: 3");
            gbc.gridy = 4;
            creaturePanel.add(actionsLeftLabel, gbc);
        }
    
        return creaturePanel;
    }

    public void setEnemyHealth(String enemyHealth) {
        this.enemyHealth = enemyHealth;
    }
    
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // Adding horizontal and vertical gaps
        
        attackButton = new JButton("Attack");
        swapButton = new JButton("Swap");
        catchButton = new JButton("Catch");
        runButton = new JButton("Run");
        
        controlPanel.add(attackButton);
        controlPanel.add(swapButton);
        controlPanel.add(catchButton);
        controlPanel.add(runButton);
    
        // Add an empty border to the top of the control panel for margin
        controlPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    
        return controlPanel;
    }
    
    public void setBattlePhaseViewActionListener(ActionListener actionListener) {
        this.attackButton.addActionListener(actionListener);
        this.attackButton.setActionCommand("attackBtn");

        this.swapButton.addActionListener(actionListener);
        this.swapButton.setActionCommand("swapBtn");

        this.catchButton.addActionListener(actionListener);
        this.catchButton.setActionCommand("catchBtn");

        this.runButton.addActionListener(actionListener);
        this.runButton.setActionCommand("runBtn");
    }
}
