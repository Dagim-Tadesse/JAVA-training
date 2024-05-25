package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simpleCalc {
    private JFrame frame;
    private JTextField textField;
    private double num1, num2, result;
    private char operator;

    public simpleCalc() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.add(textField, BorderLayout.NORTH);

        // numbers

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            button.setFont(new Font("jokerman", Font.BOLD, 18));
            panel.add(button);
        }

        // clear

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ButtonClickListener());
        clearButton.setFont(new Font("Arial", Font.BOLD, 18));
        clearButton.setForeground(Color.RED);
        clearButton.setPreferredSize(new Dimension(60, 40));// new size
        topPanel.add(clearButton);

        // Add panels
        frame.add(topPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("C")) {
                // Clear everything
                textField.setText("");
                num1 = 0;
                num2 = 0;
                result = 0;
                operator = '\0';
            } else if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
                textField.setText(textField.getText() + command);
            } else if (command.equals("=")) {
                try {
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                textField.setText("Error: Divide by zero");
                                return;
                            }
                            result = num1 / num2;
                            break;
                    }
                    textField.setText(String.valueOf(result));//valueOf : change double to string
                } catch (NumberFormatException ex) {
                    textField.setText("Error");
                }
            } else {
                try {
                    num1 = Double.parseDouble(textField.getText());
                    operator = command.charAt(0);
                    textField.setText("");
                } catch (NumberFormatException ex) {
                    textField.setText("Error");
                }
            }
        }
    }

    public static void main(String[] args) {
    
        SwingUtilities.invokeLater(() -> new simpleCalc());
    }
}