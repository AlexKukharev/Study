package mainPackage.window;

import mainPackage.Main;

import javax.swing.*;
import java.awt.*;

public class DrawingComponent extends JPanel {
    private final JFrame frame;

    public DrawingComponent(JFrame frame){
        super();
        this.frame = frame;
        setBackground(Color.LIGHT_GRAY );
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Main.getFigure().drawEdges((Graphics2D) g,frame.getWidth(), frame.getHeight());
    }
}
