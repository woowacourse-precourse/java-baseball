package baseball.domain;

public class BaseballGameMachine {
    private BaseballNumbers computer;
    private BaseballGameStatus gameStatus;

    public BaseballGameMachine() {
    }

    public void initialize(BaseballNumbers baseballNumbers) {
        this.computer = baseballNumbers;
        changeGameStatusToStart();
    }

    public BaseballGameResult play(BaseballNumbers player) {
        BaseballGameResult baseballGameResult = computer.play(player);
        if (baseballGameResult.isStrikeOut()) {
            changeGameStatusToStop();
        }
        return baseballGameResult;
    }

    private void changeGameStatusToStart() {
        this.gameStatus = BaseballGameStatus.PLAY;
    }

    private void changeGameStatusToStop() {
        this.gameStatus = BaseballGameStatus.STOP;
    }

    public boolean isGameContinues() {
        return this.gameStatus.isGameContinues();
    }
}
