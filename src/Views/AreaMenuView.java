package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AreaMenuView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel areaMenuViewPanel;

    private JButton areaTypeOneBtn;
    private JButton areaTypeTwoBtn;
    private JButton areaTypeThreeBtn;
    private JButton goBackToMainMenuBtn;
   
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
        areaTypeOneBtn = new JButton("Area 1");
        areaTypeTwoBtn = new JButton("Area 2");
        areaTypeThreeBtn= new JButton("Area 3");
        goBackToMainMenuBtn = new JButton("Go back");

        // Set preferred size for buttons
        Dimension buttonSize = new Dimension(50, 20); // Adjust dimensions as needed
        areaTypeOneBtn.setPreferredSize(buttonSize);
        areaTypeTwoBtn.setPreferredSize(buttonSize);
        areaTypeThreeBtn.setPreferredSize(buttonSize);
        goBackToMainMenuBtn.setPreferredSize(buttonSize);

        // Add buttons to the button panel
        buttonPanel.add(areaTypeOneBtn);
        buttonPanel.add(areaTypeTwoBtn);
        buttonPanel.add(areaTypeThreeBtn);
        buttonPanel.add(goBackToMainMenuBtn);

        // Add button panel to the main panel
        areaMenuViewPanel.add(buttonPanel, BorderLayout.CENTER);
    }

    public void showAreaMenu() {
        cardLayout.show(cardPanel, "Area Menu View");
    }

    public void setAreaMenuBtnsActionListener(ActionListener actionListener) {

        this.areaTypeOneBtn.addActionListener(actionListener);
        this.areaTypeOneBtn.setActionCommand("areaTypeOneBtn");

        this.areaTypeTwoBtn.addActionListener(actionListener);
        this.areaTypeTwoBtn.setActionCommand("areaTypeTwoBtn");

        this.areaTypeThreeBtn.addActionListener(actionListener);
        this.areaTypeThreeBtn.setActionCommand("areaTypeThreeBtn");

        this.goBackToMainMenuBtn.addActionListener(actionListener);
        this.goBackToMainMenuBtn.setActionCommand("goBackToMainMenuBtn");
    }
}
