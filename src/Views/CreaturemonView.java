package Views;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreaturemonView extends JFrame {

    private final StarterView starterView;
    private final MainMenuView mainMenuView;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CreaturemonView() {

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        this.starterView = new StarterView(cardPanel, cardLayout);
        this.mainMenuView = new MainMenuView(cardPanel, cardLayout); 
    
        add(cardPanel);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public StarterView getStarterView() {
        return starterView;
    }

    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }
}