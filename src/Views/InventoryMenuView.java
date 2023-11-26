package Views;
import javax.swing.*;
import java.awt.*;

public class InventoryMenuView {
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel inventoryMenuViewPanel;

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
        JButton button1 = new JButton("Display Inventory");
        JButton button2 = new JButton("Change Active Creature");
        JButton button3 = new JButton("");
        JButton button4 = new JButton("Go back");

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(50, 20); // Adjust dimensions as needed
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);
        button4.setPreferredSize(buttonSize);

        // Add buttons to the button panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        // Add button panel to the main panel
        inventoryMenuViewPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    public void showInventoryMenu() {
        cardLayout.show(cardPanel, "Inventory Menu View");
    }
}
