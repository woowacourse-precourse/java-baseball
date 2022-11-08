package baseball.exception;

import baseball.controller.Game;

public class BaseballException {
    public static void vaildNum(int num){
        if (num < 100 || num > 999) {
            throw new IllegalArgumentException("3개의 숫자를 입력해 주십시오.");
        }
    }

    public static void vaildShutDownInput(int num){
        if (num!= Game.getNewGameCode() && num!=Game.getShutDownCode()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
