package Views;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class DisplayInventoryView {
    
    public DisplayInventoryView() {
        JFrame frame = new JFrame("Display Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel(new GridLayout(0, 5, 5, 5)); // 5 columns, gap of 5 pixels

        // Labels for column headers
        JLabel imgLabel = createBoldLabel("Img");
        JLabel noLabel = createBoldLabel("No.");
        JLabel typeLabel = createBoldLabel("Type");
        JLabel familyLabel = createBoldLabel("Family");
        JLabel lvlLabel = createBoldLabel("Lvl");

        // Sample data (you can replace this with your actual data)
        String[] data = {
                "img1.png", "001", "Grass", "Bulbasaur", "15",
                "img2.png", "004", "Fire", "Charmander", "14",
                "img3.png", "007", "Water", "Squirtle", "13"
                // Add more rows as needed
        };

        // Add column headers to the panel
        panel.add(imgLabel);
        panel.add(noLabel);
        panel.add(typeLabel);
        panel.add(familyLabel);
        panel.add(lvlLabel);

        for (String value : data) {
            JLabel label = createLabel(value);
            panel.add(label);
        }

        // Create a "Go Back" button
        JButton goBackButton = new JButton("Go Back");
        goBackButton.addActionListener(e -> {
            // Add your code to handle "Go Back" button click
            JOptionPane.showMessageDialog(frame, "Go back button clicked!");
        });

        // Add the "Go Back" button to the panel
        panel.add(goBackButton);

        // Add a border to create grid lines
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(border);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setHorizontalAlignment(JLabel.CENTER); // Center the text
        return label;
    }

    private JLabel createBoldLabel(String text) {
        JLabel label = createLabel(text);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        return label;
    }
}
