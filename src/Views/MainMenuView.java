package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView {

    private final InventoryMenuView inventoryMenuView;
    private final AreaMenuView areaMenuView;

    private JButton viewInventoryBtn;
    private JButton exploreAreaBtn;
    private JButton evolveCreatureBtn;
    private JButton exitBtn;

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel mainMenuViewPanel;

    public MainMenuView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        mainMenuViewPanel = new JPanel(new BorderLayout());

        this.inventoryMenuView = new InventoryMenuView(cardPanel, cardLayout); 
        this.areaMenuView = new AreaMenuView(cardPanel, cardLayout); 

        initializeUI();

        cardPanel.add(mainMenuViewPanel, "Main Menu View");
    }

    public void initializeUI() {

        JLabel label = new JLabel("Main Menu");
        label.setHorizontalAlignment(JLabel.CENTER);
        mainMenuViewPanel.add(label, BorderLayout.NORTH);

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

    public InventoryMenuView getInventoryMenuView() {
        return this.inventoryMenuView;
    }

    public AreaMenuView getAreaMenuView() {
        return this.areaMenuView;
    }

}