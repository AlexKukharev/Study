package mainPackage.geometry;

public class Building extends Figure {
    private Face[] faces;
    private Point[] points;
    public double r;
    public double R;
    public double h;
    public int n;


    public Building(double r, double R, double h, int n) {
        this.r = r;
        this.R = R;
        this.h = h;
        this.n = n;
        buildPoints();
        buildFaces();
        buildEdges();
    }

    @Override
    public void buildEdges() {
        for (Face f : faces) {
            Point[] points = f.getPoints();
            f.setEdges(new Edge[]{
                    new Edge(points[0], points[1]),
                    new Edge(points[1], points[2]),
                    new Edge(points[2], points[3]),
                    new Edge(points[3], points[0])
            });
        }
    }

    @Override
    public void buildFaces() {
        faces = new Face[n * 4];
        for (int i = 0; i < n - 1; i++) {
            faces[i] = new Face(points[i], points[i + 1], points[i + n + 1], points[i + n]);
            faces[i + n] = new Face(points[i + 2 * n + 1], points[i + 2 * n], points[i + 3 * n], points[i + 3 * n + 1]);
            faces[i + 2 * n] = new Face(points[i], points[i + 2 * n], points[i + 2 * n + 1], points[i + 1]);
            faces[i + 3 * n] = new Face(points[i + n], points[i + n + 1], points[i + 3 * n + 1], points[i + 3 * n]);
        }
        faces[n - 1] = new Face(points[0], points[n], points[2 * n - 1], points[n - 1]);
        faces[2 * n - 1] = new Face(points[2 * n], points[3 * n - 1], points[4 * n - 1], points[3 * n]);
        faces[3 * n - 1] = new Face(points[2 * n], points[0], points[n - 1], points[3 * n - 1]);
        faces[4 * n - 1] = new Face(points[n], points[3 * n], points[4 * n - 1], points[2 * n - 1]);
        super.setFaces(faces);
    }

    public void changeFigureSize(double r, double R, double h, int n) {
        this.r = r;
        this.R = R;
        this.h = h;
        this.n = n;
        buildPoints();
        buildFaces();
        buildEdges();
    }


    @Override
    public void buildPoints() {
        points = new Point[n * 4];
        double angle = Math.toRadians(360.0 / n);
        for (int i = 0; i < n; i++) {
            points[i] = new Point(r * Math.cos(angle * i), h / 2, r * Math.sin(angle * i));
            points[i + n] = new Point(R * Math.cos(angle * i), h / 2, R * Math.sin(angle * i));
            points[i + n * 2] = new Point(r * Math.cos(angle * i), -h / 2, r * Math.sin(angle * i));
            points[i + n * 3] = new Point(R * Math.cos(angle * i), -h / 2, R * Math.sin(angle * i));
        }
        Point center = new Point(0, 0, 0);
        super.setPoints(points);
        super.setCenter(center);
    }

}
