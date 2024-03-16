import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    // uma calculadora possui dez números, então criaremos uma array contendo dez botões (números de 0 a 9)
    JButton[] numberButtons = new JButton[10];             
    // uma calculadora possui funções (somar, diminuir, etc...) então criamos uma array aqui também         
    JButton[] functionButtons = new JButton[8];    
    // funções da calculadora                 
    JButton addButton, subButton, mulButton, divButton;             
    // funções da calculadora decimal, igual, deletar e limpar
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    double number1 = 0, number2 = 0, result = 0;
    char operator;

    Calculator() {
        // Tela que vai conter os botões
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
		frame.setLayout(null);

        // 
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        // por padrão podemos inserir valores ao campo, então usamos setEditable para falso 
        textfield.setEditable(false);       

        // Botões relacionados as funções da calculadora
        addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");

        // Adiciona os botões acima para a array de funções dos botões
        functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;

        // Alterando caracteristicas dos botões
        for(int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
        };

        // Mesma coisa aqui
        for(int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
        };

        // setBounds define a posição e o tamanho de um botão na tela.
        delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);

        // container onde estará os botões da calculadora
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
        // panel.setBackground(Color.gray);

        // adiciona os botões e funções para a tela
        panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);

        // .add adiciona o botão na tela
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        // adicionando o campo de texto
        frame.add(textfield);                    
        // responsável por mostrar a tela ao clicar em Run                     
        frame.setVisible(true);                                     
    };
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // adicionando funcionalidades ao botões da calculadora

        // checa se o usuário clica em um dos botões
        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]) {
                // ao clicar em algum botão que contém números, o mesmo irá para o campo de texto
                textfield.setText(textfield.getText().concat(String.valueOf(i))); 
            };
        }   // adiciona o . na tela ao clicá-lo
            if(e.getSource() == decButton) {
                textfield.setText(textfield.getText().concat(String.valueOf("."))); 
            }
            if(e.getSource() == addButton) {
                number1 = Double.parseDouble(textfield.getText());
                operator ='+';
                textfield.setText("");
            }
            if(e.getSource() == subButton) {
                number1 = Double.parseDouble(textfield.getText());
                operator ='-';
                textfield.setText("");
            }
            if(e.getSource() == mulButton) {
                number1 = Double.parseDouble(textfield.getText());
                operator ='*';
                textfield.setText("");
            }
            if(e.getSource() == divButton) {
                number1 = Double.parseDouble(textfield.getText());
                operator ='/';
                textfield.setText("");
            }
            if(e.getSource() == equButton) {
                number2=Double.parseDouble(textfield.getText());
                
                switch(operator) {
                case'+':
                    result = number1 + number2;
                    break;
                case'-':
                    result = number1 - number2;
                    break;
                case'*':
                    result = number1 * number2;
                    break;
                case'/':
                    result = number1 / number2;
                    break;
                }
                textfield.setText(String.valueOf(result));
                number1 = result;
        };
        // lógica para limpar o campo de texto
        if(e.getSource() == clrButton) {
            textfield.setText("");
        }

        // lógica para deletar um número do campo de texto
        if(e.getSource() == delButton) {
            String string = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < string.length()-1; i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
    }
}