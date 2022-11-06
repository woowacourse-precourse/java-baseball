package baseball.player;

import baseball.baesball.Baseball;
import baseball.baesball.BaseballGenerator;

public class ComputerPlayer {
    private Baseball baseball;

    public ComputerPlayer() {
    }

    public void playGame(BaseballGenerator baseballGenerator) {
        baseball = baseballGenerator.generateBaseball();
    }
}
