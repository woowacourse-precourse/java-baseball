package baseball.players;

import static baseball.settings.Constants.*;

import baseball.settings.Validator;
import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class User {
    public static List<Integer> createThreeDigitNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
        String enteredNumber = Console.readLine();

        Validator.check(enteredNumber);
        List<Integer> digits = splitToDigits(enteredNumber);
        return digits;
    }

    public static List<Integer> splitToDigits(String number) {
        List<Integer> digits = new ArrayList<>();

        for (char digit : number.toCharArray()) {
            Integer numericValue = Character.getNumericValue(digit);
            digits.add(numericValue);
        }
        return digits;
    }
}
