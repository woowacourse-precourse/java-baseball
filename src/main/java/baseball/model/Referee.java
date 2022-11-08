package baseball.model;

import baseball.vo.Player;
import baseball.vo.ScoreBoard;

import java.util.List;

public class Referee {

    private List<Integer> computerSelectNumbers;
    private boolean allStrike = false;
    public Referee(List<Integer> computerSelectNumbers) {
        this.computerSelectNumbers = computerSelectNumbers;
    }
    public ScoreBoard giveScore(Player player) {
        List<Integer> playerSelectNumbers = player.getUserSelectNumbers();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < playerSelectNumbers.size(); ++i)
        {
            int playerSelectNumber = playerSelectNumbers.get(i);
            int computerSelectNumber = computerSelectNumbers.get(i);
            if (playerSelectNumber == computerSelectNumber) {
                ++strike;
                continue;
            }
            if (playerSelectNumbers.contains(computerSelectNumber)) {
                ++ball;
            }
        }
        checkAllStrike(strike);
        return new ScoreBoard(strike, ball);
    }
    public boolean isAllStrike() {
        return allStrike;
    }
    public void checkAllStrike(int strike) {
        if (strike == 3) {
            allStrike = true;
        }
    }
}
