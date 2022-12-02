package baseball.core;

import baseball.type.GameStatus;

public class GameStatusOperator {

    private GameStatus gameStatus;
    private int numberOfBall;
    private int numberOfStrike;

    protected GameStatusOperator(GameStatus gameStatus, int numberOfBall, int numberOfStrike) {
        this.gameStatus = gameStatus;
        this.numberOfBall = numberOfBall;
        this.numberOfStrike = numberOfStrike;
    }

    public GameStatus changeGameStatus(String gameCommand) {
        gameStatus = GameStatus.getGameStatusByCommand(gameCommand);
        return gameStatus;
    }

    public void updateNumberOfBall(int numberOfBall) {
        this.numberOfBall = numberOfBall;
    }

    public void updateNumberOfStrike(int numberOfStrike) {
        this.numberOfStrike = numberOfStrike;
    }

    //== getter & setter ==//

    protected GameStatus getGameStatus() {
        return gameStatus;
    }

    protected void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    protected int getNumberOfBall() {
        return numberOfBall;
    }

    protected int getNumberOfStrike() {
        return numberOfStrike;
    }
}
