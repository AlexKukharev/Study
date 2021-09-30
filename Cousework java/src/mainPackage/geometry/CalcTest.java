package mainPackage.geometry;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void ParametricOperations() {
        int x = 10;
        int y = 20;
        int expected = 30;

        Calc c = new Calc();
        int actual = c.Sum(x,y);
        Assert.assertEquals(expected,actual);

    }

    @Test
    void ParametricOperations1() {
        int x = -5;
        int y = -2;
        int expected = -3;

        Calc c = new Calc();
        int actual = c.Sum(x,y);
        Assert.assertEquals(expected,actual);

    }

    @Test
    void Factorial(){
        int f =5;
        int expected = 120;
        Calc c = new Calc();
        int actual = c.Factorial(5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void Factorial1(){
        int f =0;
        int expected = 1;
        Calc c = new Calc();
        int actual = c.Factorial(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    void Mult(){
        int a = 5;
        int b = 1;
        int expected = 5;
        Calc c = new Calc();
        int actual = c.Mult(a,b);
        Assert.assertEquals(expected,actual);
    }


}
