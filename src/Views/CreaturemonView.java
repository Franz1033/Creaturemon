package Views;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CreaturemonView extends JFrame {

    private final StarterView starterView;
    private final MainMenuView mainMenuView;

    private final InventoryMenuView inventoryMenuView;
    private final AreaMenuView areaMenuView;
    private final EvolveCreatureView evolveCreatureView;

    private MyCreaturesView myCreaturesView;
    private ChangeActiveCreatureView changeActiveCreatureView;

    private AreaTypeOneView areaTypeOneView;
    private AreaTypeTwoView areaTypeTwoView;
    private AreaTypeThreeView areaTypeThreeView;
    private BattlePhaseView battlePhaseView;

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public CreaturemonView() {

        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);

        add(cardPanel);
        
        setTitle("Creaturemon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        this.starterView = new StarterView(cardPanel, cardLayout);
        this.mainMenuView = new MainMenuView(cardPanel, cardLayout);

        this.inventoryMenuView = new InventoryMenuView(cardPanel, cardLayout);
        this.areaMenuView = new AreaMenuView(cardPanel, cardLayout);
        this.evolveCreatureView = new EvolveCreatureView(cardPanel, cardLayout);

        this.myCreaturesView = new MyCreaturesView(cardPanel, cardLayout);
        this.changeActiveCreatureView = new ChangeActiveCreatureView(cardPanel, cardLayout);

        this.areaTypeOneView = new AreaTypeOneView(cardPanel, cardLayout);
        this.areaTypeTwoView = new AreaTypeTwoView(cardPanel, cardLayout);
        this.areaTypeThreeView = new AreaTypeThreeView(cardPanel, cardLayout);
        this.battlePhaseView = new BattlePhaseView(cardPanel, cardLayout);
    }

    public StarterView getStarterView() {
        return this.starterView;
    }

    public MainMenuView getMainMenuView() {
        return this.mainMenuView;
    }

    public InventoryMenuView getInventoryMenuView() {
        return this.inventoryMenuView;
    }

    public AreaMenuView getAreaMenuView() {
        return this.areaMenuView;
    }

    public EvolveCreatureView getEvolveCratureView() {
        return this.evolveCreatureView;
    }

    public MyCreaturesView getMyCreaturesView() {
        return this.myCreaturesView;
    }

    public ChangeActiveCreatureView getChangeActiveCreatureView() {
        return this.changeActiveCreatureView;
    }

    public AreaTypeOneView getAreaTypeOneView() {
        return this.areaTypeOneView;
    }

    public AreaTypeTwoView getAreaTypeTwoView() {
        return this.areaTypeTwoView;
    }

    public AreaTypeThreeView getAreaTypeThreeView() {
        return this.areaTypeThreeView;
    }

    public BattlePhaseView getBattlePhaseView() {
        return this.battlePhaseView;
    }

}