package mainPackage.window.dialogWindows;

import mainPackage.Main;
import mainPackage.geometry.Building;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class ChangeFigureSizeDialog extends JDialog {
    private JTextField rTextField;
    private JTextField RTextField;
    private JTextField hTextField;
    private JTextField nTextField;

    private JFrame frame;

    public ChangeFigureSizeDialog(JFrame frame) {
        super(frame, "Set Object Size", true);
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
            double r = 0, R = 0, h = 0;
            int n = 0;
            boolean isCorrect = false;
            try {
                r = Double.parseDouble(rTextField.getText());
                R = Double.parseDouble(RTextField.getText());
                h = Double.parseDouble(hTextField.getText());
                n = Integer.parseInt(nTextField.getText());

                if (r <= 0 || R <= 0 || h <= 0 || n <= 0) throw new Exception();
                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                Building figure = (Building) Main.getFigure();
                figure.changeFigureSize(r, R, h, n);
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
        panel.add(new JLabel("r:"));
        rTextField = new JTextField("  50  ");
        panel.add(rTextField);
        panel.add(new JLabel("R:"));
        RTextField = new JTextField("  100  ");
        panel.add(RTextField);
        panel.add(new JLabel("h:"));
        hTextField = new JTextField("  200  ");
        panel.add(hTextField);
        panel.add(new JLabel("n:"));
        nTextField = new JTextField("  12  ");
        panel.add(nTextField);
        return panel;
    }
}

