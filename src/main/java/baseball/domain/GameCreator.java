package baseball.domain;


import baseball.view.BaseBallInput;
import baseball.view.UserInput;

public abstract class GameCreator {
    public abstract Game createGame();

    void startGame() {
        Game game = createGame();
        UserInput input = new BaseBallInput();
        game.validate(input);
        game.startGame(input);

    }
}
