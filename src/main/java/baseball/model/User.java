package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class User {
    private List<Integer> numbers;

    public User() {
        this.numbers = new ArrayList<>();
    }
    public List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
