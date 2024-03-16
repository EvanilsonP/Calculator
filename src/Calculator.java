import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];            // number os buttons we need in a calculator
    JButton[] functionButtons = new JButton[8];           // number of function buttons we need in a calculator
    JButton addbButton, subButton, multButton, divButton; 
    JPanel panel;

    Font myFont = new Font("ink Free", Font.BOLD, 30);

    double numb1 = 0, numb2 = 0;
    char operator;

    Calculator() {
        Calculator calc = new Calculator();
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}