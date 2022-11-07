package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameCondition {
    String condition;
    final String CHOOSE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public GameCondition(){
        System.out.println(CHOOSE_MESSAGE);
        condition = Console.readLine();
        bringCondition();
    }

    void bringCondition() {
        if (condition.equals("1"))
            restart();
        else
            exit();
    }

    void restart(){
        Game restart = new Game();
        restart.start();
    }

    void exit(){
        Game end = new Game();
        end.end();
    }
}
