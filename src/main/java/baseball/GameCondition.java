package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameCondition {
    String condition;
    final String CHOOSE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    final String END_MESSAGE = "게임 종료";

    public GameCondition() {
        System.out.println(CHOOSE_MESSAGE);
        condition = Console.readLine();
        bringCondition();
    }

    void bringCondition() {
        checkCondition();
        if (condition.equals("1"))
            restart();
        else
            exit();
    }

    void checkCondition() {
        if (!condition.equals("1") && !condition.equals("2"))
            throw new IllegalArgumentException();
    }

    void restart() {
        Game newGame = new Game();
        newGame.start();
    }

    void exit() {
        System.out.println(END_MESSAGE);
    }
}
