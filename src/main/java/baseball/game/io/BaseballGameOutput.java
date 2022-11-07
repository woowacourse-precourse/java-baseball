package baseball.game.io;

import baseball.game.model.Count;

public class BaseballGameOutput {

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameResult(Count count) {
        System.out.println(count.toString());
    }

}
