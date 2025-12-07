package JavaSwingDeber_Toaquiza;

import javax.swing.*;
import java.awt.*;

public class Formulario extends JFrame {
    private JCheckBox programacionCheckBox;
    private JCheckBox redesCheckBox;
    private JCheckBox basesDeDatosCheckBox;
    private JCheckBox disenioCheckBox;
    private JCheckBox seguridadInformaticaCheckBox;
    private JButton procesarSeleccionButton;
    private JPanel panel;
    private JTextArea textArea1;
    private JLabel resultadoLabel;

    public Formulario() {
        setTitle("Formulario Toa");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        procesarSeleccionButton.addActionListener(e -> {
            StringBuilder seleccionados = new StringBuilder();

            if (programacionCheckBox.isSelected()) seleccionados.append("Programación\n");
            if (redesCheckBox.isSelected()) seleccionados.append("Redes\n");
            if (basesDeDatosCheckBox.isSelected()) seleccionados.append("Bases de Datos\n");
            if (disenioCheckBox.isSelected()) seleccionados.append("Diseño\n");
            if (seguridadInformaticaCheckBox.isSelected()) seleccionados.append("Seguridad Informática\n");

            textArea1.setText(seleccionados.toString());

        });
    }


    public static void main(String[] args) {
        new Formulario();
    }
}

