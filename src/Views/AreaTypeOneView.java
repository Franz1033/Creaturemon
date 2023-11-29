package Views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AreaTypeOneView {

    private int curPos;
    private ArrayList<JPanel> cells;
    private ImageIcon icon;

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel areaTypeOneViewPanel;
    
    public AreaTypeOneView(JPanel cardPanel, CardLayout cardLayout) {

        this.curPos = 0;
        this.cells = new ArrayList<>();
        this.icon = new ImageIcon();
        
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.areaTypeOneViewPanel = new JPanel(new GridLayout(1, 5)); 

        initializeUI();

        cardPanel.add(areaTypeOneViewPanel, "Area Type One View Panel");
    }

    public void initializeUI() {
        for (int i = 0; i < 5; i++) {
            JPanel cell = new JPanel();
            cell.setBackground(Color.CYAN);
            cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            cells.add(cell);
            areaTypeOneViewPanel.add(cell);
        }
    }

    public void showAreaTypeOneView() {
        cardLayout.show(cardPanel, "Area Type One View Panel");
    }

    public void setImageIcon(String creatureName, String evolutionLvl) {
        icon = new ImageIcon("media/lvl" + evolutionLvl + "_creatures/" + creatureName + ".png");
    }

    public void setCurPos(int curPos) {
        this.curPos = curPos;
    }

    public int getCurPos() {
        return this.curPos;
    }

    public void markCell() {

        // Clear all cells
        clearAllCells();
    
        // Add the new image to the cell
        JLabel label = new JLabel(icon);
        cells.get(curPos).add(label);
    
        // Update the UI
        areaTypeOneViewPanel.revalidate();
        areaTypeOneViewPanel.repaint();
    }     

    private void clearAllCells() {
        for (JPanel cell : cells) {
            cell.removeAll();
            cell.revalidate();
            cell.repaint();
        }
    }

    public void setAreaTypeOneViewKeyListener(KeyListener e) {
        areaTypeOneViewPanel.setFocusable(true);
        areaTypeOneViewPanel.addKeyListener(e);
    }

    public void requestFocusOnArea() {
        areaTypeOneViewPanel.requestFocusInWindow();
    }

}
