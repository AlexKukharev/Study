package mainPackage.geometry;

import java.util.Scanner;

public class Calc {
    public int Sum(int x, int y) {
        if (x > 0 && y > 0) {
            return x + y;
        } else {
            return x - y;
        }
    }

    public int Factorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public int Mult(int a, int b) {
        for (int i = 0; i < b-1; i++)
            a *= a;
        return a;
    }
}
