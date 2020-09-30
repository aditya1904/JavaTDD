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

    @Test
    public void calculateWhenMoreThanTwoNumbers(){
        Calculator calc = new Calculator();
        assert calc.Add("1,2,3") == 6;
        assert calc.Add("4,48,3,73,1,79,77,49,63,16") == 413;
        assert calc.Add("1,2,3,5,10") == 21;
    }

}
