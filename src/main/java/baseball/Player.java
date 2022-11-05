package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final int MAX_STRIKE = 3;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_PATTERN = "^[1-9]*$";

    public String number;

    public String getNumber() {
        return this.number;
    }

    public void setNumber() {
        System.out.print(INPUT_MESSAGE);
        String input = readLine();
        isValidInput(input);
        this.number = input;
    }

    private void isValidInput(String input) {
        if (!isRightLength(input) || isDuplicated(input) || !isDigitRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(String input) {
        Set<Character> stringCharSet = new HashSet<>();
        input.chars().forEach(c -> stringCharSet.add((char) c));

        return stringCharSet.size() != MAX_STRIKE;
    }

    private boolean isDigitRange(String input) {
        return input.matches(INPUT_PATTERN);
    }

    private boolean isRightLength(String input) {
        return input.length() == MAX_STRIKE;
    }
}
