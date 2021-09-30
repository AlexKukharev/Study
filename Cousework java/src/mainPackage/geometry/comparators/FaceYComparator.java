package mainPackage.geometry.comparators;

import mainPackage.geometry.Face;
import mainPackage.geometry.Point;

import java.util.Comparator;

public class FaceYComparator implements Comparator<Face> {
    @Override
    public int compare(Face o1, Face o2) {
        int y1 = 0, y2 = 0;
        int n = 0;
        for (Point v : o1.getPoints()) {
            y1 += v.getY();
            n++;
        }
        y1 = y1 / n;
        n = 0;
        for (Point v : o2.getPoints()) {
            y2 += v.getY();
            n++;
        }
        y2 = y2 / n;
        return y2 - y1;
    }
}
