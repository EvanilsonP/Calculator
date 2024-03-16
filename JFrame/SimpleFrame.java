package JFrame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SimpleFrame extends JFrame {

    public SimpleFrame(){

        setTitle("My humble JFrame!");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, World!");
        add(label);
        setVisible(true);

    };
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        SimpleFrame simpleFrame = new SimpleFrame();
    };
};

// Crie uma aplicação Java que exiba uma janela simples usando a classe JFrame.

