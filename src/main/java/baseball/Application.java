package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        do{
            game.playGame();
        }while(game.isEnd());
    }
}
