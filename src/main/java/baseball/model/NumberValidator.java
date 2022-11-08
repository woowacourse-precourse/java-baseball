package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.model.ValidateNumber.*;

public class NumberValidator {

    public static boolean checkIfIsNotDuplicatedNum(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    public static List<Integer> convertStringToList(String startInput) {
        return startInput
                .chars()
                .map(i -> Integer.parseInt(String.valueOf(i)))
                .boxed()
                .collect(Collectors.toList());
    }

    public static boolean isValidRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> FIRST_NUMBER.getNumber() <= number
                && number <= LAST_NUMBER.getNumber());
    }
}
