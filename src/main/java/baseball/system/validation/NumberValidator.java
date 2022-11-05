package baseball.system.validation;

import baseball.vo.Answer;
import baseball.vo.UserNumber;

import java.util.Collections;
import java.util.List;

public class NumberValidator implements Validator<List<Integer>> {
    public static final String DUPLICATING_NUMBER_MESSAGE = "입력한 숫자는 서로 중복되지 않아야 합니다.";
    public static final String INVALID_NUMBER_LIST_SIZE_MESSAGE_FORMAT = "%d개의 숫자를 입력해야 합니다.";
    public static final String INVALID_NUMBER_RANGE_MESSAGE_FORMAT = "입력값은 %d 이상 %d 이하의 자연수여야 합니다.";

    @Override
    public boolean supports(Object target, Class<?> to) {
        return target instanceof List && (to == UserNumber.class || to == Answer.class);
    }

    @Override
    public void validate(List<Integer> target) {
        target.forEach(number -> isNumberBetWeen1And9(number));
        isListSize3(target);
        isNumbersHavingDuplication(target);
    }

    private void isNumbersHavingDuplication(List<Integer> target) {
        target.forEach(number -> {
            if (Collections.frequency(target, number) != 1) {
                throw new IllegalArgumentException(DUPLICATING_NUMBER_MESSAGE);
            }
        });
    }

    private void isListSize3(List<Integer> target) {
        if (target.size() != Answer.ANSWER_LIST_SIZE) {
            throw new IllegalArgumentException(String.format(
                    INVALID_NUMBER_LIST_SIZE_MESSAGE_FORMAT,
                    Answer.ANSWER_LIST_SIZE
            ));
        }
    }

    private void isNumberBetWeen1And9(Integer target) {
        if (target < Answer.MIN_ANSWER_VALUE || Answer.MAX_ANSWER_VALUE < target) {
            throw new IllegalArgumentException(String.format(
                    INVALID_NUMBER_RANGE_MESSAGE_FORMAT,
                    Answer.MIN_ANSWER_VALUE,
                    Answer.MAX_ANSWER_VALUE
            ));
        }
    }
}
