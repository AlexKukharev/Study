package mainPackage.window.dialogWindows;

import mainPackage.Main;
import mainPackage.geometry.Figure;
import mainPackage.geometry.Point;
import mainPackage.geometry.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static java.lang.Math.cos;
import static java.lang.Math.toRadians;

public class SetPerspectiveParametersDialog extends JDialog {
    private JTextField dTextField;
    private JTextField roTextField;
    private JTextField fiTextField;
    private JTextField teta1TextField;

    private JFrame frame;

    public SetPerspectiveParametersDialog(JFrame frame) {
        super(frame, "Set Perspective Parameters", true);
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
            double d = 0, ro = 0, fi = 0, teta = 0;
            boolean isCorrect = false;
            try {
                d = Double.parseDouble(dTextField.getText());
                ro = Double.parseDouble(roTextField.getText());
                fi = Double.parseDouble(fiTextField.getText());
                teta = Double.parseDouble(teta1TextField.getText());
                if (d < 0 || ro < 0 || fi < 0 || teta < 0) throw new Exception();
                isCorrect = true;
            } catch (Exception ignored) {
            }
            if (isCorrect) {
                Figure figure = Main.getFigure();
                figure.setPerspective(d, ro, toRadians(fi), toRadians(teta));
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
        panel.add(new JLabel("d:"));
        dTextField = new JTextField("200");
        panel.add(dTextField);
        panel.add(new JLabel("ro:"));
        roTextField = new JTextField("100");
        panel.add(roTextField);
        panel.add(new JLabel("fi:"));
        fiTextField = new JTextField("000");
        panel.add(fiTextField);
        panel.add(new JLabel("teta:"));
        teta1TextField = new JTextField("000");
        panel.add(teta1TextField);
        return panel;
    }
}
