package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;
import java.util.Set;

public class Number {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_PATTERN = "^[1-9]*$";

    public String number;

    public Number() {
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber() {
        System.out.print(INPUT_MESSAGE);
        String input = readLine();
        isValidInput(input);
        this.number = input;
    }

    public void setRandomNumber() {
        Set<Character> numberSet = new HashSet<>();
        StringBuilder randomNumber = new StringBuilder();
        while (numberSet.size() != CNT_NUMBER) {
            numberSet.add(getSingleRandomNumber());
        }
        numberSet.forEach(randomNumber::append);
        this.number = String.valueOf(randomNumber);
    }

    private char getSingleRandomNumber() {
        return (char) (pickNumberInRange(MIN_NUMBER, MAX_NUMBER) + '0');
    }

    private void isValidInput(String input) {
        if (!isRightLength(input) || isDuplicated(input) || !isDigitRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(String str) {
        Set<Character> stringCharSet = new HashSet<>();
        str.chars().forEach(c -> stringCharSet.add((char) c));

        return stringCharSet.size() != CNT_NUMBER;
    }

    private boolean isDigitRange(String input) {
        return input.matches(INPUT_PATTERN);
    }

    private boolean isRightLength(String input) {
        return input.length() == CNT_NUMBER;
    }
}
