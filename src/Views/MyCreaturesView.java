package Views;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyCreaturesView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel myCreaturesViewPanel;

    ArrayList<ArrayList<Object>> listOfCapturedCreatures;
    
    public MyCreaturesView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.myCreaturesViewPanel = new JPanel(new BorderLayout());

        cardPanel.add(myCreaturesViewPanel, "My Creatures");
    }

    public void initializeUI() { 
        JLabel label = new JLabel("Inventory Menu " + listOfCapturedCreatures);
        myCreaturesViewPanel.add(label, BorderLayout.CENTER);
    }

    public void showMyCreatures() {
        cardLayout.show(cardPanel, "My Creatures");
    }

    public void setListOfCapturedCreatures(ArrayList<ArrayList<Object>> listOfCapturedCreatures) {
        this.listOfCapturedCreatures = listOfCapturedCreatures;
    }

}
