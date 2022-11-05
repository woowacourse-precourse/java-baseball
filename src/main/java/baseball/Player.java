package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private List<Integer> threeDifferentNumbers;

    public List<Integer> createThreeDifferentNumbers() {
        threeDifferentNumbers = new ArrayList<>();
        System.out.print(ENTER_NUMBERS_MESSAGE);
        String enteredNumbers = Console.readLine();

        Validator.check(enteredNumbers);
        splitToDigits(enteredNumbers);
        return threeDifferentNumbers;
    }

    public void splitToDigits(String numbers) {
        for (char character : numbers.toCharArray()) {
            Integer numericValue = Character.getNumericValue(character);
            threeDifferentNumbers.add(numericValue);
        }
    }
}
