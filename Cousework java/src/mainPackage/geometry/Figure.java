package mainPackage.geometry;

import mainPackage.geometry.comparators.FaceXComparator;
import mainPackage.geometry.comparators.FaceYComparator;
import mainPackage.geometry.comparators.FaceZComparator;

import java.awt.*;
import java.util.Arrays;

public abstract class Figure {
    private Face[] faces;
    private Point[] points;
    private Point center;
    private Point light = new Point(300, 300, -200);
    private double d = 0, ro = 0, fi = 0, teta = 0;
    private byte projectionMode = 0b0;
    private byte projectionPlane = 0b0;
    private boolean isDeleteInvisible = false;
    private boolean isReset = false;
    private boolean isLightOn = false;
    double ambientLight = 0.5;
    private double diffisedLight = 0.5;

    public abstract void buildPoints();

    public abstract void buildFaces();

    public abstract void buildEdges();

    /*private void buildEdges() {
        int length = points.length / 4;
        edges = new Edge[length * 6];
        for (int i = 0; i < length; i++) {
            edges[i] = new Edge(points[i], points[(i + 1) % length]);
            edges[i + length] = new Edge(points[i + length], points[(i + 1) % length + length]);
            edges[i + length * 2] = new Edge(points[i + length * 2], points[(i + 1) % length + length * 2]);
            edges[i + length * 3] = new Edge(points[i + length * 3], points[(i + 1) % length + length * 3]);
            edges[i + length * 4] = new Edge(points[i], points[i + length * 2]);
            edges[i + length * 5] = new Edge(points[i + length], points[i + length * 3]);
        }
    }

    private void buildPoints() {
        int n = 12;
        points = new Point[n * 4];
        double angle = Math.toRadians(360.0 / n);
        for (int i = 0; i < n; i++) {
            points[i] = new Point(r * Math.cos(angle * i), h / 2, r * Math.sin(angle * i));
            points[i + n] = new Point(R * Math.cos(angle * i), h / 2, R * Math.sin(angle * i));
            points[i + n * 2] = new Point(r * Math.cos(angle * i), -h / 2, r * Math.sin(angle * i));
            points[i + n * 3] = new Point(R * Math.cos(angle * i), -h / 2, R * Math.sin(angle * i));
        }
        Point center = new Point(0, 0, 0);
        setPoints(points);
        setCenter(center);
    }*/

    public void drawEdges(Graphics2D graphics2D, int width, int height) {
        Face[] facesCopy = new Face[faces.length];
        for (int i = 0; i < facesCopy.length; i++)
            facesCopy[i] = new Face(faces[i]);
        switch (projectionMode) {
            case 3 -> axonometric(facesCopy);
            case 4 -> oblique(facesCopy);
            case 5 -> perspective(facesCopy);
        }
        if (isDeleteInvisible) {
            graphics2D.setStroke(new BasicStroke(1));
            switch (projectionMode) {
                case 1 -> {
                    Arrays.sort(facesCopy, new FaceYComparator());
                    for (Face face : facesCopy)
                        face.drawFaceXZ(graphics2D, light, isLightOn, width, height);
                }
                case 2 -> {
                    Arrays.sort(facesCopy, new FaceXComparator());
                    for (Face face : facesCopy)
                        face.drawFaceYZ(graphics2D, light, isLightOn, width, height);
                }
                default -> {
                    Arrays.sort(facesCopy, new FaceZComparator());
                    for (Face face : facesCopy)
                        face.drawFaceXY(graphics2D, light, isLightOn, width, height);
                }
            }
        } else
            switch (projectionMode) {
                case 1:
                    for (Face face : facesCopy)
                        face.drawEdgesXZ(graphics2D, width, height);
                    break;
                case 2:
                    for (Face face : facesCopy)
                        face.drawEdgesYZ(graphics2D, width, height);
                    break;
                default:
                    for (Face face : facesCopy)
                        face.drawEdgesXY(graphics2D, width, height);
                    break;
            }
    }

    private void perspective(Face[] faces) {
        for (Face face : faces) {
            for (Point vertex : face.getPoints())
                GeometricOperations.perspective(vertex, d, ro, fi, teta);
            for (Edge edge : face.getEdges()) {
                GeometricOperations.perspective(edge.getPoint1(), d, ro, fi, teta);
                GeometricOperations.perspective(edge.getPoint2(), d, ro, fi, teta);
            }
        }
    }

    private void oblique(Face[] faces) {
        for (Face face : faces) {
            for (Point vertex : face.getPoints())
                GeometricOperations.oblique(vertex, d, ro);
            for (Edge edge : face.getEdges()) {
                GeometricOperations.oblique(edge.getPoint1(), d, ro);
                GeometricOperations.oblique(edge.getPoint2(), d, ro);
            }
        }
    }

    private void axonometric(Face[] faces) {
        for (Face face : faces) {
            for (Point vertex : face.getPoints())
                GeometricOperations.axonometric(vertex, teta, fi);
            for (Edge edge : face.getEdges()) {
                GeometricOperations.axonometric(edge.getPoint1(), teta, fi);
                GeometricOperations.axonometric(edge.getPoint2(), teta, fi);
            }
        }
    }

    public void rotate(double angleX, double angleY, double angleZ) {
        for (Point point : points) {
            GeometricOperations.rotate(point, angleX, angleY, angleZ);
        }
        GeometricOperations.rotate(center, angleX, angleY, angleZ);
    }

    public void transit(double dx, double dy, double dz) {
        for (Point point : points) {
            GeometricOperations.transit(point, dx, dy, dz);
        }
        GeometricOperations.transit(center, dx, dy, dz);
    }

    public void scale(double sx, double sy, double sz) {
        for (Point point : points) {
            GeometricOperations.scale(point, sx, sy, sz);
        }
        GeometricOperations.scale(center, sx, sy, sz);
    }

    public void reset() {
        for (Point point : points) {
            point.resetCoordinates();
        }
        center.resetCoordinates();
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }


    public void setAxonometric(double psi, double fi) {
        this.teta = psi;
        this.fi = fi;
    }

    public void setOblique(double l, double a) {
        this.d = l;
        this.ro = a;
    }

    public void setPerspective(double d, double ro, double fi, double teta) {
        this.d = d;
        this.ro = ro;
        this.fi = fi;
        this.teta = teta;
    }

    public void setProjectionMode(byte projectionMode) {
        this.projectionMode = projectionMode;
    }

    public byte getProjectionPlane() {
        return projectionPlane;
    }

    public void setProjectionPlane(byte projectionPlane) {
        this.projectionPlane = projectionPlane;
    }

    public void setDeleteInvisible(boolean deleteInvisible) {
        isDeleteInvisible = deleteInvisible;
    }

    public Point getLight() {
        return light;
    }

    public void setLight(Point light) {
        this.light = light;
    }

    public void setLightOn(boolean lightOn) {
        isLightOn = lightOn;
    }

    public Face[] getFaces() {
        return faces;
    }

    public void setFaces(Face[] faces) {
        this.faces = faces;
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public boolean isDeleteInvisible() {
        return isDeleteInvisible;
    }

    public double getAmbientLight() {
        return 255 * ambientLight;
    }

    public void setAmbientLight(double ambientLight) {
        this.ambientLight = ambientLight;
    }

    public double getDiffisedLight() {
        return 255 * diffisedLight;
    }

    public void setDiffisedLight(double diffisedLight) {
        this.diffisedLight = diffisedLight;
    }
}
