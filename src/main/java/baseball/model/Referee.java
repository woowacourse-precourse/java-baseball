package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;

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

    public Result judgeBallCount() {
        Result result = Result.initialBallCount();
        for (int position = 0; position < BALL_LENGTH; position++) {
            BallCount ballCount = BallCount.decideBallCount(hasCommonNumber(position), isInSamePosition(position));
            result.updateBallCount(ballCount);
        }
        return result;
    }

    private boolean isInSamePosition(int position) {
        return computer.getNumberByPosition(position) == player.getNumberByPosition(position);
    }

    private boolean hasCommonNumber(int position) {
        return computer.getComputerNumber().contains(player.getNumberByPosition(position));
    }

}
