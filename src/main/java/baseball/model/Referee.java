package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;

import java.util.List;
import java.util.Map;

public class Referee {
    private final Computer computer;
    private final Player player;

    private Referee(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public static Referee judge(Computer computer, Player player) {
        return new Referee(computer, player);
    }

    public Map<BallCount, Integer> getBallCountJudgement() {
        Result result = Result.initialBallCount();

        for (int position = 0; position < BALL_LENGTH; position++) {
            int userChoice = player.getNumberByPosition(position);
            BallCount ballCount = BallCount.decideBallCount(hasCommonNumber(userChoice), isInSamePosition(position));
            result.updateBallCount(ballCount);
        }
        return result.getResult();
    }

    private boolean isInSamePosition( int position) {
        return position == computer.getComputerNumber().indexOf(player.getNumberByPosition(position));
    }

    private boolean hasCommonNumber(int number) {
        return computer.getComputerNumber().contains(number);
    }


}
