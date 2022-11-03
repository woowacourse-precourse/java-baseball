package baseball;

import baseball.game.Baseball;
import baseball.service.GamePlay;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GamePlay.start(Baseball.class);
    }
}
