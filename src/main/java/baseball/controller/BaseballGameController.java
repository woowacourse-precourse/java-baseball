package baseball.controller;

import baseball.model.ComputerRandomNumber;
import baseball.model.UserBaseballNumber;
import baseball.utils.NumberCalculator;
import baseball.view.InputView;

public class BaseballGameController {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final int THREE_COUNT = 3;

    public static void start() {
        System.out.println(GAME_START);
        startGame();
    }

    private static void startGame() {

        int strike = 0;
        int ball = 0;

        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();

        do {

            UserBaseballNumber userBaseballNumber = new UserBaseballNumber(InputView.inputNumber());

            NumberCalculator numberCalculator = new NumberCalculator(computerRandomNumber.getComputerNumber(), userBaseballNumber.getUserNumber());
            numberCalculator.resultCalculator();

            strike = numberCalculator.getStrike();
            ball = numberCalculator.getBall();

        } while (strike != THREE_COUNT);
    }
}
