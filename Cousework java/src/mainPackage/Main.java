package mainPackage;

import mainPackage.geometry.Building;
import mainPackage.geometry.Figure;
import mainPackage.window.MyFrame;

public class Main {
    private static Figure figure;
    public static void main(String[] args) {
        figure = new Building(100,200,400,12);
        new MyFrame("Coursework");
    }

    public static Figure getFigure() {
        return figure;
    }

    public static void setFigure(Figure figure) {
        Main.figure = figure;
    }
}
