package baseball.view.scanner;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class NumberScanner {

    public String inputNumber() {
        String inputValue = readLine();
        validateItIsNumber(inputValue);

        return inputValue;
    }

    public String inputOneOrTwo() {
        String inputValue = readLine();
        validateOneOrTwo(inputValue);

        return inputValue;
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    private void validateItIsNumber(String inputValue) {
        final String REGEX_FOR_ONLY_NUMBER = "\\d+";
        if (!inputValue.matches(REGEX_FOR_ONLY_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }

    private void validateOneOrTwo(String inputValue) {
        if (!(inputValue.equals("1") || inputValue.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요. (게임 재시작 : 1 / 게임 종료 : 2)");
        }
    }
}
