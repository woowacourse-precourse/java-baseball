package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private List<Integer> userInputNumbers;

    public List<Integer> getUserInputNumbers() {
        return userInputNumbers;
    }

    public void selectUserNumber() {
        userInputNumbers = List.copyOf(stringListToIntList());
    }

    private static List<Integer> stringListToIntList() {
        return stringToList().stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<String> stringToList() {
        return Arrays.asList(InputView.selectUserNumberInput().split(""));
    }
}
