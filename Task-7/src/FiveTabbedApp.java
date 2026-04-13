import javax.swing.*;
import java.awt.*;

public class FiveTabbedApp {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Smart Student Manager");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        // ================= TAB 1: DASHBOARD =================
        JPanel dashboard = new JPanel(new BorderLayout());

        JLabel welcome = new JLabel("Welcome to Smart Student Manager", JLabel.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 18));

        JTextArea info = new JTextArea("Use the tabs to navigate through features.\nManage students, calculate grades, and track tasks.");
        info.setEditable(false);

        dashboard.add(welcome, BorderLayout.NORTH);
        dashboard.add(info, BorderLayout.CENTER);

        tabs.addTab("Dashboard", dashboard);

        // ================= TAB 2: STUDENT FORM =================
        JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField courseField = new JTextField();
        JLabel status = new JLabel("");

        JButton submitBtn = new JButton("Save Student");

        submitBtn.addActionListener(e -> {
            if (nameField.getText().isEmpty() || idField.getText().isEmpty()) {
                status.setText("Please fill all required fields!");
            } else {
                status.setText("Student Saved Successfully!");
            }
        });

        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("Student ID:"));
        form.add(idField);
        form.add(new JLabel("Course:"));
        form.add(courseField);
        form.add(status);
        form.add(submitBtn);

        tabs.addTab("Student Form", form);

        // ================= TAB 3: GRADE CALCULATOR =================
        JPanel gradePanel = new JPanel();

        JTextField marks1 = new JTextField(5);
        JTextField marks2 = new JTextField(5);
        JTextField marks3 = new JTextField(5);

        JButton calcBtn = new JButton("Calculate Average");
        JLabel result = new JLabel("Average: ");

        calcBtn.addActionListener(e -> {
            try {
                double m1 = Double.parseDouble(marks1.getText());
                double m2 = Double.parseDouble(marks2.getText());
                double m3 = Double.parseDouble(marks3.getText());

                double avg = (m1 + m2 + m3) / 3;
                result.setText("Average: " + avg);
            } catch (Exception ex) {
                result.setText("Invalid input!");
            }
        });

        gradePanel.add(new JLabel("Marks 1:"));
        gradePanel.add(marks1);
        gradePanel.add(new JLabel("Marks 2:"));
        gradePanel.add(marks2);
        gradePanel.add(new JLabel("Marks 3:"));
        gradePanel.add(marks3);
        gradePanel.add(calcBtn);
        gradePanel.add(result);

        tabs.addTab("Grade Calc", gradePanel);

        // ================= FINAL =================
        frame.add(tabs);
        frame.setVisible(true);
    }
}
