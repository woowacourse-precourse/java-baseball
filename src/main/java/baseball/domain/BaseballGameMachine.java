package baseball.domain;

public class BaseballGameMachine {

    private final Baseballs baseballs;

    public BaseballGameMachine(Baseballs baseballs) {
        this.baseballs = baseballs;
    }

    public BaseballGameMachine play(GameState gameState) {
        if (gameState.isNotPlayable()) {
            throw new IllegalArgumentException("게임을 진행할 수 없습니다.");
        }
        if (gameState.isRestart()) {
            return new BaseballGameMachine(Baseballs.generateRandomBaseballNumbers());
        }
        return this;
    }

    public GameResult judgeGameResult(Baseballs userBaseballs) {
        int ballCounts = this.baseballs.judgeBallCounts(userBaseballs);
        int strikeCounts = this.baseballs.judgeStrikeCounts(userBaseballs);
        return new GameResult(ballCounts, strikeCounts);
    }
}
