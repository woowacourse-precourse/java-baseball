package baseball.service;

import baseball.domain.BaseballDto;
import baseball.status.Constants;
import java.util.List;
import java.util.stream.IntStream;

public class GameLogic {

    List<Integer> computerNumbers;
    List<Integer> userNumbers;
    BaseballDto baseballDto;

    public GameLogic(List<Integer> computerNumbers, BaseballDto baseballDto) {
        this.computerNumbers = computerNumbers;
        this.baseballDto = baseballDto;
    }

    public void getBallAndStrikeCount() {
        IntStream.range(Constants.ZERO_COUNT.getNumber(), Constants.NUMBER_OF_DIGITS.getNumber())
                .forEach(index -> {
                    int userDigit = userNumbers.get(index);
                    int computerDigit = computerNumbers.get(index);
                    checkBallAndStrike(userDigit, computerDigit);
                });
    }

    private void checkBallAndStrike(int inputDigit, int computerDigit) {
        if (isStrike(inputDigit, computerDigit)) {
            baseballDto.addStrikeCount();
            return;
        }
        if (isBall(inputDigit)) {
            baseballDto.addBallCount();
        }
    }

    private boolean isBall(int inputDigit) {
        return computerNumbers.contains(inputDigit);
    }

    private boolean isStrike(int inputDigit, int computerDigit) {
        return inputDigit == computerDigit;
    }
}
