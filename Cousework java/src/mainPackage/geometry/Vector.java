package mainPackage.geometry;

public class Vector {
    private double coordinates[];

    public Vector(double x, double y, double z) {
        coordinates = new double[]{x, y, z};
    }

    public Vector(Point point1, Point point2, Point point3) {
        double i1 = point2.getX() - point1.getX();
        double i2 = point3.getX() - point1.getX();
        double j1 = point2.getY() - point1.getY();
        double j2 = point3.getY() - point1.getY();
        double k1 = point2.getZ() - point1.getZ();
        double k2 = point3.getZ() - point1.getZ();

        double x = j1 * k2 - k1 * j2;
        double y = k1 * i2 - i1 * k2;
        double z = i1 * j2 - j1 * i2;

        coordinates = new double[]{x, y, z};


    }

    public double cos(Vector v) {
        double len1 = Math.sqrt(this.coordinates[0] * this.coordinates[0]
                + this.coordinates[1] * this.coordinates[1] + this.coordinates[2] * this.coordinates[2]);
        double len2 = Math.sqrt(v.coordinates[0] * v.coordinates[0]
                + v.coordinates[1] * v.coordinates[1] + v.coordinates[2] * v.coordinates[2]);
        double scalar = this.coordinates[0] * v.coordinates[0] + this.coordinates[1] * v.coordinates[1]
                + this.coordinates[2] * v.coordinates[2];
        return scalar / (len1 * len2);

    }
}
