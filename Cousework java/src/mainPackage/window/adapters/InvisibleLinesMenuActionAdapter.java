package mainPackage.window.adapters;

import mainPackage.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvisibleLinesMenuActionAdapter implements ActionListener {
    private JFrame frame;

    public InvisibleLinesMenuActionAdapter(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Main.getFigure().setDeleteInvisible(!Main.getFigure().isDeleteInvisible());
        frame.getContentPane().repaint();
    }
}
