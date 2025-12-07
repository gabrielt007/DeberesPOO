package JavaSwingDeber_Toaquiza;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Encuesta extends JFrame{
    private JRadioButton SIRadioButton;
    private JRadioButton TALVEZRadioButton1;
    private JRadioButton NORadioButton;
    private JRadioButton SIRadioButton1;
    private JRadioButton TALVEZRadioButton2;
    private JRadioButton NORadioButton1;
    private JRadioButton SIRadioButton2;
    private JRadioButton TALVEZRadioButton3;
    private JRadioButton NORadioButton2;
    private JButton enviarRespuestasButton;
    private JPanel panle2;
    private JLabel respuestaPregunta1;
    private JLabel respuestaPregunta2;
    private JLabel respuestaPregunta3;

    public Encuesta() {
        setTitle("Encuesta Toa");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400, 380);
        setContentPane(panle2);
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(SIRadioButton);
        grupo1.add(TALVEZRadioButton1);
        grupo1.add(NORadioButton);

        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(SIRadioButton1);
        grupo2.add(TALVEZRadioButton2);
        grupo2.add(NORadioButton1);

        ButtonGroup grupo3 = new ButtonGroup();
        grupo3.add(SIRadioButton2);
        grupo3.add(TALVEZRadioButton3);
        grupo3.add(NORadioButton2);

        enviarRespuestasButton.addActionListener(e -> {
            if (SIRadioButton.isSelected()) {
                respuestaPregunta1.setText("Sí");
            } else if (TALVEZRadioButton1.isSelected()) {
                respuestaPregunta1.setText("Tal vez");
            } else if (NORadioButton.isSelected()) {
                respuestaPregunta1.setText("No");
            }

            if (SIRadioButton1.isSelected()) {
                respuestaPregunta2.setText("Sí");
            } else if (TALVEZRadioButton2.isSelected()) {
                respuestaPregunta2.setText("Tal vez");
            } else if (NORadioButton1.isSelected()) {
                respuestaPregunta2.setText("No");
            }

            if (SIRadioButton2.isSelected()) {
                respuestaPregunta3.setText("Sí");
            } else if (TALVEZRadioButton3.isSelected()) {
                respuestaPregunta3.setText("Tal vez");
            } else if (NORadioButton2.isSelected()) {
                respuestaPregunta3.setText("No");
            }

        });

    }

    public static void main(String[] args) {
        new Encuesta();
    }

}



