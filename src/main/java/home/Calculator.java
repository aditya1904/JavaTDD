package home;

public class Calculator {

//  The method can take up to two numbers, separated by commas, and will return their sum.
//  for example “” or “1” or “1,2” as inputs.
//  (for an empty string it will return 0)
    public int Add(String numbers) {
        if (isNullOrEmpty(numbers))
            return 0;
        if (numbers.split(",").length > 2) {
            throw new IllegalArgumentException("More than 2 numbers. Cannot Compute");
        }
        int sum = 0;
        for (String num : numbers.split(",")) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private boolean isNullOrEmpty(String str) {
        if(str==null) return true;
        return str.length() == 0;
    }
}
