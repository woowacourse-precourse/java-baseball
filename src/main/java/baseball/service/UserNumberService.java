package baseball.service;

import static baseball.type.NumberType.NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Validation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserNumberService {
    private static List<Integer> userNumbers = new ArrayList<>();

    public static List<Integer> generate() {
        initialize();
        String inputNumber = readLine();

        Validation.validate(inputNumber);

        for (int index = 0; index < NUMBER_SIZE; index++) {
            int numberToInt = inputNumber.charAt(index) - '0';
            userNumbers.add(numberToInt);
        }

        return userNumbers;
    }

    public static void initialize() {
        userNumbers.clear();
    }
}
