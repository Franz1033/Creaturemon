package Views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AreaTypeTwoView {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel areaTypeTwoViewPanel;
    
    public AreaTypeTwoView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.areaTypeTwoViewPanel = new JPanel(new GridLayout(3,3)); 

        initializeUI();

        cardPanel.add(areaTypeTwoViewPanel, "Area Type Two View Panel");
    }

    public void initializeUI() {
        for (int i = 0; i < 9; i++) {
            JPanel box = new JPanel();
            box.setBackground(Color.YELLOW);
            box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            areaTypeTwoViewPanel.add(box);
        }
    }

    public void showAreaTypeTwoView() {
        cardLayout.show(cardPanel, "Area Type Two View Panel");
    }
}
