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

    private ArrayList<ArrayList<Object>> listOfCapturedCreatures;
    private ArrayList<JButton> selectBtns;

    private JButton goBackToInventoryMenuBtn;
    
    public ChangeActiveCreatureView(JPanel cardPanel, CardLayout cardLayout) {

        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.changeActiveCreatureViewPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50)); // Adjust the vertical gap
        this.selectBtns = new ArrayList<>();

        cardPanel.add(changeActiveCreatureViewPanel, "Change Active Creature Panel");
    }

       public void initializeUI() {

        // Clear existing components
        changeActiveCreatureViewPanel.removeAll();

        // Create a panel for the title label
        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.LIGHT_GRAY);

        // Add a general label with a decent-sized font and centered
        JLabel titleLabel = new JLabel("Change Active Creature");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); // Adjust font size and style
        titleLabelPanel.add(titleLabel);
        changeActiveCreatureViewPanel.add(titleLabelPanel); 

        goBackToInventoryMenuBtn = new JButton("Go back to inventory menu");
        changeActiveCreatureViewPanel.add(goBackToInventoryMenuBtn);

        JLabel activeCreatureLabel = new JLabel("Current active creature: " + activeCreature);
        changeActiveCreatureViewPanel.add(activeCreatureLabel);

        for (ArrayList<Object> obj : listOfCapturedCreatures) {
            JPanel creaturePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 5)); // Center the components
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
            int padding = 10;
            labelsPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));

            JButton selectBtn = new JButton("Select");
            selectBtns.add(selectBtn);

            labelsPanel.add(new JLabel("Name: " + obj.get(0)));
            labelsPanel.add(new JLabel("Type: " + obj.get(1)));
            labelsPanel.add(new JLabel("Family: " + obj.get(2)));
            labelsPanel.add(new JLabel("Level: " + obj.get(3)));
            labelsPanel.add(selectBtn);

            creaturePanel.add(labelsPanel); // Add labelsPanel to the creaturePanel

            // Add creaturePanel to the main panel
            changeActiveCreatureViewPanel.add(creaturePanel);
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

}
