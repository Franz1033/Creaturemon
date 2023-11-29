package Views;

import javax.swing.*;
import java.awt.*;

public class BattlePhaseView {

    private JFrame battleFrame;
    private JPanel activeCreaturePanel;
    private JPanel enemyCreaturePanel;
    private JPanel controlPanel;

    public BattlePhaseView() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        battleFrame = new JFrame("Battle Phase");
        battleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Get the content pane of the frame
        Container contentPane = battleFrame.getContentPane();
        contentPane.setLayout(new BorderLayout());
    
        activeCreaturePanel = createCreaturePanel("Active Creature Name", "1");
        enemyCreaturePanel = createCreaturePanel("Enemy Creature Name", "2");
        controlPanel = createControlPanel();
    
        // Add an empty border to the content pane
        ((JComponent) contentPane).setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    
        contentPane.add(activeCreaturePanel, BorderLayout.WEST);
        contentPane.add(enemyCreaturePanel, BorderLayout.EAST);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
    
        battleFrame.setSize(800, 600);
        battleFrame.setLocationRelativeTo(null);
        battleFrame.setVisible(true);
    }
    private JPanel createCreaturePanel(String creatureName, String evolutionLevel) {
        JPanel creaturePanel = new JPanel(new GridBagLayout());
        creaturePanel.setPreferredSize(new Dimension(200, 100)); // Set fixed size
    
        // Replace these paths with the actual paths to your creature images
        ImageIcon creatureImage = new ImageIcon("media/lvl1_creatures/Chocowool.png");
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
    
        return creaturePanel;
    }
    
    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new GridLayout(1, 4, 10, 10)); // Adding horizontal and vertical gaps
        
        JButton attackButton = new JButton("Attack");
        JButton swapButton = new JButton("Swap");
        JButton catchButton = new JButton("Catch");
        JButton runButton = new JButton("Run");
        
        controlPanel.add(attackButton);
        controlPanel.add(swapButton);
        controlPanel.add(catchButton);
        controlPanel.add(runButton);
    
        // Add an empty border to the top of the control panel for margin
        controlPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    
        return controlPanel;
    }
       

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BattlePhaseView());
    }
}
