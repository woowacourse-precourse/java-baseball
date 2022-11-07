package baseball;

import static baseball.GamePlay.START_MESSAGE;

public class Application {
    public static void main(String[] args) {
        GamePlay play = new GamePlay();
        System.out.println(START_MESSAGE);
        play.playBaseball();
    }
}
