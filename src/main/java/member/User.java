package member;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class User {
    private static final int STARTING_INDEX = 0;
    private static final int MAX_LENGTH_OF_NUMBER = 3;
    private final List<Integer> numbers = new ArrayList<>();

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (!isCorrectRange(input) || !isUniqueDigits(input)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다. 게임 종료");
        }

        setNumbers(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(String input) {

        for (int index = STARTING_INDEX; index < MAX_LENGTH_OF_NUMBER; index++) {
            numbers.add(Character.getNumericValue(input.charAt(index)));
        }
    }

    public void clearNumbers() {
        numbers.clear();
    }

    private boolean isCorrectRange(String inputNumber) {
        String pattern = "[1-9]{1,3}";

        return Pattern.matches(pattern, inputNumber);
    }

    private boolean isUniqueDigits(String inputNumber) {
        List<Integer> checkNumbers = new ArrayList<>();

        for (int i = STARTING_INDEX; i < MAX_LENGTH_OF_NUMBER; i++) {

            if (checkNumbers.contains(Character.getNumericValue(inputNumber.charAt(i)))) {
                return false;
            }
            checkNumbers.add(Character.getNumericValue(inputNumber.charAt(i)));
        }

        return true;
    }
}
