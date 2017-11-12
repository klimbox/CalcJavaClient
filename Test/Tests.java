import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    calculate calc;
    @Test
    public void testCalcPlus()
    {
        calc = new calculate();
        String res;
        try {
            res = calc.sendPost(5, 2, "+");
        }
        catch (Exception ie){
            return;
        }
        assertEquals("7", res, 0.001);

    }
    @Test
    public void testCalcMinus() {
        calc = new calculate();
        String res;
        try {
            res = calc.sendPost(5, 2, "-");
        }
        catch (Exception ie){
            return;
        }
        assertEquals("3", res, 0.001);
    }
    @Test
    public void testCalcDiv() {
        calc = new calculate();
        String res;
        try {
            res = calc.sendPost(6, 2, "/");
        }
        catch (Exception ie){
            return;
        }
        assertEquals("3", res, 0.001);
    }
    @Test
    public void testCalcMult() {
        calc = new calculate();
        String res;
        try {
            res = calc.sendPost(5, 2, "*");
        }
        catch (Exception ie){
            return;
        }
        assertEquals("10", res, 0.001);
    }

}
