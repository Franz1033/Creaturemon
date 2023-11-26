package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StarterView {
    
    private ArrayList<JButton> starterBtns;
    private ArrayList<String> lvl1CreatureNames;

    public StarterView() {

        this.starterBtns = new ArrayList<>();
        this.lvl1CreatureNames = new ArrayList<>();

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

        JFrame frame = new JFrame("Creaturemon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        JLabel label = new JLabel("Choose Your Starter Creature");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            ImageIcon icon = new ImageIcon("media/lvl1_creatures/" + lvl1CreatureNames.get(i) + ".png");
            starterBtns.add(new JButton(icon));
            panel.add(starterBtns.get(i));
        }
        
        frame.add(panel);
        frame.setVisible(true);
    }

    public void setStarterCreatureBtnActionListener(ActionListener actionListener) {
        for (int i = 0; i < 9; i++) {
            this.starterBtns.get(i).addActionListener(actionListener);
            this.starterBtns.get(i).setActionCommand(lvl1CreatureNames.get(i) + "Btn");
        }
    }
}