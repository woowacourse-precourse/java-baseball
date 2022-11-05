package baseball;

import java.util.List;

public class Play {
    public void playGame() {
        List<Integer> computerNumber = Computer.computerNumber();
        boolean endGameCheck;

        do {
            List<Integer> userNumber = User.userNumber();
            BaseballGame baseballGame = new BaseballGame(userNumber, computerNumber);
            baseballGame.isBall();
            baseballGame.isStrike();
            baseballGame.printCompareResult();
            endGameCheck = baseballGame.isStrike();
        } while(!endGameCheck);
    }
}
