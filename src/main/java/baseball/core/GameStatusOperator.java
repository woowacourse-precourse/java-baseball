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

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNumberOfBall() {
        return numberOfBall;
    }

    public int getNumberOfStrike() {
        return numberOfStrike;
    }
}
