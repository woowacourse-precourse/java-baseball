package baseball.player;

import baseball.baesball.Baseball;
import baseball.baesball.BaseballGenerator;

public class GamePlayer {
    private Baseball baseBall;

    public GamePlayer() {
    }

    public Baseball playGame(BaseballGenerator baseballGenerator) {
        baseBall = baseballGenerator.generateBaseball();
        return baseBall;
    }
}
