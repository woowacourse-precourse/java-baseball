package baseball.service;

import baseball.number.InputNumber;
import baseball.number.RandomNumber;
import baseball.dto.Result;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.Const.QUIT_GAME;
import static baseball.Const.RESTART_GAME;

public class GameService {

    private final InputNumber inputNumber;
    private final RandomNumber randomNumber;

    public GameService(InputNumber inputNumber, RandomNumber randomNumber) {
        this.inputNumber = inputNumber;
        this.randomNumber = randomNumber;
    }

    public Result checkStrikeAndBall() {
        List<String> randomNumbers = randomNumber.createRandomNumber();
        String inputNumbers = inputNumber.inputBallNumber();

        int strike = 0;
        int ball = 0;
        for (int number = 0; number < inputNumbers.length(); number++) {
            String randomNumber = randomNumbers.get(number);
            if (isEqualNumber(randomNumber, inputNumbers, number)) {
                strike++;
                continue;
            }
            if (existNumber(randomNumber, inputNumbers)) {
                ball++;
            }
        }
        return new Result(strike, ball);
    }

    public void clearRandomBallNumber() {
        randomNumber.createRandomNumber().clear();
    }

    public String inputOneOrTwo() {
        return Console.readLine();
    }

    public void isNotRestartedAndQuitedGame(String oneOrTwo) {
        if (!oneOrTwo.equals(RESTART_GAME) && !oneOrTwo.equals(QUIT_GAME)) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요");
        }
    }

    private boolean existNumber(String randomNumber, String inputNumber) {
        return inputNumber.contains(randomNumber);
    }

    private boolean isEqualNumber(String randomNumber, String inputNumber, int ballNumber) {
        return inputNumber.charAt(ballNumber) == randomNumber.charAt(0);
    }
}
