package home;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Calculator {

//    Allow the Add method to handle an unknown amount of numbers
    public int Add(String numbers) {
        if (isNullOrEmpty(numbers))
            return 0;
        Optional<Integer> sum = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .reduce((x, y) -> x + y);
        return sum.orElse(0);
    }

    private boolean isNullOrEmpty(String str) {
        if(str==null) return true;
        return str.length() == 0;
    }
}
