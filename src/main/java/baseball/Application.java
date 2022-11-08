package baseball;

import baseball.resource.GameMessage;

public class Application {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();

        System.out.println(GameMessage.START_GAME_MESSAGE);
        do {
            baseballGame.playGame();
        } while(baseballGame.askNewGame());
    }
}
