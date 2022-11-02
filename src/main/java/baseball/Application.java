package baseball;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();

        do {
            List<Integer> answer = game.makeAnswer();
        } while (game.isRestart());

    }
}
