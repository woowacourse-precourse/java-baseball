package baseball.service;

import static baseball.type.NumberType.NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.Validation;
import java.util.ArrayList;
import java.util.List;

public class UserNumberService {

    public static List<Integer> generate() {
        List<Integer> userNumbers = new ArrayList<>();
        String inputNumber = readLine();

        Validation.validate(inputNumber);

        for (int index = 0; index < NUMBER_SIZE.getValue(); index++) {
            int numberToInt = inputNumber.charAt(index) - '0';
            userNumbers.add(numberToInt);
        }

        return userNumbers;
    }
}
