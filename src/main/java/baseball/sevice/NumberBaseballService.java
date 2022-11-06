package baseball.sevice;

import baseball.domain.ComputerNumber;
import baseball.repository.NumberBaseballRepository;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballService {
    private static final int ASCII_ZERO = 48;
    private static final int ASCII_ONE = 49;
    private static final int ASCII_NINE = 57;
    private static final int CORRECT_LENGTH = 3;
    private static final int FIRST_NUMBER = 0;
    private static final int SECOND_NUMBER = 1;
    private static final int THIRD_NUMBER = 2;
    public static final String NUMERIC_INPUT_ERROR = "1 ~ 9사이의 숫자만 입력해야 합니다.";
    public static final String NUMERIC_LENGTH_ERROR = "3글자의 숫자를 입력해야 합니다.";
    private static final String SAME_NUMBER_ERROR = "3개의 숫자는 모두 달라야 합니다.";

    private NumberBaseballRepository numberBaseballRepository = NumberBaseballRepository.getInstance();


    public void initNumber() {
        numberBaseballRepository.generateComputerNumber();
    }

    public List<Integer> inputUserAnswer(String userAnswer) {
        validateUserAnswer(userAnswer);
        List<Integer> userAnswerResultList = new ArrayList<>();
        userAnswerResultList.add(getStrikeCount(numberBaseballRepository.findComputerNumber(), userAnswer));
        userAnswerResultList.add(getBallCount(numberBaseballRepository.findComputerNumber(), userAnswer));

        return userAnswerResultList;
    }

    public int getBallCount(ComputerNumber computerNumber, String userAnswer) {
        int ballCount = 0;
        if (userAnswer.charAt(FIRST_NUMBER) - ASCII_ZERO == computerNumber.getSecondNumber()
                || userAnswer.charAt(FIRST_NUMBER) - ASCII_ZERO == computerNumber.getThirdNumber()) {
            ballCount++;
        }
        if (userAnswer.charAt(SECOND_NUMBER) - ASCII_ZERO == computerNumber.getFirstNumber()
                || userAnswer.charAt(SECOND_NUMBER) - ASCII_ZERO == computerNumber.getThirdNumber()) {
            ballCount++;
        }
        if (userAnswer.charAt(THIRD_NUMBER) - ASCII_ZERO == computerNumber.getFirstNumber()
                || userAnswer.charAt(THIRD_NUMBER) - ASCII_ZERO == computerNumber.getSecondNumber()) {
            ballCount++;
        }
        return ballCount;
    }

    public int getStrikeCount(ComputerNumber computerNumber, String userAnswer) {
        int strikeCount = 0;
        if (computerNumber.getFirstNumber() == userAnswer.charAt(FIRST_NUMBER) - ASCII_ZERO) {
            strikeCount++;
        }
        if (computerNumber.getSecondNumber() == userAnswer.charAt(SECOND_NUMBER) - ASCII_ZERO) {
            strikeCount++;
        }
        if (computerNumber.getThirdNumber() == userAnswer.charAt(THIRD_NUMBER) - ASCII_ZERO) {
            strikeCount++;
        }
        return strikeCount;
    }

    public void validateUserAnswer(String userAnswer) {
        if (!checkNumber(userAnswer)) {
            throw new IllegalArgumentException(NUMERIC_INPUT_ERROR);
        }
        if (!checkLength(userAnswer)) {
            throw new IllegalArgumentException(NUMERIC_LENGTH_ERROR);
        }
        if (!checkSameNumber(userAnswer)) {
            throw new IllegalArgumentException(SAME_NUMBER_ERROR);
        }
    }

    private boolean checkSameNumber(String userAnswer) {
        if (userAnswer.charAt(FIRST_NUMBER) == userAnswer.charAt(SECOND_NUMBER)
                || userAnswer.charAt(FIRST_NUMBER) == userAnswer.charAt(THIRD_NUMBER)
                || userAnswer.charAt(SECOND_NUMBER) == userAnswer.charAt((THIRD_NUMBER))) {
            return false;
        }
        return true;
    }

    private boolean checkLength(String userAnswer) {
        return userAnswer.length() == CORRECT_LENGTH;
    }

    private boolean checkNumber(String userAnswer) {
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
