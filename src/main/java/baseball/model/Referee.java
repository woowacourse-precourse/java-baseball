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

        List<Integer> computerNumber = computer.getComputerNumber();
        for (int position = 0; position < BALL_LENGTH; position++) {
            if (computer.hasCommonNumber(player.getNumberByPosition(position))) {
                if (position != computerNumber.indexOf(player.getNumberByPosition(position))) {
                   result.updateBallCount(BallCount.BALL);

                }
                if (position == computerNumber.indexOf(player.getNumberByPosition(position))) {
                    result.updateBallCount(BallCount.STRIKE);
                }
            }
        }
        return result.getResult();
    }


}
