package baseball;

import baseball.GameProgressLine;
import baseball.PlayNumberBaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GameProgressLine.START_LINE.getLine());
        PlayNumberBaseballGame playNumberBaseballGame = new PlayNumberBaseballGame();
        playNumberBaseballGame.playNumberBaseballOneGame();
    }
}
