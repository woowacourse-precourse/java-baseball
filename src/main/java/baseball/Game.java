package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_GUIDE = "숫자를 입력해주세요 : ";
    public static final String INVALID_INPUT_LENGTH = "숫자를 3개 입력해야 합니다.";
    public static final String INVALID_INPUT_TYPE = "숫자만 입력해야 합니다.";
    public static final String DUPLICATE_INPUT_NUMBER = "중복된 수를 입력할 수 없습니다.";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NEW_LINE = System.lineSeparator();
    public static final String BLANK = " ";

    public List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        do {
            int number = Randoms.pickNumberInRange(1, 9);
            addUniqueNumber(numbers, number);
        } while (numbers.size() < 3);
        return numbers;
    }

    public void addUniqueNumber(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public void input() {
        String inputNumbers = Console.readLine();
        validate(inputNumbers);
    }

    public void validate(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.length() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH);
        }
        try {
            Integer.parseInt(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
        if (hasDuplicateNumber(inputNumbers)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER);
        }
    }

    public boolean hasDuplicateNumber(String inputNumbers) {
        return inputNumbers.charAt(0) == inputNumbers.charAt(1) || inputNumbers.charAt(1) == inputNumbers.charAt(2)
                || inputNumbers.charAt(0) == inputNumbers.charAt(2);
    }

    public String printResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }
        if (strikeCount == 3) {
            return strikeCount + STRIKE + NEW_LINE + GAME_OVER;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }
}
