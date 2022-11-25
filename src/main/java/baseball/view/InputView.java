package baseball.view;

import static baseball.util.NumberValidator.getValidUserNumber;
import static baseball.util.NumberValidator.validateLength;
import static baseball.util.NumberValidator.validateType;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public List<Integer> readUserNumber() {
        List<Integer> userNumber = new ArrayList<>();
        while (userNumber.isEmpty()) {
            userNumber = getValidUserNumber(Console.readLine());
        }
        return userNumber;
    }

    private static List<Integer> getValidUserNumber(String input) {
        try {
            validateLength(input);
            validateType(input);
        } catch (IllegalArgumentException e) {
            System.out.printf(e.getMessage());
            return new ArrayList<>();
        }
        return Arrays.stream(input.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
