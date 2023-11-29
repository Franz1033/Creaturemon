package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InventoryMenuView {
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel inventoryMenuViewPanel;

    private JButton displayMyCreaturesBtn;
    private JButton changeActiveCreatureBtn;
    private JButton goBackToMainMenuBtn;

    public InventoryMenuView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.inventoryMenuViewPanel = new JPanel(new BorderLayout());

        initializeUI();

        cardPanel.add(inventoryMenuViewPanel, "Inventory Menu View");
    }

    public void initializeUI() {

        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
        
        JLabel titleLabel = new JLabel("Inventory Menu");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        
        titleLabelPanel.add(titleLabel);
        inventoryMenuViewPanel.add(titleLabelPanel, BorderLayout.NORTH); 

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 5));

        displayMyCreaturesBtn = new JButton("Display All My Creatues");
        changeActiveCreatureBtn = new JButton("Change Active Creature");
        goBackToMainMenuBtn = new JButton("Go back");

        Dimension buttonSize = new Dimension(50, 20); 
        displayMyCreaturesBtn.setPreferredSize(buttonSize);
        changeActiveCreatureBtn.setPreferredSize(buttonSize);
        goBackToMainMenuBtn.setPreferredSize(buttonSize);

        buttonPanel.add(displayMyCreaturesBtn);
        buttonPanel.add(changeActiveCreatureBtn);
        buttonPanel.add(goBackToMainMenuBtn);

        inventoryMenuViewPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    public void showInventoryMenu() {
        cardLayout.show(cardPanel, "Inventory Menu View");
    }

    public void setInventoryMenuBtnsActionListener(ActionListener actionListener) {

        this.displayMyCreaturesBtn.addActionListener(actionListener);
        this.displayMyCreaturesBtn.setActionCommand("displayMyCreaturesBtn");

        this.changeActiveCreatureBtn.addActionListener(actionListener);
        this.changeActiveCreatureBtn.setActionCommand("changeActiveCreatureBtn");

        this.goBackToMainMenuBtn.addActionListener(actionListener);
        this.goBackToMainMenuBtn.setActionCommand("goBackToMainMenuBtn");
    }

}
