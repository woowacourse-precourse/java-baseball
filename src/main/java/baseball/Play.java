package baseball;

import java.util.List;

public class Play {
    public void Game() {
        String computerNumber = Computer.Number();
        boolean endGameCheck;

        do {
            String userNumber = User.Number();
            BaseballGame baseballGame = new BaseballGame(userNumber, computerNumber);
            baseballGame.isBall();
            baseballGame.isStrike();
            baseballGame.printCompareResult();
            endGameCheck = baseballGame.isStrike();
        } while(!endGameCheck);
    }
}
