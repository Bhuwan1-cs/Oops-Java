import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GridCalculator extends JFrame implements ActionListener {
    private final JTextField tf;
    private double a = 0, b = 0, result = 0;
    private String operator = "";
    public GridCalculator() {
        tf = new JTextField();
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setFont(tf.getFont().deriveFont(20f));
        setLayout(new BorderLayout(5, 5));
        add(tf, BorderLayout.NORTH);
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", ".", "=", "C"
        };
        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(btn.getFont().deriveFont(18f));
            btn.addActionListener(this);
            panel.add(btn);
        }
        JPanel south = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton modButton = new JButton("%");
        modButton.setFont(modButton.getFont().deriveFont(18f));
        modButton.addActionListener(this);
        south.add(modButton);
        add(panel, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        setTitle("Calculator");
        setSize(300, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            tf.setText(tf.getText() + command);
            return;
        }
        if (command.equals("C")) {
            tf.setText("");
            operator = "";
            a = b = result = 0;
            return;
        }
        if (command.equals("=")) {
            try {
                if (tf.getText().isEmpty()) {
                    return;
                }
                b = Double.parseDouble(tf.getText());
                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "%":
                        result = b != 0 ? a % b : Double.NaN;
                        break;
                    default:
                        result = b;
                }
                if (Double.isNaN(result) || Double.isInfinite(result)) {
                    tf.setText("Error");
                } else {
                    String out = (result == (long) result) ? String.valueOf((long) result) : String.valueOf(result);
                    tf.setText(out);
                }
                operator = "";
            } catch (NumberFormatException ex) {
                tf.setText("Error");
            }
            return;
        }
        try {
            if (!tf.getText().isEmpty()) {
                a = Double.parseDouble(tf.getText());
            } else {
                a = a;
            }
            operator = command;
            tf.setText("");
        } catch (NumberFormatException ex) {
            tf.setText("Error");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GridCalculator::new);
    }
}
