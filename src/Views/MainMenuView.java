package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JPanel {

    private JButton viewInventoryBtn;
    private JButton exploreAreaBtn;
    private JButton evolveCreatureBtn;
    private JButton exitBtn;

    private JPanel mainMenuViewPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainMenuView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        mainMenuViewPanel = new JPanel(new BorderLayout());

        initializeUI();

        cardPanel.add(mainMenuViewPanel, "Main Menu View");
    }

    public void initializeUI() {

        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
        
        JLabel titleLabel = new JLabel("Main Menu");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        
        titleLabelPanel.add(titleLabel);
        mainMenuViewPanel.add(titleLabelPanel, BorderLayout.NORTH); 

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10));

        viewInventoryBtn = new JButton("View Inventory");
        exploreAreaBtn = new JButton("Explore an Area");
        evolveCreatureBtn = new JButton("Evolve Creatures");
        exitBtn = new JButton("Exit");

        buttonPanel.add(viewInventoryBtn);
        buttonPanel.add(exploreAreaBtn);
        buttonPanel.add(evolveCreatureBtn);
        buttonPanel.add(exitBtn);

        mainMenuViewPanel.add(buttonPanel, BorderLayout.CENTER);

    }

    public void showMainMenu() {
        cardLayout.show(cardPanel, "Main Menu View");
    }

    public void setMainMenuBtnsActionListener(ActionListener actionListener) {

        this.viewInventoryBtn.addActionListener(actionListener);
        this.viewInventoryBtn.setActionCommand("viewInventoryBtn");

        this.exploreAreaBtn.addActionListener(actionListener);
        this.exploreAreaBtn.setActionCommand("exploreAreaBtn");

        this.evolveCreatureBtn.addActionListener(actionListener);
        this.evolveCreatureBtn.setActionCommand("evolveCreatureBtn");

        this.exitBtn.addActionListener(actionListener);
        this.exitBtn.setActionCommand("exitBtn");
    }

}