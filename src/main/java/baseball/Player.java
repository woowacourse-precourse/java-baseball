package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {
    private static final int MAX_STRIKE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_PATTERN = "^[" + MIN_NUMBER + "-" + MAX_NUMBER + "]*$";

    public String[] number;

    public String[] getNumber() {
        return this.number;
    }

    public void setNumber() {
        System.out.print(INPUT_MESSAGE);
        String[] input = readLine().split("");
        isValidInput(input);
        this.number = input;
    }

    private void isValidInput(String[] input) {
        if (!isRightLength(input) || isDuplicated(input) || !isDigitRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRightLength(String[] input) {
        return input.length == MAX_STRIKE;
    }

    private boolean isDuplicated(String[] input) {
        Set<String> stringCharSet = new HashSet<>(Arrays.asList(input));
        return stringCharSet.size() != MAX_STRIKE;
    }

    private boolean isDigitRange(String[] input) {
        Pattern pattern = Pattern.compile(INPUT_PATTERN);
        return Arrays.stream(input).allMatch(s -> pattern.matcher(s).matches());
    }
}
