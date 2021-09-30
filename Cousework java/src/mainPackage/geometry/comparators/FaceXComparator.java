package mainPackage.geometry.comparators;

import mainPackage.geometry.Face;
import mainPackage.geometry.Point;

import java.util.Comparator;

public class FaceXComparator implements Comparator<Face> {
    @Override
    public int compare(Face o1, Face o2) {
        int x1 = 0, x2 = 0;
        int n = 0;
        for (Point v : o1.getPoints()) {
            x1 += v.getX();
            n++;
        }
        x1 = x1 / n;
        n = 0;
        for (Point v : o2.getPoints()) {
            x2 += v.getX();
            n++;
        }
        x2 = x2 / n;
        return x2 - x1;
    }
}
