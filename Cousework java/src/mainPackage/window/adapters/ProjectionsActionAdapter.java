package mainPackage.window.adapters;

import mainPackage.Main;
import mainPackage.window.dialogWindows.SetAxonometricParametersDialog;
import mainPackage.window.dialogWindows.SetObliqueParametersDialog;
import mainPackage.window.dialogWindows.SetPerspectiveParametersDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectionsActionAdapter implements ActionListener {
    private JFrame frame;
    private final byte mode;
    SetAxonometricParametersDialog axonometricParametersDialog;
    SetObliqueParametersDialog obliqueParametersDialog;
    SetPerspectiveParametersDialog perspectiveParametersDialog;

    public ProjectionsActionAdapter(JFrame frame, byte mode) {
        this.frame = frame;
        this.mode = mode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        act();
    }

    public void act() {
        Main.getFigure().setProjectionMode(mode);
        switch (mode) {
            case 0, 1, 2 -> Main.getFigure().setProjectionPlane(mode);
            case 3 -> {
                axonometricParametersDialog = new SetAxonometricParametersDialog(frame);
                axonometricParametersDialog.setVisible(true);
            }
            case 4 -> {
                obliqueParametersDialog = new SetObliqueParametersDialog(frame);
                obliqueParametersDialog.setVisible(true);
            }
            case 5 -> {
                perspectiveParametersDialog = new SetPerspectiveParametersDialog(frame);
                perspectiveParametersDialog.setVisible(true);
            }
        }
        frame.getContentPane().repaint();
    }
}
