package baseball.domain;

import baseball.domain.generator.GameGenerator;
import baseball.domain.model.Game;
import baseball.domain.model.Result;
import baseball.domain.model.Score;
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
        List<Integer> userInputs = userInput.getNumbers();
        List<Integer> gameNumbers = game.getGameNumbers();

        for (int i = 0; i < userInputs.size(); i++) {
            String judgment = decideStrikeOrBall(userInputs.get(i), gameNumbers.get(i));
            if (judgment == "strike") {
                strike++;
            }
            if (judgment == "ball") {
                ball++;
            }
        }
        if (isOut(strike)) {
            isOut = true;
        }

        return new Result(new Score(strike, ball), isOut);
    }

    public String decideStrikeOrBall(Integer userInput, Integer gameNumber) {
        if (isStrike(userInput, gameNumber)) {
            return "strike";
        }
        if (isBall(userInput)) {
            return "ball";
        }
        return "";
    }

    private boolean isStrike(int userNum, int gameNum) {
        return (userNum == gameNum);
    }

    private boolean isBall(int userNum) {
        return game.getGameNumbers().contains(userNum);
    }

    private boolean isOut(int strike) {
        return (strike == STRIKE_OUT);
    }

}
