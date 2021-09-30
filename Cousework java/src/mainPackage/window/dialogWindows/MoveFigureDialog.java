package mainPackage.window.dialogWindows;

import mainPackage.Main;
import mainPackage.geometry.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MoveFigureDialog extends JDialog {
    private JTextField xTextField;
    private JTextField yTextField;
    private JTextField zTextField;

    private JFrame frame;

    public MoveFigureDialog(JFrame frame) {
        super(frame, "Move Object", true);
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
        JButton okButton = new JButton("Accept");
        okButton.addActionListener(createOkActionListener());
        panel.add(okButton);
        return panel;
    }

    private ActionListener createOkActionListener() {
        return e -> {
            double x = 0, y = 0, z = 0;
            boolean isCorrect = false;
            try {
                x = Double.parseDouble(xTextField.getText());
                y = Double.parseDouble(yTextField.getText());
                z = Double.parseDouble(zTextField.getText());
                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                Figure figure = Main.getFigure();
                figure.transit(x, y, z);
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
        panel.add(new JLabel("dx:"));
        xTextField = new JTextField("        ");
        panel.add(xTextField);
        panel.add(new JLabel("dy:"));
        yTextField = new JTextField("        ");
        panel.add(yTextField);
        panel.add(new JLabel("dz:"));
        zTextField = new JTextField("        ");
        panel.add(zTextField);
        return panel;
    }
}

