package Views;
import javax.swing.*;
import java.awt.*;

public class ChangeActiveCreatureView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel changeActiveCreatureViewPanel;

    private String activeCreature;
    
    public ChangeActiveCreatureView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.changeActiveCreatureViewPanel = new JPanel(new BorderLayout());

        cardPanel.add(changeActiveCreatureViewPanel, "Change Active Creature Panel");
    }

    public void initializeUI() { 
        JLabel label = new JLabel("Active creature: " + activeCreature);
        changeActiveCreatureViewPanel.add(label, BorderLayout.CENTER);
    }

    public void showChangeActiveCreatureView() {
        cardLayout.show(cardPanel, "Change Active Creature Panel");
    }

    public void setActiveCreature(String activeCreature) {
        this.activeCreature = activeCreature;
    }
}
