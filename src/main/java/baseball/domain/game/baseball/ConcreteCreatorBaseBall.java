package baseball.domain.game.baseball;

import baseball.domain.Game;
import baseball.domain.GameCreator;
import baseball.view.BaseBallInput;

import java.io.IOException;

public class ConcreteCreatorBaseBall extends GameCreator {

    @Override
    public Game createGame() throws IOException {
        BaseBallInput baseBallInput = new BaseBallInput();
        String input = baseBallInput.getInput();

        CreateBaseBall createBaseBall = new CreateBaseBall();
        createBaseBall.startGame();

        return null;
    }



}
