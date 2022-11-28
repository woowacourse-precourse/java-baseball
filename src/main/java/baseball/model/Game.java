package baseball.model;

public class Game {
    private final GameNumberCollection computerNumbers;

    public Game(GameNumberCollection computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public GameResult getResultOf(GameNumberCollection playerNumbers) {
        int ballCnt = computerNumbers.countBalls(playerNumbers);
        int strikeCnt = computerNumbers.countStrikes(playerNumbers);

        return new GameResult(ballCnt, strikeCnt);
    }

}
