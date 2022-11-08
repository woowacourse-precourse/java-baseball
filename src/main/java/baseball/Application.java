package baseball;

import baseball.resource.GameMessage;

public class Application {
    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();

        System.out.println(GameMessage.START_GAME_MESSAGE);
        do {
            baseballGame.playGame();
            System.out.println(GameMessage.ALL_CORRECT_MESSAGE);
        } while (baseballGame.askNewGame());
    }
}
