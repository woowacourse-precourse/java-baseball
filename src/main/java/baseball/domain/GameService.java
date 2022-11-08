package baseball.domain;

import baseball.domain.generator.GameGenerator;
import baseball.domain.model.Game;
import baseball.domain.model.Result;
import baseball.domain.model.UserInput;
import java.util.List;

public class GameService {

    private static final int STRIKE_OUT = 3;
    private static Game game;

    public GameService() {
        this.game = new Game(GameGenerator.createGame());
    }

    public Result getResult(UserInput userInput) {
        int strike = 0;
        int ball = 0;
        boolean isOut = false;
        List<Integer> inputs = userInput.getNumbers();

        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i) == game.getGameNumbers().get(i)) {
                strike++;
            } else if (game.getGameNumbers().contains(inputs.get(i))) {
                ball++;
            }
        }

        if (isOut(strike)) {
            isOut = true;
        }

        return new Result(strike, ball, isOut);
    }

    private boolean isOut(int strike) {
        return (strike == STRIKE_OUT);
    }

}
