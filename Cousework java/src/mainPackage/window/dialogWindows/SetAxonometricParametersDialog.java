package mainPackage.window.dialogWindows;

import mainPackage.Main;
import mainPackage.geometry.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.lang.Math.toRadians;

public class SetAxonometricParametersDialog extends JDialog {
    private JTextField lTextField;
    private JTextField aTextField;

    private JFrame frame;

    public SetAxonometricParametersDialog(JFrame frame) {
        super(frame, "Set Axonometric Parameters", true);
        this.frame = frame;

        Container container = getContentPane();
        container.setLayout(new GridLayout(2, 1, 0, 0));

        container.add(createTextFields());
        container.add(createOkButton());

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JPanel createOkButton() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton okButton = new JButton("Ok");
        okButton.addActionListener(createOkActionListener());
        panel.add(okButton);
        return panel;
    }

    private ActionListener createOkActionListener() {
        return e -> {
            double psi = 0, fi = 0;
            boolean isCorrect = false;
            try {
                psi = Double.parseDouble(lTextField.getText());
                fi = Double.parseDouble(aTextField.getText());
                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                Figure figure = Main.getFigure();
                figure.setAxonometric(toRadians(psi), toRadians(fi));
                frame.getContentPane().repaint();
            }
            else
                JOptionPane.showMessageDialog(frame,
                        "Ошибка!Введите целочисленные значения от 0 до 500",
                        "Найдена ошибка",
                        JOptionPane.ERROR_MESSAGE);
            this.dispose();
        };
    }

    private JPanel createTextFields() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(new JLabel("psi:"));
        lTextField = new JTextField("45");
        panel.add(lTextField);
        panel.add(new JLabel("fi:"));
        aTextField = new JTextField("45");
        panel.add(aTextField);
        return panel;
    }
}
