package Views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AreaTypeThreeView {
    
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel areaTypeThreeViewPanel;

    public AreaTypeThreeView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.areaTypeThreeViewPanel = new JPanel(new GridLayout(4,4)); 
        
        initializeUI();

        cardPanel.add(areaTypeThreeViewPanel, "Area Type Three View Panel");
    }

    public void initializeUI() {
        for (int i = 0; i < 16; i++) {
            JPanel box = new JPanel();
            box.setBackground(Color.PINK);
            box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            areaTypeThreeViewPanel.add(box);
        }
    }

    public void showAreaTypeThreeView() {
        cardLayout.show(cardPanel, "Area Type Three View Panel");
    }
}
