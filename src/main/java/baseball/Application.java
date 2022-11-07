package baseball;


import baseball.domain.baseball.BaseballContextImpl;
import baseball.domain.baseball.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        var baseballGame = new BaseballGame(new BaseballContextImpl());
        baseballGame.run();
    }
}
