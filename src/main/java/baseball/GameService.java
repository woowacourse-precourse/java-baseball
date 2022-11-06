package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Const.QUIT_GAME;
import static baseball.Const.RESTART_GAME;

public class GameService {

    private final InputBallNumber inputBallNumber;
    private final RandomBallNumber randomBallNumber;

    public GameService(InputBallNumber inputBallNumber, RandomBallNumber randomBallNumber) {
        this.inputBallNumber = inputBallNumber;
        this.randomBallNumber = randomBallNumber;
    }

    public Result checkStrikeAndBall() {
        List<String> randomNumbers = randomBallNumber.createRandomNumber();
        String inputNumber = inputBallNumber.inputBallNumber();

        int strike = 0;
        int ball = 0;
        for (int ballNumber = 0; ballNumber < inputNumber.length(); ballNumber++) {
            String randomNumber = randomNumbers.get(ballNumber);
            if (isEqualNumber(randomNumber, inputNumber, ballNumber)) {
                strike++;
                continue;
            }
            if (existNumber(randomNumber, inputNumber)) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    public void clearRandomBallNumber() {
        randomBallNumber.randomNumbers.clear();
    }

    private boolean existNumber(String randomNumber, String inputNumber) {
        return inputNumber.contains(randomNumber);
    }

    private boolean isEqualNumber(String randomNumber, String inputNumber, int ballNumber) {
        return inputNumber.charAt(ballNumber) == randomNumber.charAt(0);
    }
}
