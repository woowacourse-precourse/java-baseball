package baseball;

import baseball.domain.NumberBall;
import baseball.domain.NumberBaseballGame;
import baseball.domain.ScoreBoard;
import baseball.util.ShowGameMessage;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseballGame game = new NumberBaseballGame(new ShowGameMessage(),
                new ScoreBoard(NumberBall.systemNumberBalls()));
        try {
            game.play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
