import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField tf1, tf2, tfResult;
    JButton btnAdd, btnSub, btnMul, btnDiv;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Enter First Number:"));
        tf1 = new JTextField();
        add(tf1);

        add(new JLabel("Enter Second Number:"));
        tf2 = new JTextField();
        add(tf2);

        add(new JLabel("Result:"));
        tfResult = new JTextField();
        tfResult.setEditable(false);
        add(tfResult);

        btnAdd = new JButton("Add");
        btnSub = new JButton("Subtract");
        btnMul = new JButton("Multiply");
        btnDiv = new JButton("Divide");

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(tf1.getText());
            double num2 = Double.parseDouble(tf2.getText());
            double result = 0;

            if (e.getSource() == btnAdd) result = num1 + num2;
            else if (e.getSource() == btnSub) result = num1 - num2;
            else if (e.getSource() == btnMul) result = num1 * num2;
            else if (e.getSource() == btnDiv) {
                if (num2 == 0) {
                    tfResult.setText("Cannot divide by 0");
                    return;
                } else {
                    result = num1 / num2;
                }
            }

            tfResult.setText(String.valueOf(result));

        } catch (NumberFormatException ex) {
            tfResult.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
