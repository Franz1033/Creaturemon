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

        // Label at the top
        JLabel label = new JLabel("Inventory Menu");
        label.setHorizontalAlignment(JLabel.CENTER);
        inventoryMenuViewPanel.add(label, BorderLayout.NORTH);

        // Panel for buttons stacked vertically
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 5)); // 4 rows, 1 column, vertical gap of 5 pixels

        // Buttons with appropriate size and names
        displayMyCreaturesBtn = new JButton("Display All My Creatues");
        changeActiveCreatureBtn = new JButton("Change Active Creature");
        goBackToMainMenuBtn = new JButton("Go back");

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(50, 20); // Adjust dimensions as needed
        displayMyCreaturesBtn.setPreferredSize(buttonSize);
        changeActiveCreatureBtn.setPreferredSize(buttonSize);
        goBackToMainMenuBtn.setPreferredSize(buttonSize);

        // Add buttons to the button panel
        buttonPanel.add(displayMyCreaturesBtn);
        buttonPanel.add(changeActiveCreatureBtn);
        buttonPanel.add(goBackToMainMenuBtn);

        // Add button panel to the main panel
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
