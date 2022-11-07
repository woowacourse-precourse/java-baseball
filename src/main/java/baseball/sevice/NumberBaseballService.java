package baseball.sevice;

import static baseball.enums.AsciiType.ASCII_ZERO;

import baseball.domain.ComputerNumber;
import baseball.repository.NumberBaseballRepository;
import baseball.validator.UserAnswerValidator;
import java.util.ArrayList;
import java.util.List;

public class NumberBaseballService {
    private static final int FIRST_NUMBER = 0;
    private static final int SECOND_NUMBER = 1;
    private static final int THIRD_NUMBER = 2;

    private final NumberBaseballRepository numberBaseballRepository = NumberBaseballRepository.getInstance();
    private final UserAnswerValidator userAnswerValidator = new UserAnswerValidator();

    public void initNumber() {
        numberBaseballRepository.generateComputerNumber();
    }

    public List<Integer> inputUserAnswer(String userAnswer) {
        userAnswerValidator.validateUserAnswer(userAnswer);
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
}
