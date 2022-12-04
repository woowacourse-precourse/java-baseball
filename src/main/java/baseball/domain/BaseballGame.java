package baseball.domain;

import baseball.util.GameStatus;
import baseball.util.PlayStatus;

public class BaseballGame {
    private final Player player;
    private Baseball baseball;
    private Result result;
    private int isFinish;

    public BaseballGame(Player player) {
        isFinish = PlayStatus.NEW_GAME.getPlayStatus();
        baseball = new Baseball();
        this.player = player;
    }

    public void play() {
        getTotalBallCount();
        checkIsFinish();
    }

    public void getTotalBallCount() {
        result = baseball.getTotalBallCount(player.getPlayerNumber());
    }

    public void checkIsFinish() {
        if (result.getStrickCount() == GameStatus.BALL_SIZE.getInitInfo()) {
            isFinish = PlayStatus.EXIT_GAME.getPlayStatus();
        }
    }

    public void retry() {
        baseball = new Baseball();
        isFinish = PlayStatus.NEW_GAME.getPlayStatus();
    }

    public boolean isGameFinish() {
        return isFinish == PlayStatus.EXIT_GAME.getPlayStatus();
    }

    public void setPlayerNumber(String number) {
        player.setPlayerNumber(number);
    }

    public Result getResult() {
        return result;
    }
}
