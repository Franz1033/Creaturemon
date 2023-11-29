package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class StarterView {
    
    private ArrayList<JButton> starterBtns;
    private ArrayList<String> lvl1CreatureNames;

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel starterViewPanel;

    public StarterView(JPanel cardPanel, CardLayout cardLayout) {

        this.starterBtns = new ArrayList<>();
        this.lvl1CreatureNames = new ArrayList<>();

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        starterViewPanel = new JPanel(new BorderLayout());

        // Initilize array with the list of all lvl1 creature names
        this.lvl1CreatureNames.add("Strawander");
        this.lvl1CreatureNames.add("Chocowool");
        this.lvl1CreatureNames.add("Parfwit");
        this.lvl1CreatureNames.add("Brownisaur");
        this.lvl1CreatureNames.add("Frubat");
        this.lvl1CreatureNames.add("Malts");
        this.lvl1CreatureNames.add("Squirpie");
        this.lvl1CreatureNames.add("Chocolite");
        this.lvl1CreatureNames.add("Oshacone");
        
        initializeUI();

        cardPanel.add(starterViewPanel, "Starter View");
    }

    public void initializeUI() {
        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
    
        JLabel titleLabel = new JLabel("Select Starter Creature");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
    
        titleLabelPanel.add(titleLabel);
        starterViewPanel.add(titleLabelPanel, BorderLayout.NORTH);
    
        JPanel creatureSelectPanel = new JPanel(new GridLayout(3, 3));
    
        for (int i = 0; i < 9; i++) {
            JPanel creaturePanel = new JPanel(new BorderLayout());
            ImageIcon icon = new ImageIcon("media/lvl1_creatures/" + lvl1CreatureNames.get(i) + ".png");
            JButton button = new JButton(icon);
            button.setOpaque(true);
    
            JLabel label = new JLabel(lvl1CreatureNames.get(i), JLabel.CENTER);
            label.setForeground(Color.BLACK);
    
            creaturePanel.add(button, BorderLayout.CENTER);
            creaturePanel.add(label, BorderLayout.SOUTH);
    
            creatureSelectPanel.add(creaturePanel);
    
            starterBtns.add(button);
        }
    
        starterViewPanel.add(creatureSelectPanel);
    }    

    public void setStarterCreatureBtnActionListener(ActionListener actionListener) {
        for (int i = 0; i < 9; i++) {
            this.starterBtns.get(i).addActionListener(actionListener);
            this.starterBtns.get(i).setActionCommand(lvl1CreatureNames.get(i) + "Btn");
        }
    }

    public void setStarterCreatureBtnMouseListener(MouseAdapter mouseAdapter) {
        for (int i = 0; i < 9; i++) {
            this.starterBtns.get(i).addMouseListener(mouseAdapter);
        }
    }

    public void changeBtnBackgroundColor(String actionCommand, Color color) {
        for (int i = 0; i < starterBtns.size(); i++) {
            if (starterBtns.get(i).getActionCommand().equals(actionCommand)) {
                starterBtns.get(i).setBackground(color);
                starterBtns.get(i).setBorder(null);
                break;
            }
        }
    }
    
    public void showStarterView() {
        cardLayout.show(cardPanel, "StarterView");
    }
}