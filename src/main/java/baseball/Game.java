package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INVALID_EXIT_NUMBER = "1 또는 2만 입력해야 합니다.";

    public void init() {
        do {
            start();
            System.out.println(RESTART_OR_EXIT);
        } while (isExit());
    }

    public boolean isExit() {
        String exitNumber = Console.readLine();
        if (Objects.equals(exitNumber, "1")) {
            return true;
        }
        if (Objects.equals(exitNumber, "2")) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_EXIT_NUMBER);
    }

    public void start() {
        List<Integer> randomNumbers = generateRandomNumber();
        String result;
        do {
            System.out.print(INPUT_GUIDE);
            String inputNumbers = input();
            result = judge(inputNumbers, randomNumbers);
            System.out.println(result);
        } while (!result.equals(3 + STRIKE + NEW_LINE + GAME_OVER));
    }

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

    public String input() {
        String inputNumbers = Console.readLine();
        validate(inputNumbers);
        return inputNumbers;
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

    public String judge(String inputNumbers, List<Integer> randomNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < inputNumbers.length(); index++) {
            char number = inputNumbers.charAt(index);

            if (isStrike(number, randomNumbers, index)) {
                strikeCount++;
            } else if (isBall(number, randomNumbers)) {
                ballCount++;
            }
        }
        return printResult(strikeCount, ballCount);
    }

    public boolean isStrike(char number, List<Integer> randomNumbers, int index) {
        return Character.getNumericValue(number) == randomNumbers.get(index);
    }

    public boolean isBall(char number, List<Integer> randomNumbers) {
        return randomNumbers.contains(Character.getNumericValue(number));
    }

    public String printResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        } else if (strikeCount == 3) {
            return strikeCount + STRIKE + NEW_LINE + GAME_OVER;
        } else if (strikeCount == 0) {
            return ballCount + BALL;
        } else if (ballCount == 0) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }
}
