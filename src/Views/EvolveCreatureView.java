package Views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EvolveCreatureView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel evolveCreatureViewPanel;

    private JButton creature1ImageBtn;
    private JButton creature2ImageBtn;
    private JButton evolveButton;
    private JButton goBackToMainMenuBtn;

    private ImageIcon creature1Image;
    private ImageIcon creature2Image;
    private ImageIcon defaultImg;

    public EvolveCreatureView(JPanel cardPanel, CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.evolveCreatureViewPanel = new JPanel(new BorderLayout());

        defaultImg = new ImageIcon("media/default_img.png");
        creature1Image = new ImageIcon();
        creature2Image = new ImageIcon();

        initializeUI();

        cardPanel.add(evolveCreatureViewPanel, "Evolve Creature View");
    }

    public void initializeUI() {
   
        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
        
        JLabel titleLabel = new JLabel("Evolve Creatures");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        
        titleLabelPanel.add(titleLabel);
        evolveCreatureViewPanel.add(titleLabelPanel, BorderLayout.NORTH); 

        // Create panel for evolving
        JPanel creaturesPanel = new JPanel(new GridBagLayout());

        // Create panel for the first creature
        JPanel creaturePanel1 = new JPanel();
        creaturePanel1.setLayout(new BoxLayout(creaturePanel1, BoxLayout.Y_AXIS));
        creaturePanel1.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));
        JLabel creature1ImageLabel = new JLabel("Select creature 1: ");
        creature1ImageBtn = new JButton(creature1Image);
        creaturePanel1.add(creature1ImageLabel);
        creaturePanel1.add(creature1ImageBtn);

        // Create panel for second creature
        JPanel creaturePanel2 = new JPanel();
        creaturePanel2.setLayout(new BoxLayout(creaturePanel2, BoxLayout.Y_AXIS));
        creaturePanel2.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));
        JLabel creature2ImageLabel = new JLabel("Select creature 2: ");
        creature2ImageBtn = new JButton(creature2Image);
        creaturePanel2.add(creature2ImageLabel);
        creaturePanel2.add(creature2ImageBtn);

        // Create button to evolve creatures
        evolveButton = new JButton("Evolve");
        evolveButton.setOpaque(true);
        evolveButton.setBorderPainted(false);
        evolveButton.setBackground(Color.RED);
        evolveButton.setForeground(Color.WHITE);
        evolveButton.setMargin(new Insets(10, 20, 10, 20));

        // Add to creatures panel
        creaturesPanel.add(creaturePanel1);
        creaturesPanel.add(evolveButton);
        creaturesPanel.add(creaturePanel2);

        // Create panel for other buttons
        JPanel otherButtonsPanel = new JPanel();
        otherButtonsPanel.setBorder(BorderFactory.createEmptyBorder(25, 0, 25, 0));

        // Buttons for back
        goBackToMainMenuBtn = new JButton("Go back");
        goBackToMainMenuBtn.setOpaque(true);
        goBackToMainMenuBtn.setBorderPainted(false);
        goBackToMainMenuBtn.setBackground(Color.ORANGE);
        goBackToMainMenuBtn.setForeground(Color.WHITE);
        goBackToMainMenuBtn.setMargin(new Insets(10, 20, 10, 20));

        // Add to other buttons panel
        otherButtonsPanel.add(goBackToMainMenuBtn);
   
        // Set layout and add components to the main panel
        evolveCreatureViewPanel.add(creaturesPanel, BorderLayout.CENTER);
        evolveCreatureViewPanel.add(otherButtonsPanel, BorderLayout.SOUTH);

        // Customize the panel 
        evolveCreatureViewPanel.setBackground(Color.WHITE);
    }

    public void showEvolveCreatureView() {
        creature1ImageBtn.setIcon(defaultImg);
        creature2ImageBtn.setIcon(defaultImg);
        cardLayout.show(cardPanel, "Evolve Creature View");
    }

    public void setCreature1ImageBtnActionListener(ActionListener actionListener) {
        this.creature1ImageBtn.addActionListener(actionListener);
    }

    public void setCreature2ImageBtnActionListener(ActionListener actionListener) {
        this.creature2ImageBtn.addActionListener(actionListener);
    }

    public void setEvolveButtonActionListener(ActionListener actionListener) {
        this.evolveButton.addActionListener(actionListener);
    }

    public void setGoBackToMainMenuButtonActionListener(ActionListener actionListener) {
        this.goBackToMainMenuBtn.addActionListener(actionListener);
    }

    public void setCreatureImage1(String creatureName, String evolutionLvl) {
        creature1Image = new ImageIcon("media/lvl" + evolutionLvl + "_creatures/" + creatureName + ".png");
        creature1ImageBtn.setIcon(creature1Image);
    }

    public void setCreatureImage2(String creatureName, String evolutionLvl) {
        creature2Image = new ImageIcon("media/lvl" + evolutionLvl + "_creatures/" + creatureName + ".png");
        creature2ImageBtn.setIcon(creature2Image);
    }
}
