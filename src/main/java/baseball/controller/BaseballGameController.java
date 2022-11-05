package baseball.controller;

import baseball.model.ComputerRandomNumber;
import baseball.model.UserBaseballNumber;
import baseball.view.InputView;

public class BaseballGameController {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";

    public static void start() {
        System.out.println(GAME_START);
        startGame();
    }

    private static void startGame() {
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        for (int i = 0; i < 3; i++) {
          UserBaseballNumber userBaseballNumber = new UserBaseballNumber(InputView.inputNumber());
        }
    }
}
