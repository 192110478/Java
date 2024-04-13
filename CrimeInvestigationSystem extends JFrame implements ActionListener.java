import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CrimeInvestigationSystem  {
    private JTextField suspectNameField, crimeDescriptionField;
    private JButton submitButton;

    public CrimeInvestigationSystem() {
        setTitle("Crime Investigation System");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel suspectNameLabel = new JLabel("Suspect Name:");
        suspectNameField = new JTextField();
        JLabel crimeDescriptionLabel = new JLabel("Crime Description:");
        crimeDescriptionField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        panel.add(suspectNameLabel);
        panel.add(suspectNameField);
        panel.add(crimeDescriptionLabel);
        panel.add(crimeDescriptionField);
        panel.add(new JLabel());
        panel.add(submitButton);

        add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String suspectName = suspectNameField.getText();
            String crimeDescription = crimeDescriptionField.getText();

            // Here you can add the code to handle the submission
            // For example, you can save the data to a database or perform some validation
            // This is just a placeholder for demonstration purposes
            JOptionPane.showMessageDialog(this, "Suspect Name: " + suspectName + "\nCrime Description: " + crimeDescription);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CrimeInvestigationSystem().setVisible(true);
        });
    }
}
