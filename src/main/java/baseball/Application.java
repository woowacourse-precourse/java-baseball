package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballGame game = new BaseballGame();
        while(game.gameEnd()){
            game.playGame();
        }
    }
}

