package mainPackage.geometry;

import mainPackage.Main;

import java.awt.*;


public class Edge {
    private Point point1;
    private Point point2;

    public Edge(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Edge(Edge edge) {
        this.point1 = new Point(edge.point1);
        this.point2 = new Point(edge.point2);
    }

    public void drawEdge(Graphics2D graphics2D) {
        Point p1 = new Point(point1);
        Point p2 = new Point(point2);
        /**drawEdgeXY(graphics2D, 1537,865);
         double fi = 45, teta = 45;
         GeometricOperations.axonometric(p1, fi, teta);
         GeometricOperations.axonometric(p2, fi, teta);
         double d = 2, ro = 45;
         GeometricOperations.oblique(p1, d, ro);
         GeometricOperations.oblique(p2, d, ro);
         double d = 30, ro = 45, fi = 0, teta = 0;
         GeometricOperations.perspective(p1, d, ro, fi, teta);
         GeometricOperations.perspective(p2, d, ro, fi, teta);

        graphics2D.drawLine((int) p1.getCoordinates()[0][0] + Main.getFrame().getWidth() / 2,
                -(int) p1.getCoordinates()[0][1] + Main.getFrame().getHeight() / 2,
                (int) p2.getCoordinates()[0][0] + Main.getFrame().getWidth() / 2,
                -(int) p2.getCoordinates()[0][1] + Main.getFrame().getHeight() / 2);*/
    }

    public void drawEdgeXY(Graphics2D graphics2D, int width, int height) {
        graphics2D.drawLine((int) point1.getX() + width / 2,
                -(int) point1.getY() + height / 2,
                (int) point2.getX() + width / 2,
                -(int) point2.getY() + height / 2);
    }

    public void drawEdgeXZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.drawLine((int) point1.getX() + width / 2,
                -(int) point1.getZ() + height / 2,
                (int) point2.getX() + width / 2,
                -(int) point2.getZ() + height / 2);
    }

    public void drawEdgeYZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.drawLine((int) point1.getZ() + width / 2,
                -(int) point1.getY() + height / 2,
                (int) point2.getZ() + width / 2,
                -(int) point2.getY() + height / 2);
    }

    public Point getPoint1() {
        return point1;
    }
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

}

