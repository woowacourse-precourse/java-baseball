package baseball;

import baseball.baseballGame.BaseballGame;

public class AppConfig {
    public static final int BALL_COUNT = 3;

    public void startGame(){
        BaseballGame baseballGame = new BaseballGame(BALL_COUNT);
        baseballGame.play();
    }
}
