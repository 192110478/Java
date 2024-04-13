import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
class Patient {
private static int nextTokenNumber = 1; // Static variable to generate unique token numbers
private int tokenNumber; // Token number for the patient
private String name;
private int age;
private String diagnosis;
public Patient(String name, int age, String diagnosis) {
this.tokenNumber = nextTokenNumber++; // Assigning unique token number
this.name = name;
this.age = age;
this.diagnosis = diagnosis;
}
public int getTokenNumber() {
return tokenNumber;
}
public String getName() {
return name;
}
public int getAge() {
return age;
}
public String getDiagnosis() {
return diagnosis;
}
}
public class HospitalManagementSystem extends JFrame implements ActionListener {
private ArrayList<Patient> patients;
private JTextField nameField, ageField, diagnosisField;
private JTextArea outputArea;
public HospitalManagementSystem() {
patients = new ArrayList<>();
setTitle("Hospital Management System");
setSize(600, 400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
JPanel inputPanel = new JPanel(new GridLayout(4, 2));
inputPanel.add(new JLabel("Name:"));
nameField = new JTextField();
inputPanel.add(nameField);
inputPanel.add(new JLabel("Age:"));
ageField = new JTextField();
inputPanel.add(ageField);
inputPanel.add(new JLabel("Diagnosis:"));
diagnosisField = new JTextField();
inputPanel.add(diagnosisField);
JButton addButton = new JButton("Add Patient");
addButton.addActionListener(this);
inputPanel.add(addButton);
JButton viewButton = new JButton("View Patients");
viewButton.addActionListener(this);
inputPanel.add(viewButton);
JButton searchButton = new JButton("Search Patient");
searchButton.addActionListener(this);
inputPanel.add(searchButton);
JButton statisticsButton = new JButton("Display Statistics");
statisticsButton.addActionListener(this);
inputPanel.add(statisticsButton);
add(inputPanel, BorderLayout.NORTH);
outputArea = new JTextArea();
JScrollPane scrollPane = new JScrollPane(outputArea);
add(scrollPane, BorderLayout.CENTER);
setVisible(true);
}
public void actionPerformed(ActionEvent e) {
String actionCommand = e.getActionCommand();
if (actionCommand.equals("Add Patient")) {
addPatient();
} else if (actionCommand.equals("View Patients")) {
viewPatients();
} else if (actionCommand.equals("Search Patient")) {
searchPatient();
} else if (actionCommand.equals("Display Statistics")) {
displayStatistics();
}
}
private void addPatient() {
String name = nameField.getText();
String ageStr = ageField.getText();
String diagnosis = diagnosisField.getText();
if (name.isEmpty() || ageStr.isEmpty() || diagnosis.isEmpty()) {
JOptionPane.showMessageDialog(this, "Please enter all details.", "Error",
JOptionPane.ERROR_MESSAGE);
return;
}
// Validate if the name contains only alphabetic characters
if (!name.matches("[a-zA-Z]+")) {
JOptionPane.showMessageDialog(this, "Please enter a valid name.", "Error",
JOptionPane.ERROR_MESSAGE);
return;
}
try {
int age = Integer.parseInt(ageStr);
Patient patient = new Patient(name, age, diagnosis);
patients.add(patient);
outputArea.append("Patient added: Token Number: " + patient.getTokenNumber() + ", Name: "
+ name + ", Age: " + age + ", Diagnosis: " + diagnosis + "\n");
} catch (NumberFormatException ex) {
JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Error",
JOptionPane.ERROR_MESSAGE);
}
}
private void viewPatients() {
outputArea.setText("List of Patients:\n");
for (Patient patient : patients) {
outputArea.append("Token Number: " + patient.getTokenNumber() + ", Name: " +
patient.getName() + ", Age: " + patient.getAge() + ", Diagnosis: " + patient.getDiagnosis() + "\n");
}
}
private void searchPatient() {
String searchName = JOptionPane.showInputDialog("Enter patient name to search:");
for (Patient patient : patients) {
if (patient.getName().equalsIgnoreCase(searchName)) {
outputArea.setText("Patient found:\n");
outputArea.append("Token Number: " + patient.getTokenNumber() + ", Name: " +
patient.getName() + ", Age: " + patient.getAge() + ", Diagnosis: " + patient.getDiagnosis() + "\n");
return;
}
}
outputArea.setText("Patient not found with the given name.");
}
private void displayStatistics() {
outputArea.setText("Hospital Statistics:\n");
outputArea.append("Total number of patients: " + patients.size() + "\n");
}
public static void main(String[] args) {
new HospitalManagementSystem();
}
}