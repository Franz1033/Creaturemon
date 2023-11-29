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

        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
        
        JLabel titleLabel = new JLabel("Area Menu");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        
        titleLabelPanel.add(titleLabel);
        areaMenuViewPanel.add(titleLabelPanel, BorderLayout.NORTH); 

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 5)); 

        areaTypeOneBtn = new JButton("Area 1");
        areaTypeTwoBtn = new JButton("Area 2");
        areaTypeThreeBtn= new JButton("Area 3");
        goBackToMainMenuBtn = new JButton("Go back");

        Dimension buttonSize = new Dimension(50, 20); 
        areaTypeOneBtn.setPreferredSize(buttonSize);
        areaTypeTwoBtn.setPreferredSize(buttonSize);
        areaTypeThreeBtn.setPreferredSize(buttonSize);
        goBackToMainMenuBtn.setPreferredSize(buttonSize);

        buttonPanel.add(areaTypeOneBtn);
        buttonPanel.add(areaTypeTwoBtn);
        buttonPanel.add(areaTypeThreeBtn);
        buttonPanel.add(goBackToMainMenuBtn);

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
