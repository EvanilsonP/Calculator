package JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;

public class CalculatorApp extends JFrame {
    
    CalculatorApp() {

        setTitle("Simple Calculator.");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Cria um JTextField para exibir os números e o resultado
        JTextField textfield = new JTextField();
        textfield.setFont(new Font("Arial", Font.PLAIN, 20));

        // Cria botões para os dígitos de 0 a 9, os operadores e o ponto decimal
        JButton[] numberButtons = new JButton[10];
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            panel.add(numberButtons[i]);
        }
        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton decButton = new JButton(".");
        JButton equButton = new JButton("=");

        // Adiciona os botões ao painel
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(decButton);
        panel.add(equButton);

        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        CalculatorApp calculator = new CalculatorApp();
    }
}
