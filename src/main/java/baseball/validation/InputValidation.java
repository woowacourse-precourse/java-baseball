package baseball.validation;

import java.util.List;
import java.util.regex.Pattern;

import static baseball.constant.MessageConst.*;
import static baseball.constant.NumberConst.*;

/**
 * 입력값에 대한 검증을 진행하는 클래스
 */
public class InputValidation {

    /**
     * 입력값의 길이가 3인지 검증한다.
     * @param input 사용자의 입력값
     */
    public void verifyInputLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION_MSG);
        }
    }

    /**
     * 입력값이 1~9 사이의 숫자인지 검증한다.
     * @param input 사용자의 입력값
     */
    public void verifyInputRange(String input) {
        String regex = "^[1-9]";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MSG);
        }
    }

    /**
     * 입력값에 중복된 값이 존재하는지 검증한다.
     * @param inputNums 사용자의 입력값의 각 자리를 쪼갠 리스트
     */
    public void verifyInputDuplicated(List<Integer> inputNums) {
        if (inputNums.stream().distinct().count() != INPUT_LENGTH) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION_MSG);
        }
    }

    /**
     * 게임 진행을 제어하는 입력값에 대해 검증한다.
     * @param input 사용자의 입력값
     */
    public void verifyGameControlInput(Integer input) {
        if (!input.equals(RESTART_NUM) || !input.equals(EXIT_NUM)) {
            throw new IllegalArgumentException(GAME_CONTROL_EXCEPTION_MSG);
        }
    }
}
