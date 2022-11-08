package baseball.view;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballNumbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_BASEBALL_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_OR_STOP_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBERS_STRING_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다";

    public static BaseballNumbers inputBaseballNumbers() {
        String inputString;
        System.out.println(INPUT_BASEBALL_NUMBERS_MESSAGE);
        inputString = Console.readLine();
        validateInputStringisNumbers(inputString);
        return stringToBaseballNumbers(inputString);
    }

    private static BaseballNumbers stringToBaseballNumbers(String inputString) {

        List<BaseballNumber> baseballNumbers = Arrays.stream(inputString.split(""))
                .map(Integer::parseInt)// 숫자가 아닌 문자가 inputString에 있는경우 예외발생생
                .map(BaseballNumber::new)
                .collect(Collectors.toList());

        return new BaseballNumbers(baseballNumbers);
    }

    private static void validateInputStringisNumbers(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if(!Character.isDigit(inputString.charAt(i))){
                throw new IllegalArgumentException(INPUT_NUMBERS_STRING_EXCEPTION_MESSAGE);
            }
        }
    }
}
