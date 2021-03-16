import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import Calculator.Calculator;

public class CalculatorTest {
    Calculator calculator ;

    private static final double DELTA = 1e-15;
    @Before
    public void beforeTest(){
        this.calculator = new Calculator();
    }


    @Test
    public void testSquareRoot() {
        assertEquals("Checking true positive case for square root:", 9, calculator.squareRoot(81), DELTA);
        assertNotEquals("Checking false positive case for square root:", 25, calculator.squareRoot(81), DELTA);
    }


    @Test
    public void squareRootException() throws IllegalArgumentException{
        calculator.squareRoot(-9);
    }


    @Test
    public void testFactorial() {
        assertEquals("Checking true positive case for factorial:", 24, calculator.factorial(4), DELTA);
        assertNotEquals("Checking false positive case for factorial:", 24, calculator.factorial(3), DELTA);
    }


    @Test
    public void factorialTestException() throws IllegalArgumentException{
        calculator.factorial(-9);
    }


    @Test
    public void testLogarithm() {
        assertEquals("Checking true positive case for logarithm:", 6.907755278982137, calculator.naturalLog(1000), DELTA);
        assertNotEquals("Checking false positive case for logarithm:", 4, calculator.naturalLog(1000), DELTA);
    }

    @Test
    public void logTestException() throws IllegalArgumentException{
        calculator.naturalLog(-9);
    }

    @Test
    public void testPower() {
        assertEquals("Checking true positive case for power:", 1000, calculator.power(10, 3), DELTA);
        assertNotEquals("Checking false positive case for power:", 100, calculator.power(10, 3), DELTA);
    }

    @Test
    public void powerTestException() throws IllegalArgumentException{
        calculator.power(-9, 1);
    }
}
