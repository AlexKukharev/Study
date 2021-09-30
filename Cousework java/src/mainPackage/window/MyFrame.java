package mainPackage.window;

import mainPackage.window.adapters.MFrameKeyAdapter;
import mainPackage.window.adapters.MFrameMouseAdapter;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(String title){
        super(title);
        setSize(getToolkit().getScreenSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DrawingComponent drawingComponent = new DrawingComponent(this);
        add(drawingComponent);

        setJMenuBar(new MainMenu(this));

        MFrameMouseAdapter mouseAdapter = new MFrameMouseAdapter(drawingComponent);
        addMouseMotionListener(mouseAdapter);
        addMouseListener(mouseAdapter);
        addMouseWheelListener(mouseAdapter);

        addKeyListener(new MFrameKeyAdapter(drawingComponent));

        setVisible(true);
    }
}
