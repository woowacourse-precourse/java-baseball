package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Console;

public class Player {

    private List<Integer> threeDifferentNumbers;

    public List<Integer> createThreeDifferentNumbers() {
        threeDifferentNumbers = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        checkValidation(input);
        splitToDigits(input);
        return threeDifferentNumbers;
    }

    public void splitToDigits(String input) {
        for (char character : input.toCharArray()) {
            Integer number = Character.getNumericValue(character);
            threeDifferentNumbers.add(number);
        }
    }

    public void checkValidation(String input) {
        if (!isThreeNumbers(input) || !isAllDifferent(input)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isThreeNumbers(String input) {
        final String VALID_NUMBER_REGEX = "[1-9]{3}";
        return input.matches(VALID_NUMBER_REGEX);
    }

    public boolean isAllDifferent(String input) {
        Set<Character> strToSet = new HashSet<>();
        for (char character : input.toCharArray()) {
            strToSet.add(character);
        }
        return strToSet.size() == 3;
    }
}
