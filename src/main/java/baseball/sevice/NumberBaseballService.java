package baseball.sevice;

import baseball.repository.NumberBaseballRepository;

public class NumberBaseballService {
    private static final int ASCII_ONE = 49;
    private static final int ASCII_NINE = 57;
    private static final int FIRST_NUMBER = 0;
    private static final int SECOND_NUMBER = 1;
    private static final int THIRD_NUMBER = 2;
    public static final String NUMERIC_INPUT_ERROR = "1 ~ 9사이의 숫자만 입력해야 합니다.";

    private NumberBaseballRepository numberBaseballRepository = NumberBaseballRepository.getInstance();


    public void initNumber() {
        numberBaseballRepository.generateComputerNumber();
    }

    public void inputUserAnswer(String userAnswer) {
        validateUserAnswer(userAnswer);

    }

    public void validateUserAnswer(String userAnswer) {
        if (!checkNumber(userAnswer)) {
            throw new IllegalArgumentException(NUMERIC_INPUT_ERROR);
        }
    }

    public boolean checkNumber(String userAnswer) {
        if (userAnswer.charAt(FIRST_NUMBER) < ASCII_ONE
                || userAnswer.charAt(FIRST_NUMBER) > ASCII_NINE) {
            return false;
        }
        if (userAnswer.charAt(SECOND_NUMBER) < ASCII_ONE
                || userAnswer.charAt(SECOND_NUMBER) > ASCII_NINE) {
            return false;
        }
        if (userAnswer.charAt(THIRD_NUMBER) < ASCII_ONE
                || userAnswer.charAt(THIRD_NUMBER) > ASCII_NINE) {
            return false;
        }
        return true;
    }
}
