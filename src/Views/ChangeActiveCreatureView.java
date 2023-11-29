package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeActiveCreatureView implements ListOfCapturedCreatures, GoBackToInventoryMenuBtn {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel changeActiveCreatureViewPanel;

    private String activeCreature;

    private JLabel activeCreatureLabel;
    private ArrayList<ArrayList<Object>> listOfCapturedCreatures;
    private ArrayList<JButton> selectBtns;

    private JButton goBackToInventoryMenuBtn;
    
    public ChangeActiveCreatureView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.changeActiveCreatureViewPanel = new JPanel();
        this.changeActiveCreatureViewPanel.setLayout(new BoxLayout(changeActiveCreatureViewPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(changeActiveCreatureViewPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        cardPanel.add(scrollPane, "Change Active Creature Panel");
    }

    public void initializeUI() {

        // Clear existing components
        changeActiveCreatureViewPanel.removeAll();

        // Reinitialize the select btns
        this.selectBtns = new ArrayList<>();

        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.BLUE);
        JLabel titleLabel = new JLabel("Change Active Creature");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); 
        titleLabel.setForeground(Color.WHITE);
        titleLabelPanel.add(titleLabel);

        // Wrap titleLabelPanel in another panel with BoxLayout
        JPanel wrappedPanel = new JPanel();
        wrappedPanel.setLayout(new BoxLayout(wrappedPanel, BoxLayout.Y_AXIS));
        wrappedPanel.add(titleLabelPanel);

        // Set maximum size to create a fixed height
        wrappedPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        changeActiveCreatureViewPanel.add(wrappedPanel);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(25, 135, 15, 135)); 

        activeCreatureLabel = new JLabel("Current active creature: " + activeCreature);
        activeCreatureLabel.setFont(new Font("SansSerif", Font.BOLD, 14));   
        headerPanel.add(activeCreatureLabel);
        
        goBackToInventoryMenuBtn = new JButton("Go back to inventory menu");
        goBackToInventoryMenuBtn.setOpaque(true);
        goBackToInventoryMenuBtn.setBorderPainted(false);
        goBackToInventoryMenuBtn.setBackground(Color.RED);
        goBackToInventoryMenuBtn.setForeground(Color.WHITE);
        goBackToInventoryMenuBtn.setMargin(new Insets(10, 5, 10, 5));
        goBackToInventoryMenuBtn.setPreferredSize(new Dimension(250, 30));
        headerPanel.add(goBackToInventoryMenuBtn);
        
        changeActiveCreatureViewPanel.add(headerPanel);
        
        for (ArrayList<Object> obj : listOfCapturedCreatures) {
            JPanel outerPanel = new JPanel();
            outerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 15)); 

            JPanel creaturePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 75, 25)); 
            creaturePanel.setBackground(Color.LIGHT_GRAY);

            // Add placeholder image to the left panel
            ImageIcon imageIcon = new ImageIcon("media/lvl" + obj.get(3) + "_creatures/" + obj.get(0) + ".png");
            JLabel imageLabel = new JLabel(imageIcon);
            creaturePanel.add(imageLabel);

            // Create a panel for labels with padding
            JPanel labelsPanel = new JPanel();
            labelsPanel.setBackground(Color.WHITE);
            labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment

            // Add padding to the labelsPanel
            int padding = 25;
            labelsPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

            JButton selectBtn = new JButton("Select");
            selectBtns.add(selectBtn);

            selectBtn.setOpaque(true);
            selectBtn.setBorderPainted(false);
            selectBtn.setBackground(Color.ORANGE);
            selectBtn.setForeground(Color.WHITE);

            labelsPanel.add(new JLabel("Name: " + obj.get(0)));
            labelsPanel.add(new JLabel("Type: " + obj.get(1)));
            labelsPanel.add(new JLabel("Family: " + obj.get(2)));
            labelsPanel.add(new JLabel("Level: " + obj.get(3)));
            labelsPanel.add(selectBtn);

            creaturePanel.add(labelsPanel); // Add labelsPanel to the creaturePanel

            outerPanel.add(creaturePanel);
            changeActiveCreatureViewPanel.add(outerPanel);
        }
    }

    public void showChangeActiveCreatureView() {
        cardLayout.show(cardPanel, "Change Active Creature Panel");
    }

    public void setActiveCreature(String activeCreature) {
        this.activeCreature = activeCreature;
    }

    @Override
    public void setListOfCapturedCreatures(ArrayList<ArrayList<Object>> listOfCapturedCreatures) {
        this.listOfCapturedCreatures = listOfCapturedCreatures;
    }

    @Override
    public void setGoBackToInventoryMenuBtnActionListener(ActionListener actionListener) {
        this.goBackToInventoryMenuBtn.addActionListener(actionListener);
    }

    public void setSelectBtnActionListener(ActionListener actionListener, int index) {
        this.selectBtns.get(index).addActionListener(actionListener);
    }

    public void updateActiveCreatureLabel() {
        activeCreatureLabel.setText("Current active creature: " + activeCreature);
    }

}
