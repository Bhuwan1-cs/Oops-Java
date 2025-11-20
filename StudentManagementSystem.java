import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class StudentManagementSystem {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Adjusted height for full image

        // Load and set the background image
        ImageIcon icon = new ImageIcon("C:\\Users\\97156\\Downloads\\A_modern,_minimalist_wallpaper_for_a_Student_Manag.jpg");
        JLabel background = new JLabel(icon);
        frame.setContentPane(background);
        background.setLayout(new BorderLayout());

        // Transparent panel for overlaying table and controls
        JPanel overlayPanel = new JPanel(new BorderLayout());
        overlayPanel.setOpaque(false);
        background.add(overlayPanel);

        // Table to display students
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Gender");
        tableModel.addColumn("Contact");
        tableModel.addColumn("Course");
        tableModel.addColumn("University");
        JTable table = new JTable(tableModel);

        // Make the table background and grid transparent
        table.setOpaque(false);  // Set table background transparent
        table.setFillsViewportHeight(true); // Makes sure the table fills the viewport
        table.getTableHeader().setOpaque(false);  // Set table header transparent

        // Set the cell renderer to be transparent and use bold font for data
        table.setDefaultRenderer(Object.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setOpaque(false); // Make cell content transparent
                label.setFont(new Font("Arial", Font.BOLD, 12)); // Set font to bold
                return label;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        overlayPanel.add(scrollPane, BorderLayout.CENTER);

        // Add some predefined students
        tableModel.addRow(new Object[]{"101", "Alice", "20", "Female", "1234567890", "Computer Science", "ABC University"});
        tableModel.addRow(new Object[]{"102", "Bob", "21", "Male", "9876543210", "Mechanical Engineering", "XYZ University"});
        tableModel.addRow(new Object[]{"103", "Charlie", "22", "Non-Binary", "5678901234", "Electrical Engineering", "DEF University"});

        // Panel for controls
        JPanel controlPanel = new JPanel(new FlowLayout());
        controlPanel.setOpaque(false); // Make the control panel transparent

        // Input fields (make them transparent)
        JTextField idField = new JTextField(5);
        JTextField nameField = new JTextField(10);
        JTextField ageField = new JTextField(5);
        JTextField genderField = new JTextField(10);
        JTextField contactField = new JTextField(10);
        JTextField courseField = new JTextField(10);
        JTextField universityField = new JTextField(15);

        // Remove borders from input fields
        idField.setBorder(BorderFactory.createEmptyBorder());
        nameField.setBorder(BorderFactory.createEmptyBorder());
        ageField.setBorder(BorderFactory.createEmptyBorder());
        genderField.setBorder(BorderFactory.createEmptyBorder());
        contactField.setBorder(BorderFactory.createEmptyBorder());
        courseField.setBorder(BorderFactory.createEmptyBorder());
        universityField.setBorder(BorderFactory.createEmptyBorder());

        // Buttons
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        // Add components to the control panel
        controlPanel.add(new JLabel("ID:"));
        controlPanel.add(idField);
        controlPanel.add(new JLabel("Name:"));
        controlPanel.add(nameField);
        controlPanel.add(new JLabel("Age:"));
        controlPanel.add(ageField);
        controlPanel.add(new JLabel("Gender:"));
        controlPanel.add(genderField);
        controlPanel.add(new JLabel("Contact:"));
        controlPanel.add(contactField);
        controlPanel.add(new JLabel("Course:"));
        controlPanel.add(courseField);
        controlPanel.add(new JLabel("University:"));
        controlPanel.add(universityField);
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);

        overlayPanel.add(controlPanel, BorderLayout.SOUTH);

        // Add button action listener
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String age = ageField.getText();
            String gender = genderField.getText();
            String contact = contactField.getText();
            String course = courseField.getText();
            String university = universityField.getText();

            if (id.isEmpty() || name.isEmpty() || age.isEmpty() || gender.isEmpty() || contact.isEmpty() || course.isEmpty() || university.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Vector<String> row = new Vector<>();
                row.add(id);
                row.add(name);
                row.add(age);
                row.add(gender);
                row.add(contact);
                row.add(course);
                row.add(university);
                tableModel.addRow(row);

                idField.setText("");
                nameField.setText("");
                ageField.setText("");
                genderField.setText("");
                contactField.setText("");
                courseField.setText("");
                universityField.setText("");
            }
        });

        // Delete button action listener
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(frame, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                tableModel.removeRow(selectedRow);
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
