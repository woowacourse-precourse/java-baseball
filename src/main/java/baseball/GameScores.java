package baseball;

import java.util.Collections;
import java.util.List;

public class GameScores {
    private int ballCount;
    private int strikeCount;

    public void setBallCount(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int index = 0; index < userNumber.size(); index++) {
            if (computerNumber.contains(userNumber.get(index)) && !userNumber.get(index).equals(computerNumber.get(index))) {
                this.ballCount++;
            }
        }
    }

    public void setStrikeCount(List<Integer> userNumber, List<Integer> computerNumber) {
        for (int index = 0; index < userNumber.size(); index++) {
            if (userNumber.get(index).equals(computerNumber.get(index))) {
                this.strikeCount++;
            }
        }
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public boolean isNothing(List<Integer> userNumber, List<Integer> computerNumber) {
        return Collections.disjoint(userNumber, computerNumber);
    }

    public void printGameResult(List<Integer> userNumber, List<Integer> computerNumber) {
        String gameResult = "";
        setBallCount(userNumber, computerNumber);
        setStrikeCount(userNumber, computerNumber);
        if (this.ballCount > 0) {
            gameResult += this.ballCount + MessageType.BALL_MESSAGE.getMessage();
        }
        if (this.strikeCount > 0) {
            gameResult += this.strikeCount + MessageType.STRIKE_MESSAGE.getMessage();
        }
        if (isNothing(userNumber, computerNumber)) {
            gameResult += MessageType.NOTHING_MESSAGE.getMessage();
        }
        System.out.println(gameResult);
    }

    public void gameScoresZero() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }
}
