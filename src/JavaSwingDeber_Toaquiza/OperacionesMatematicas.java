package JavaSwingDeber_Toaquiza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesMatematicas extends JFrame {
    private JTextField valor1;
    private JPanel panel1;
    private JTextField valor2;
    private JButton sumaButton;
    private JButton restaButton;
    private JButton multiplicacionButton;
    private JButton divisionButton;
    private JLabel Respuestalbl;

    public OperacionesMatematicas(){
        setTitle("Calculadora Simple Toa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 400);
        setContentPane(panel1);
        sumaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(valor1.getText());
                    int num2 = Integer.parseInt(valor2.getText());
                    int suma = num1 + num2;
                    Respuestalbl.setText("=== " + suma+" ===");
                } catch (NumberFormatException _) {
                    JOptionPane.showMessageDialog(null,"Por Favor ingresa valores válidos.");
                }
            }
        });
        restaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(valor1.getText());
                    int num2 = Integer.parseInt(valor2.getText());
                    int resta = num1 - num2;
                    Respuestalbl.setText("=== " + resta +" ===");
                } catch (NumberFormatException _) {
                    JOptionPane.showMessageDialog(null,"Por Favor ingresa valores válidos.");
                }
            }
        });
        multiplicacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(valor1.getText());
                    double num2 = Double.parseDouble(valor2.getText());
                    double multiplicacion = num1 * num2;
                    Respuestalbl.setText("=== " + multiplicacion +" ===");
                } catch (NumberFormatException _) {
                    JOptionPane.showMessageDialog(null,"Por Favor ingresa valores válidos.");
                }
            }
        });
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(valor1.getText());
                    double num2 = Double.parseDouble(valor2.getText());
                    double division = num1 / num2;
                    Respuestalbl.setText("=== " + division +" ===");
                } catch (NumberFormatException _) {
                    JOptionPane.showMessageDialog(null,"Por Favor ingresa valores válidos.");
                }
            }
        });
    }
    public static void main(String[] args){
        new OperacionesMatematicas();
    }
}
