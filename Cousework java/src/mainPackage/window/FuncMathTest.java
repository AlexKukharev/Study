package mainPackage.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncMathTest {

    @Test
    public void testIsEmpty() {
        boolean actual = FuncMath.isEmpty(null);
        assertTrue(actual);

        actual = FuncMath.isEmpty("");
        assertTrue(actual);

        actual = FuncMath.isEmpty(" ");
        assertFalse(actual);

        actual = FuncMath.isEmpty("some string");
        assertFalse(actual);
    }

    @Test
    void toHexString() {

    }
}
