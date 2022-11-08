package baseball;

import baseball.controller.BaseballGame;
import baseball.model.PlayerNumber;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do{
            BaseballGame game = new BaseballGame();
            game.startGame();
        } while(PlayerNumber.continueGame().equals("1"));
    }
}
