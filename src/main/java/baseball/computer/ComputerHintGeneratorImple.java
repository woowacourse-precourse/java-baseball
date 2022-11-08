package baseball.computer;

import baseball.computer.constant.Notice;

import java.util.List;

import static baseball.computer.constant.MagicNumber.NUMBERS_MAX_LENGTH;

public class ComputerHintGeneratorImple implements ComputerHintGenerator {

    private int strike_count = 0;
    private int ball_count = 0;

    @Override
    public String generateHintForInput(List<Integer> userInputNumbers, List<Integer> gameComputerNumbers) {
        countStrikeAndBall(userInputNumbers, gameComputerNumbers);
        return printHintMessage();
    }

    private void countStrikeAndBall(List<Integer> userInputNumbers, List<Integer> gameComputerNumbers) {
        clearBeforeCountingData();
        for (int idx = 0; idx < NUMBERS_MAX_LENGTH; idx++) {
            countStrike(userInputNumbers.get(idx), gameComputerNumbers.get(idx));
            countBall(userInputNumbers.get(idx), gameComputerNumbers.get(idx), gameComputerNumbers);
        }
    }

    private void clearBeforeCountingData() {
        strike_count = 0;
        ball_count = 0;
    }

    private void countStrike(Integer userInputNumbersElement, Integer gameComputerNumbersElement) {
        if (userInputNumbersElement.equals(gameComputerNumbersElement)) {
            strike_count++;
        }
    }

    private void countBall(Integer userInputNumbersElement, Integer gameComputerNumbersElement, List<Integer> gameComputerNumbers) {
        if (!userInputNumbersElement.equals(gameComputerNumbersElement)) {
            if (gameComputerNumbers.contains(userInputNumbersElement)) {
                ball_count++;
            }
        }
    }


    private String printHintMessage() {
        if (isStrikeCase()) {
            return createHintMessage(this.strike_count, Notice.STRIKE_NOTICE);
        } else if (isBallCase()) {
            return createHintMessage(this.ball_count, Notice.BALL_NOTICE);
        } else if (isStrikeAndBall()) {
            return createHintMessage(this.ball_count, Notice.BALL_NOTICE) + " "
                    + createHintMessage(this.strike_count, Notice.STRIKE_NOTICE);
        }
        return Notice.NOTHING_NOTICE;
    }

    private String createHintMessage(int count, String notice) {
        StringBuffer hintMessage = new StringBuffer();

        hintMessage.append(count);
        hintMessage.append(notice);

        return hintMessage.toString();
    }


    private boolean isStrikeCase() {
        if (this.strike_count > 0 && this.ball_count == 0) {
            return true;
        }
        return false;
    }

    private boolean isBallCase() {
        if (this.ball_count > 0 && this.strike_count == 0) {
            return true;
        }
        return false;
    }

    private boolean isStrikeAndBall() {
        if (this.ball_count > 0 && this.strike_count > 0) {
            return true;
        }
        return false;
    }
}
