package baseball.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputToNumbers {

    public static List<Integer> toNumbers(String userNumbersInput) {
        String[] userNumbers = userNumbersInput.split("");
        return Arrays.asList(userNumbers)
            .stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
