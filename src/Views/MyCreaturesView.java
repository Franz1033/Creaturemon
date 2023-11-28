package Views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyCreaturesView implements ListOfCapturedCreatures {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JPanel myCreaturesViewPanel;

    ArrayList<ArrayList<Object>> listOfCapturedCreatures;

    private JButton goBackToInventoryMenuBtn;

    public MyCreaturesView(JPanel cardPanel, CardLayout cardLayout) {
        this.cardPanel = cardPanel;
        this.cardLayout = cardLayout;
        this.myCreaturesViewPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50)); // Adjust the vertical gap

        cardPanel.add(myCreaturesViewPanel, "My Creatures");
    }

    public void initializeUI() {

        // Clear existing components
        myCreaturesViewPanel.removeAll();

        // Create a panel for the title label
        JPanel titleLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titleLabelPanel.setBackground(Color.LIGHT_GRAY);

        // Add a general label with a decent-sized font and centered
        JLabel titleLabel = new JLabel("My Captured Creatures");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24)); // Adjust font size and style
        titleLabelPanel.add(titleLabel);

        myCreaturesViewPanel.add(titleLabelPanel); 

        goBackToInventoryMenuBtn = new JButton("Go back to inventory menu");

        myCreaturesViewPanel.add(goBackToInventoryMenuBtn);

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

            labelsPanel.add(new JLabel("Name: " + obj.get(0)));
            labelsPanel.add(new JLabel("Type: " + obj.get(1)));
            labelsPanel.add(new JLabel("Family: " + obj.get(2)));
            labelsPanel.add(new JLabel("Level: " + obj.get(3)));

            creaturePanel.add(labelsPanel); // Add labelsPanel to the creaturePanel

            // Add creaturePanel to the main panel
            myCreaturesViewPanel.add(creaturePanel);
        }
    }

    public void showMyCreatures() {
        cardLayout.show(cardPanel, "My Creatures");
    }

    @Override
    public void setListOfCapturedCreatures(ArrayList<ArrayList<Object>> listOfCapturedCreatures) {
        this.listOfCapturedCreatures = listOfCapturedCreatures;
    }

    public void setMyCreaturesBtnsActionListener(ActionListener actionListener) {

        this.goBackToInventoryMenuBtn.addActionListener(actionListener);
        this.goBackToInventoryMenuBtn.setActionCommand("goBackToInventoryMenuBtn");
    }
}
