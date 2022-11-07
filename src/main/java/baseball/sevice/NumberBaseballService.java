package baseball.sevice;

import static baseball.enums.AsciiType.ASCII_NINE;
import static baseball.enums.AsciiType.ASCII_ONE;
import static baseball.enums.AsciiType.ASCII_ZERO;

import baseball.domain.ComputerNumber;
import baseball.exception.ErrorMessage;
import baseball.repository.NumberBaseballRepository;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballService {
    private static final int CORRECT_LENGTH = 3;
    private static final int FIRST_NUMBER = 0;
    private static final int SECOND_NUMBER = 1;
    private static final int THIRD_NUMBER = 2;

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
        if (userAnswer.charAt(FIRST_NUMBER) - ASCII_ZERO.getAsciiNumber() == computerNumber.getSecondNumber()
                || userAnswer.charAt(FIRST_NUMBER) - ASCII_ZERO.getAsciiNumber() == computerNumber.getThirdNumber()) {
            ballCount++;
        }
        if (userAnswer.charAt(SECOND_NUMBER) - ASCII_ZERO.getAsciiNumber() == computerNumber.getFirstNumber()
                || userAnswer.charAt(SECOND_NUMBER) - ASCII_ZERO.getAsciiNumber() == computerNumber.getThirdNumber()) {
            ballCount++;
        }
        if (userAnswer.charAt(THIRD_NUMBER) - ASCII_ZERO.getAsciiNumber() == computerNumber.getFirstNumber()
                || userAnswer.charAt(THIRD_NUMBER) - ASCII_ZERO.getAsciiNumber() == computerNumber.getSecondNumber()) {
            ballCount++;
        }
        return ballCount;
    }

    public int getStrikeCount(ComputerNumber computerNumber, String userAnswer) {
        int strikeCount = 0;
        if (computerNumber.getFirstNumber() == userAnswer.charAt(FIRST_NUMBER) - ASCII_ZERO.getAsciiNumber()) {
            strikeCount++;
        }
        if (computerNumber.getSecondNumber() == userAnswer.charAt(SECOND_NUMBER) - ASCII_ZERO.getAsciiNumber()) {
            strikeCount++;
        }
        if (computerNumber.getThirdNumber() == userAnswer.charAt(THIRD_NUMBER) - ASCII_ZERO.getAsciiNumber()) {
            strikeCount++;
        }
        return strikeCount;
    }

    public void validateUserAnswer(String userAnswer) {
        if (!checkNumber(userAnswer)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_INPUT_EXCEPTION
                    .getMessage());
        }
        if (!checkLength(userAnswer)) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_LENGTH_EXCEPTION
                    .getMessage());
        }
        if (!checkSameNumber(userAnswer)) {
            throw new IllegalArgumentException(ErrorMessage.SAME_NUMBER_EXCEPTION
                    .getMessage());
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
        if (userAnswer.charAt(FIRST_NUMBER) < ASCII_ONE.getAsciiNumber()
                || userAnswer.charAt(FIRST_NUMBER) > ASCII_NINE.getAsciiNumber()) {
            return false;
        }
        if (userAnswer.charAt(SECOND_NUMBER) < ASCII_ONE.getAsciiNumber()
                || userAnswer.charAt(SECOND_NUMBER) > ASCII_NINE.getAsciiNumber()) {
            return false;
        }
        if (userAnswer.charAt(THIRD_NUMBER) < ASCII_ONE.getAsciiNumber()
                || userAnswer.charAt(THIRD_NUMBER) > ASCII_NINE.getAsciiNumber()) {
            return false;
        }
        return true;
    }
}
