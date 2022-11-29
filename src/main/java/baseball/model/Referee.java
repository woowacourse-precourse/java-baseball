package baseball.model;

import static baseball.util.Constants.BALL_LENGTH;

import java.util.HashMap;
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
        Map<BallCount, Integer> ballCount = new HashMap<>();
        ballCount.put(BallCount.BALL, 0);
        ballCount.put(BallCount.STRIKE, 0);
        List<Integer> computerNumber = computer.getComputerNumber();
        List<Integer> playerNumber = player.getPlayerNumber();
        for (int i = 0; i < BALL_LENGTH; i++) {
            if (computerNumber.contains(playerNumber.get(i))) {
                if (i != computerNumber.indexOf(playerNumber.get(i))) {
                    ballCount.put(BallCount.BALL, ballCount.get(BallCount.BALL) + 1);
                }
                if (i == computerNumber.indexOf(playerNumber.get(i))) {
                    ballCount.put(BallCount.STRIKE, ballCount.get(BallCount.STRIKE) + 1);
                }
            }
        }
        return ballCount;
    }
}
