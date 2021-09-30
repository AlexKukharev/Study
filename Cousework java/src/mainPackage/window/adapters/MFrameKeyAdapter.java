package mainPackage.window.adapters;

import mainPackage.Main;
import mainPackage.window.DrawingComponent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MFrameKeyAdapter extends KeyAdapter {
    private DrawingComponent drawingComponent;

    public MFrameKeyAdapter(DrawingComponent d) {
        super();
        drawingComponent = d;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                Main.getFigure().reset();
                break;
        }
        drawingComponent.repaint();
    }
}
