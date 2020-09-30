package home;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Calculator {

    public int Add(String numbers) {
        if (isNullOrEmpty(numbers))
            return 0;
        String delim = findDelimiter(numbers);
        List<Integer> integers = Arrays.stream(numbers.
                replaceAll("//" + delim, "").
                split("[" + delim + "|\n]"))
                .filter(str -> !isNullOrEmpty(str))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> negatives = integers.stream().filter(num -> (num < 0)).collect(Collectors.toList());

        if (negatives.isEmpty()) {
            Optional<Integer> sum = integers.stream()
                    .filter(num -> num <= 1000)
                    .reduce((x, y) -> x + y);
            return sum.orElse(0);
        } else {
            throw new IllegalArgumentException("negatives not allowed " + negatives.stream()
                    .map(Object::toString).collect(Collectors.joining(", ")));
        }
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
