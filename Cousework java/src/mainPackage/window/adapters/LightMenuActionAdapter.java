package mainPackage.window.adapters;

import mainPackage.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LightMenuActionAdapter implements ActionListener {
    private JFrame frame;

    public LightMenuActionAdapter(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.getFigure().setLightOn(!Main.getFigure().isLightOn());
        frame.getContentPane().repaint();
    }
}
