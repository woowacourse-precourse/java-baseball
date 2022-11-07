package baseball.domain;

import baseball.domain.Generator.GameGenerator;
import baseball.domain.model.Result;
import baseball.domain.model.UserInput;
import java.util.List;

public class GameService {

    private static final int STRIKE_OUT = 3;
    private static List<Integer> gameNumbers;

    public GameService() {
        this.gameNumbers = GameGenerator.createGame();
    }

    public Result getResult(UserInput userInput) {
        int strike = 0;
        int ball = 0;
        boolean isOut = false;
        List<Integer> inputs = userInput.getNumbers();

        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i) == this.getGameNumbers().get(i)) {
                strike++;
            } else if (this.getGameNumbers().contains(inputs.get(i))) {
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

    public List<Integer> getGameNumbers() {
        return gameNumbers;
    }
}
