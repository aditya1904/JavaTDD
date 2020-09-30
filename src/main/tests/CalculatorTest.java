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

    }

    @Test
    public void calculateWhenMoreThanTwoNumbers(){
        Calculator calc = new Calculator();
        assert calc.Add("1,2,3") == 6;
        assert calc.Add("4,48,3,73,1,79,77,49,63,16") == 413;
        assert calc.Add("1,2,3,5,10") == 21;
        assert calc.Add("1\n" +
                "2,3") == 6;
    }

    @Test
    public void calculateWhenNumbersOnNewlines() {
        Calculator calc = new Calculator();
        // One New Line
        assert calc.Add("1\n" +
                "2,3") == 6;

        // Multiple New Lines
        assert calc.Add("1\n" +
                "2\n" +
                "3\n" +
                "4") == 10;

        // Start with a new line
        assert calc.Add("\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4") == 10;

        // Multiple numbers on multiple lines
        assert calc.Add("1\n" +
                "2,5\n" +
                "3,6\n" +
                "4\n" +
                "7,8,9") == 45;
    }

    @Test
    public void testOtherDelimiters() {
        Calculator calc = new Calculator();
        assert calc.Add("1\n" +
                "2\n" +
                "3\n" +
                "4") == 10;


        assert calc.Add("//;\n" +
                "1\n" +
                "2;5\n" +
                "3;6\n" +
                "4\n" +
                "7;8;9") == 45;

        assert calc.Add("//%%\n" +
                "1%%\n" +
                "2%%5\n" +
                "3%%6\n" ) == 17;
    }

    @Test
    public void testNegativesNotAllowed(){
        Calculator calc = new Calculator();
        // Test for Negative numbers
        try {
            assert calc.Add("-1,-2") == -3;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().contains("negatives not allowed -1, -2");
        }

        try {
            assert calc.Add("//%%\n" +
                    "1%%\n" +
                    "2%%-5\n" +
                    "3%%6\n" ) == 12;
        } catch (IllegalArgumentException e) {
            assert e.getMessage().contains("negatives not allowed -5");
        }
    }



}
