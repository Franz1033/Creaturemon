package Views;
import javax.swing.*;
import java.awt.*;

public class AreaMenuView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel areaMenuViewPanel;
   
    public AreaMenuView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.areaMenuViewPanel = new JPanel(new BorderLayout());

        initializeUI();

        cardPanel.add(areaMenuViewPanel, "Area Menu View");
    }

    public void initializeUI() {

        // Label at the top
        JLabel label = new JLabel("Select Area Menu");
        label.setHorizontalAlignment(JLabel.CENTER);
        areaMenuViewPanel.add(label, BorderLayout.NORTH);

        // Panel for buttons stacked vertically
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 5)); // 4 rows, 1 column, vertical gap of 5 pixels

        // Buttons with appropriate size and names
        JButton button1 = new JButton("Area 1");
        JButton button2 = new JButton("Area 2");
        JButton button3 = new JButton("Area 3");
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
        areaMenuViewPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    public void showAreaMenu() {
        cardLayout.show(cardPanel, "Area Menu View");
    }
}
