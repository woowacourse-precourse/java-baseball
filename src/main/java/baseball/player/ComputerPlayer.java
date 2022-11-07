package baseball.player;

import baseball.baesball.Baseball;
import baseball.baesball.BaseballGenerator;

public class ComputerPlayer {
    private Baseball baseball;

    public ComputerPlayer() {
    }

    public Baseball playGame(BaseballGenerator baseballGenerator) {
        baseball = baseballGenerator.generateBaseball();
        return baseball;
    }
}
