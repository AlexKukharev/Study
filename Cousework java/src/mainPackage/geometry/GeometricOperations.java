package mainPackage.geometry;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class GeometricOperations {

    public static void transit(Point point, double dx, double dy, double dz) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createTransitMatr(dx, dy, dz)));
    }

    public static void scale(Point point, double sx, double sy, double sz) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createScaleMatr(sx, sy, sz)));
    }

    public static void rotate(Point point, double angleX, double angleY, double angleZ) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createRotateMatr(angleX, angleY, angleZ)));
    }

    public static void perspective(Point point, double d, double ro, double fi, double teta) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createViewMatr(ro, fi, teta)));
        point.setCoordinates(new double[][]{{-point.getY(), point.getX(), point.getZ(), 1}});
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createPerspectiveMatr(d)));
        point.setCoordinates(new double[][]{{point.getX() / point.getLast(), point.getY() / point.getLast(),
                point.getZ() / point.getLast(), 1}});
    }

    public static void oblique(Point point, double l, double a) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createObliqueMatr(l, a)));
    }

    public static void axonometric(Point point, double psi, double fi) {
        point.setCoordinates(multiplyByMatrix(point.getCoordinates(), createAxonometricMatr(psi, fi)));
    }

    private static double[][] createTransitMatr(double dx, double dy, double dz) {
        double[][] T = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {dx, dy, dz, 1}};
        return T;
    }

    private static double[][] createScaleMatr(double sx, double sy, double sz) {
        double[][] S = {
                {sx, 0, 0, 0},
                {0, sy, 0, 0},
                {0, 0, sz, 0},
                {0, 0, 0, 1}};
        return S;
    }

    private static double[][] createRotateMatr(double angleX, double angleY, double angleZ) {
        double[][] ROx = {
                {1.0, 0, 0, 0},
                {0, Math.cos(angleX), Math.sin(angleX), 0},
                {0, -Math.sin(angleX), Math.cos(angleX), 0},
                {0, 0, 0, 1.0}};
        double[][] ROy = {
                {Math.cos(angleY), 0, -Math.sin(angleY), 0},
                {0, 1.0, 0, 0},
                {Math.sin(angleY), 0, Math.cos(angleY), 0},
                {0, 0, 0, 1.0}};
        double[][] ROz = {
                {Math.cos(angleZ), Math.sin(angleZ), 0, 0},
                {-Math.sin(angleZ), Math.cos(angleZ), 0, 0},
                {0, 0, 1.0, 0},
                {0, 0, 0, 1.0}};
        double[][] R = multiplyByMatrix(ROx, ROy);
        R = multiplyByMatrix(R, ROz);
        return R;
    }

    private static double[][] createPerspectiveMatr(double d) {
        double[][] M = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1 / d},
                {0, 0, 0, 1}};
        return M;
    }

    private static double[][] createViewMatr(double ro, double fi, double teta) {
        double V[][] = {
                {-Math.sin(teta), -Math.cos(fi) * Math.cos(teta), -Math.sin(fi) * Math.cos(teta), 0},
                {Math.cos(teta), -Math.cos(fi) * Math.sin(teta), -Math.sin(fi) * Math.sin(teta), 0},
                {0, Math.sin(fi), Math.cos(fi), 0},
                {0, 0, ro, 1}};
        return V;
    }

    private static double[][] createObliqueMatr(double l, double a) {
        return new double[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {l*cos(a), l*sin(a), 1, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] createAxonometricMatr(double psi, double fi) {
        return new double[][]{
                {cos(psi), sin(fi) * sin(psi), 0, 0},
                {0, cos(fi), 0, 0},
                {sin(psi), -sin(fi) * cos(psi), 1, 0},
                {0, 0, 0, 1}};
    }

    private static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {         // rows from m1
            for (int j = 0; j < mRColLength; j++) {     // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }
}
