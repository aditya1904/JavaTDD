import home.Calculator;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdditionOfUptoTwoNumbers() {
        Calculator calc = new Calculator();
        // Test for 0 numbers
        int sum1 = calc.Add("");
        assert sum1 == 0;

        // Test for 1 number
        int sum2 = calc.Add("1");
        assert sum2 == 1;

        // Test for 2 numbers
        int sum3 = calc.Add("1,2");
        assert sum3 == 3;
        int sum4 = calc.Add("4,2000000");
        assert sum4 == 2000004;

        // Test for Negative numbers
        int sum5 = calc.Add("-1,-2");
        assert sum5 == -3;
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenMoreThanTwoNumbers(){
        Calculator calc = new Calculator();
        calc.Add("1,2,3");
    }

}
