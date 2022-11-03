package baseball.domain;

public class Referee {
    private final PlayResult playResult;

    public Referee(Balls userBalls, Balls computerBalls) {
        this.playResult = judgeGame(userBalls, computerBalls);
    }

    private PlayResult judgeGame(Balls userBalls, Balls computerBalls) {
        return userBalls.compareTo(computerBalls);
    }

    public PlayResult notifyResult() {
        return playResult;
    }
}
