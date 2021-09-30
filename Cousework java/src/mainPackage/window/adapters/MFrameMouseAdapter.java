package mainPackage.window.adapters;

import mainPackage.Main;
import mainPackage.window.DrawingComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MFrameMouseAdapter extends MouseAdapter {
    private DrawingComponent drawingComponent;
    private int x, y;
    private boolean isMousePressed, isMouse1Pressed, isMouse3Pressed;

    public MFrameMouseAdapter(DrawingComponent d) {
        super();
        drawingComponent = d;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        if (isMousePressed) {
            isMousePressed = false;
            x = e.getX();
            y = e.getY();
        }
        if (isMouse1Pressed)
            Main.getFigure().rotate(Math.toRadians(y - e.getY()), Math.toRadians(x - e.getX()), 0);
        else if (isMouse3Pressed)
            Main.getFigure().transit(e.getX() - x, y - e.getY(), 0);
        x = e.getX();
        y = e.getY();
        drawingComponent.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if (e.getButton() == MouseEvent.BUTTON1)
            isMouse1Pressed = true;
        else if (e.getButton() == MouseEvent.BUTTON3)
            isMouse3Pressed = true;
        isMousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        int button = e.getButton();
        if (button == MouseEvent.BUTTON1)
            isMouse1Pressed = false;
        else if (button == MouseEvent.BUTTON2)
            isMouse3Pressed = false;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
        double positiveScale = 0.9;
        double negativeScale = 1.1;
        if (e.getWheelRotation() > 0)
            Main.getFigure().scale(positiveScale, positiveScale, positiveScale);
        else
            Main.getFigure().scale(negativeScale, negativeScale, negativeScale);
        drawingComponent.repaint();
    }
}
