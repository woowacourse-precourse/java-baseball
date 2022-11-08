package baseball.sevice;

import static baseball.enums.AsciiCodeStatus.ASCII_ZERO;

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

    public List<Integer> createResultList(String userAnswer) {
        userAnswerValidator.validateUserAnswer(userAnswer);
        List<Integer> userAnswerResultList = new ArrayList<>();
        userAnswerResultList.add(getStrikeCount(numberBaseballRepository.findComputerNumber(), userAnswer));
        userAnswerResultList.add(getBallCount(numberBaseballRepository.findComputerNumber(), userAnswer));
        return userAnswerResultList;
    }

    public int getBallCount(ComputerNumber computerNumber, String userAnswer) {
        return calculateBallCount(computerNumber, userAnswer);
    }

    public int getStrikeCount(ComputerNumber computerNumber, String userAnswer) {
        return calculateStrikeCount(computerNumber, userAnswer);
    }

    private int calculateBallCount(ComputerNumber computerNumber, String userAnswer) {
        int ballCount = 0;
        if (convertCharacterToInteger(userAnswer.charAt(FIRST_NUMBER)) == computerNumber.getSecondNumber()
                || convertCharacterToInteger(userAnswer.charAt(FIRST_NUMBER)) == computerNumber.getThirdNumber()) {
            ballCount++;
        }
        if (convertCharacterToInteger(userAnswer.charAt(SECOND_NUMBER)) == computerNumber.getFirstNumber()
                || convertCharacterToInteger(userAnswer.charAt(SECOND_NUMBER)) == computerNumber.getThirdNumber()) {
            ballCount++;
        }
        if (convertCharacterToInteger(userAnswer.charAt(THIRD_NUMBER)) == computerNumber.getFirstNumber()
                || convertCharacterToInteger(userAnswer.charAt(THIRD_NUMBER)) == computerNumber.getSecondNumber()) {
            ballCount++;
        }
        return ballCount;
    }

    private int calculateStrikeCount(ComputerNumber computerNumber, String userAnswer) {
        int strikeCount = 0;
        if (computerNumber.getFirstNumber() == convertCharacterToInteger(userAnswer.charAt(FIRST_NUMBER))) {
            strikeCount++;
        }
        if (computerNumber.getSecondNumber() == convertCharacterToInteger(userAnswer.charAt(SECOND_NUMBER))) {
            strikeCount++;
        }
        if (computerNumber.getThirdNumber() == convertCharacterToInteger(userAnswer.charAt(THIRD_NUMBER))) {
            strikeCount++;
        }
        return strikeCount;
    }

    private int convertCharacterToInteger(char characterToConvert) {
        return characterToConvert - ASCII_ZERO.getAsciiNumber();
    }
}
