package home;

import java.util.Arrays;
import java.util.Optional;

public class Calculator {

    public int Add(String numbers) {
        if (isNullOrEmpty(numbers))
            return 0;
        String delim = findDelimiter(numbers);
        Optional<Integer> sum = Arrays.stream(numbers.
                replaceAll("//" + delim, "").
                split("[" + delim + "|\n]"))
                .filter(str -> !isNullOrEmpty(str))
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y);
        return sum.orElse(0);
    }

    private String findDelimiter(String numbers) {
        String delimiter;
        if (numbers.startsWith("//")) {
            delimiter = numbers.split("\n")[0].replaceAll("//", "");
        } else {
            delimiter = ",";
        }
        return delimiter;
    }

    private boolean isNullOrEmpty(String str) {
        if(str==null) return true;
        return str.length() == 0;
    }
}
