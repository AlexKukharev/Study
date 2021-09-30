package mainPackage.geometry;

import mainPackage.Main;

import java.awt.*;

public class Face {
    private Point[] points;
    private Edge[] edges;
    public int clr, clr1, num = 1;

    public Face(Point... points) {
        this.points = points;
    }

    public Face(Face f) {
        Point[] poit = f.points;
        Edge[] edg = f.edges;
        points = new Point[poit.length];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(poit[i]);
        }
        edges = new Edge[edg.length];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(edg[i]);
        }
    }

    public void drawFaceXY(Graphics2D graphics2D, Point light, boolean isLight0n, int width, int height) {
        Vector nVect = new Vector(points[0], points[1], points[2]);
        if (nVect.cos(new Vector(0, 0, -1)) >= 0) {
            graphics2D.setStroke(new BasicStroke(4));

            double x1 = 0, y1 = 0, z1 = 0;
            int n = 0;
            for (Point v : points) {
                x1 += v.getX();
                y1 += v.getY();
            z1 += v.getZ();
                n++;
            }
            x1 = x1 / n;
            y1 = y1 / n;
            z1 = z1 / n;
            Vector lightVect = new Vector(light.getX() - x1,
                    light.getY() - y1,
                    light.getZ() - z1);

            int[] y = new int[points.length];
            int[] x = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                y[i] = -(int) points[i].getY() + height / 2;
                x[i] = (int) points[i].getX() + width / 2;
            }
            Polygon p = new Polygon(x, y, x.length);
            if (isLight0n) {
                clr = (createLight(nVect.cos(lightVect)));//диффузное,100-интенсивоность отражённого света 0*
                graphics2D.setColor(new Color(clr, (int) (0.5 * clr), 0));
            } else
                graphics2D.setColor(Color.GRAY);
            graphics2D.fillPolygon(p);
            drawEdgesXY(graphics2D, width, height);
        }
    }

    public void drawFaceXZ(Graphics2D graphics2D, Point light, boolean isLight0n, int width, int height) {
        Vector nVect = new Vector(points[0], points[1], points[2]);
        if (nVect.cos(new Vector(0, -1, 0)) >= 0) {
            graphics2D.setStroke(new BasicStroke(4));

            double x1 = 0, y1 = 0, z1 = 0;
            int n = 0;
            for (Point v : points) {
                x1 += v.getX();
                y1 += v.getY();
                z1 += v.getZ();
                n++;
            }
            x1 = x1 / n;
            y1 = y1 / n;
            z1 = z1 / n;
            Vector lightVect = new Vector(light.getX() - x1,
                    light.getY() - y1,
                    light.getZ() - z1);

            int[] z = new int[points.length];
            int[] x = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                z[i] = -(int) points[i].getZ() + height / 2;
                x[i] = (int) points[i].getX() + width / 2;
            }
            Polygon p = new Polygon(x, z, x.length);
            if (isLight0n) {
                clr = (createLight(nVect.cos(lightVect)));
                graphics2D.setColor(new Color(clr, (int) (0.5 * clr), 0));
            } else
                graphics2D.setColor(Color.GRAY);
            graphics2D.fillPolygon(p);
            drawEdgesXZ(graphics2D, width, height);
        }
    }

    public void drawFaceYZ(Graphics2D graphics2D, Point light, boolean isLight0n, int width, int height) {
        Vector nVect = new Vector(points[0], points[1], points[2]);
        if (nVect.cos(new Vector(-1, 0, 0)) >= 0) {
            graphics2D.setStroke(new BasicStroke(4));

            double x1 = 0, y1 = 0, z1 = 0;
            int n = 0;
            for (Point v : points) {
                x1 += v.getX();
                y1 += v.getY();
                z1 += v.getZ();
                n++;
            }
            x1 = x1 / n;
            y1 = y1 / n;
            z1 = z1 / n;
            Vector lightVect = new Vector(light.getX() - x1,
                    light.getY() - y1,
                    light.getZ() - z1);

            int[] y = new int[points.length];
            int[] z = new int[points.length];
            for (int i = 0; i < points.length; i++) {
                y[i] = -(int) points[i].getY() + height / 2;
                z[i] = (int) points[i].getZ() + width / 2;
            }
            Polygon p = new Polygon(z, y, z.length);
            if (isLight0n) {
                clr = (createLight(nVect.cos(lightVect)));
                graphics2D.setColor(new Color(clr, (int) (0.5 * clr), 0));
            } else
                graphics2D.setColor(Color.GRAY);
            graphics2D.fillPolygon(p);
            drawEdgesYZ(graphics2D, width, height);
        }
    }

    public void drawEdgesXY(Graphics2D graphics2D, int width, int height) {
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.setColor(new Color(clr, (int) (0.5 * clr), 0));
        for (Edge edge : edges) {
            edge.drawEdgeXY(graphics2D, width, height);
        }
    }

    public void drawEdgesXZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.setColor(new Color(clr, (int) (0.5 * clr), 0));
        for (Edge edge : edges) {
            edge.drawEdgeXZ(graphics2D, width, height);
        }
    }

    public void drawEdgesYZ(Graphics2D graphics2D, int width, int height) {
        graphics2D.setStroke(new BasicStroke(4));
        graphics2D.setColor(new Color(clr, (int) (0.5 * clr), 0));
        for (Edge edge : edges) {
            edge.drawEdgeYZ(graphics2D, width, height);
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }

    private int createLight(double cos) {
        int clr = (int) (cos > 0 ? (Main.getFigure().getAmbientLight() +
                cos * Main.getFigure().getDiffisedLight()) : (Main.getFigure().getAmbientLight()));
        if (clr > 255) clr = 255;
        if (clr < 0) clr = 0;
        return clr;
    }
}
