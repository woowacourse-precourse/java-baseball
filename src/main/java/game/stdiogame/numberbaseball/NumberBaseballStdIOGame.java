package game.stdiogame.numberbaseball;

import camp.nextstep.edu.missionutils.Console;
import game.GameStatus;
import game.stdiogame.SimpleStdIOGame;

public class NumberBaseballStdIOGame extends SimpleStdIOGame {
    public NumberBaseballStdIOGame(String name, GameStatus gameStatus) {
        super(name, gameStatus);
    }

    @Override
    public void start() {
        GameStatus gameStatus = getGameStatus();
        gameStatus.setStart(true);
    }

    @Override
    public void loop() {
        loopGame();
    }

    @Override
    public void finish() {
        GameStatus gameStatus = getGameStatus();
        gameStatus.setFinish(true);
        gameStatus.setStart(false);
    }

    @Override
    protected void writeGameMessage() {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        if (getGameStatus().isStart()) {
            System.out.print("");
        } else if (getGameStatus().isFinish()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    @Override
    protected void readInput() {
        System.out.print("숫자를 입력해주세요 : ");
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        gameStatus.setInputData(Console.readLine());
    }

    @Override
    protected void checkInput() throws IllegalArgumentException {

    }

    @Override
    public void operateRule() {

    }

    @Override
    protected void writeOutput() {

    }

    private void countBall() {

    }

    private void countStrike() {

    }

    private void prepareOutputData() {

    }

}
