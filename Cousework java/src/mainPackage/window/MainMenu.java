package mainPackage.window;

import mainPackage.window.adapters.InvisibleLinesMenuActionAdapter;
import mainPackage.window.adapters.LightMenuActionAdapter;
import mainPackage.window.adapters.ProjectionsActionAdapter;
import mainPackage.window.dialogWindows.ChangeFigureSizeDialog;
import mainPackage.window.dialogWindows.ChangeLightPointDialog;
import mainPackage.window.dialogWindows.MoveFigureDialog;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainMenu extends JMenuBar {
    JFrame frame;
    DrawingComponent d;

    public MainMenu(JFrame frame) {
        super();
        this.frame = frame;
        add(createFigureMenu());
        add(createProjectionMenu());
        add(createInvisibleLinesMenu());
        add(createLightMenu());
    }

    private JMenu createFigureMenu() {
        JMenu figureMenu = new JMenu("Object");
        JMenuItem changeFigureSize = new JMenuItem("Set size");
        changeFigureSize.addActionListener(createChangeFigureSizeActionListener());
        figureMenu.add(changeFigureSize);
        JMenuItem moveFigure = new JMenuItem("Move");
        moveFigure.addActionListener(createMoveActionListener());
        figureMenu.add(moveFigure);
        return figureMenu;
    }

    private ActionListener createChangeFigureSizeActionListener() {
        return e -> {
            ChangeFigureSizeDialog dialog = new ChangeFigureSizeDialog(frame);
            dialog.setVisible(true);
        };
    }

    private ActionListener createMoveActionListener() {
        return e -> {
            MoveFigureDialog moveFigureDialog = new MoveFigureDialog(frame);
            moveFigureDialog.setVisible(true);
        };
    }

    private JMenu createProjectionMenu() {
        JMenu projectionsMenu = new JMenu("Projections");
        ButtonGroup buttonGroup = new ButtonGroup();

        projectionsMenu.add(new JLabel("Orthographic projection"));

        JRadioButtonMenuItem oXY = new JRadioButtonMenuItem("Front view");
        oXY.addActionListener(new ProjectionsActionAdapter(frame, (byte) 0));
        buttonGroup.add(oXY);
        projectionsMenu.add(oXY);

        JRadioButtonMenuItem oXZ = new JRadioButtonMenuItem("View from above");
        oXZ.addActionListener(new ProjectionsActionAdapter(frame, (byte) 1));
        buttonGroup.add(oXZ);
        projectionsMenu.add(oXZ);

        JRadioButtonMenuItem oYZ = new JRadioButtonMenuItem("View side");
        oYZ.addActionListener(new ProjectionsActionAdapter(frame, (byte) 2));
        buttonGroup.add(oYZ);
        projectionsMenu.add(oYZ);

        projectionsMenu.add(new JSeparator());
        JRadioButtonMenuItem axonometric = new JRadioButtonMenuItem("Axonometric projection");
        axonometric.addActionListener(new ProjectionsActionAdapter(frame, (byte) 3));
        buttonGroup.add(axonometric);
        projectionsMenu.add(axonometric);

        JRadioButtonMenuItem oblique = new JRadioButtonMenuItem("Oblique projection");
        oblique.addActionListener(new ProjectionsActionAdapter(frame, (byte) 4));
        buttonGroup.add(oblique);
        projectionsMenu.add(oblique);

        JRadioButtonMenuItem perspective = new JRadioButtonMenuItem("Perspective projection");
        perspective.addActionListener(new ProjectionsActionAdapter(frame, (byte) 5));
        buttonGroup.add(perspective);
        projectionsMenu.add(perspective);

        oXY.setSelected(true);
        return projectionsMenu;
    }

    private JMenu createInvisibleLinesMenu() {
        JMenu invisibleLinesMenu = new JMenu("Invisible lines");
        JRadioButtonMenuItem on = new JRadioButtonMenuItem("On");
        on.addActionListener(new InvisibleLinesMenuActionAdapter(frame));
        JRadioButtonMenuItem off = new JRadioButtonMenuItem("Off");
        off.addActionListener(new InvisibleLinesMenuActionAdapter(frame));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(on);
        buttonGroup.add(off);
        invisibleLinesMenu.add(on);
        invisibleLinesMenu.add(off);
        on.setSelected(true);
        return invisibleLinesMenu;
    }

    private JMenu createLightMenu() {
        JMenu lightMenu = new JMenu("Light");
        JRadioButtonMenuItem on = new JRadioButtonMenuItem("On");
        on.addActionListener(new LightMenuActionAdapter(frame));
        JRadioButtonMenuItem off = new JRadioButtonMenuItem("Off");
        off.addActionListener(new LightMenuActionAdapter(frame));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(on);
        buttonGroup.add(off);
        lightMenu.add(on);
        lightMenu.add(off);
        off.setSelected(true);

        lightMenu.add(new JSeparator());
        JMenuItem changeLight = new JMenuItem("Change light");
        changeLight.addActionListener(createChangeLightActionListener());
        lightMenu.add(changeLight);
        return lightMenu;
    }


    private ActionListener createChangeLightActionListener() {
        return e -> {
            ChangeLightPointDialog dialog = new ChangeLightPointDialog(frame);
            dialog.setVisible(true);
        };
    }
}
