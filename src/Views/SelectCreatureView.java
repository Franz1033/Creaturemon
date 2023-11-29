package Views;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectCreatureView implements ListOfCapturedCreatures {

    JFrame frame;
    JPanel panel;
    ArrayList<ArrayList<Object>> listOfCapturedCreatures;
    private ArrayList<JButton> creatureBtns;

    public SelectCreatureView(String title) {

        creatureBtns = new ArrayList<>();
        panel = new JPanel();
        frame = new JFrame(title);

    }

    public void initializeUI() {

        // Clear existing components
        panel.removeAll();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (ArrayList<Object> obj : listOfCapturedCreatures) {
            JButton creatureBtn = new JButton(new ImageIcon("media/lvl" + obj.get(3) + "_creatures/" + obj.get(0) + ".png"));
            creatureBtns.add(creatureBtn);
            panel.add(creatureBtn);
        }

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(panel);
    }

    @Override
    public void setListOfCapturedCreatures(ArrayList<ArrayList<Object>> listOfCapturedCreatures) {
        this.listOfCapturedCreatures = listOfCapturedCreatures;
    }

    public void setCreatureBtnsActionListener(ActionListener actionListener) {
        for (int i = 0; i < creatureBtns.size(); i++) {
            creatureBtns.get(i).addActionListener(actionListener);
            creatureBtns.get(i).setActionCommand(String.valueOf(i));
        }

        creatureBtns.clear();
    }

    public void closeFrame() {
        frame.dispose();
    }
    
}
