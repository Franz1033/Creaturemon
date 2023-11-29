package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyCreaturesView implements ListOfCapturedCreatures, GoBackToInventoryMenuBtn  {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel myCreaturesViewPanel;

    ArrayList<ArrayList<Object>> listOfCapturedCreatures;

    private JButton goBackToInventoryMenuBtn;

    public MyCreaturesView(JPanel cardPanel, CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.myCreaturesViewPanel = new JPanel();
        this.myCreaturesViewPanel.setLayout(new BoxLayout(myCreaturesViewPanel, BoxLayout.Y_AXIS));
    
        JScrollPane scrollPane = new JScrollPane(myCreaturesViewPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
        cardPanel.add(scrollPane, "My Creatures"); 
    }    

    public void initializeUI() {

        // Clear existing components
        myCreaturesViewPanel.removeAll();

        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
        JLabel titleLabel = new JLabel("My Captured Creatures");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        titleLabelPanel.add(titleLabel);

        // Wrap titleLabelPanel in another panel with BoxLayout
        JPanel wrappedPanel = new JPanel();
        wrappedPanel.setLayout(new BoxLayout(wrappedPanel, BoxLayout.Y_AXIS));
        wrappedPanel.add(titleLabelPanel);

        // Set maximum size to create a fixed height
        wrappedPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        myCreaturesViewPanel.add(wrappedPanel);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(25, 135, 15, 135)); 

        goBackToInventoryMenuBtn = new JButton("Go back to inventory menu");
        goBackToInventoryMenuBtn.setOpaque(true);
        goBackToInventoryMenuBtn.setBorderPainted(false);
        goBackToInventoryMenuBtn.setBackground(Color.RED);
        goBackToInventoryMenuBtn.setForeground(Color.WHITE);
        goBackToInventoryMenuBtn.setMargin(new Insets(10, 5, 10, 5));
        goBackToInventoryMenuBtn.setPreferredSize(new Dimension(250, 30));
        headerPanel.add(goBackToInventoryMenuBtn);
        
        myCreaturesViewPanel.add(headerPanel);

        for (ArrayList<Object> obj : listOfCapturedCreatures) {
            JPanel outerPanel = new JPanel();
            outerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15)); 

            JPanel creaturePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 75, 25));
            creaturePanel.setBackground(Color.LIGHT_GRAY);

            ImageIcon imageIcon = new ImageIcon("media/lvl" + obj.get(3) + "_creatures/" + obj.get(0) + ".png");
            JLabel imageLabel = new JLabel(imageIcon);
            creaturePanel.add(imageLabel);
    
            JPanel labelsPanel = new JPanel();
            labelsPanel.setBackground(Color.WHITE);
            labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS));
        
            int padding = 25;
            labelsPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        
            labelsPanel.add(new JLabel("Name: " + obj.get(0)));
            labelsPanel.add(new JLabel("Type: " + obj.get(1)));
            labelsPanel.add(new JLabel("Family: " + obj.get(2)));
            labelsPanel.add(new JLabel("Level: " + obj.get(3)));
        
            creaturePanel.add(labelsPanel);
            outerPanel.add(creaturePanel);
            myCreaturesViewPanel.add(outerPanel);
        
        }
        
    }

    public void showMyCreatures() {
        cardLayout.show(cardPanel, "My Creatures");
    }

    @Override
    public void setListOfCapturedCreatures(ArrayList<ArrayList<Object>> listOfCapturedCreatures) {
        this.listOfCapturedCreatures = listOfCapturedCreatures;
    }

    @Override
    public void setGoBackToInventoryMenuBtnActionListener(ActionListener actionListener) {
        this.goBackToInventoryMenuBtn.addActionListener(actionListener);
    }
}
