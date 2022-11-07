package game.stdiogame.numberbaseball;

import camp.nextstep.edu.missionutils.Console;
import game.GameStatus;
import game.stdiogame.SimpleStdIOGame;

import java.util.Map;

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
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        String input = gameStatus.getInputData();
        if (!input.matches("[1-9][1-9][1-9]")) throw new IllegalArgumentException();
    }

    @Override
    public void operateRule() {
        count();
    }

    private boolean isStrike(int idx) {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        String input = gameStatus.getInputData();
        Map<Character, Integer> targetNumber = gameStatus.getTargetNumber();
        return targetNumber.get(input.charAt(idx)) != null && targetNumber.get(input.charAt(idx)).equals(idx);
    }

    private boolean isBall(int idx) {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        String input = gameStatus.getInputData();
        Map<Character, Integer> targetNumber = gameStatus.getTargetNumber();
        return targetNumber.get(input.charAt(idx)) != null && !targetNumber.get(input.charAt(idx)).equals(idx);
    }
    private void count() {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        String input = gameStatus.getInputData();
        int len = input.length();
        for (int i = 0; i < len; ++i) {
            countStrike(i);
            countBall(i);
        }
    }

    private void countBall(int idx) {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        if (isBall(idx)) {
            gameStatus.setBallCount(gameStatus.getBallCount() + 1);
        }
    }

    private void countStrike(int idx) {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        if (isStrike(idx)) {
            gameStatus.setStrikeCount(gameStatus.getStrikeCount() + 1);
        }
    }
    @Override
    protected void writeOutput() {

    }

    private void prepareOutputData() {

    }

    private void resetCount() {
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) getGameStatus();
        gameStatus.setStrikeCount(0);
        gameStatus.setBallCount(0);
    }
}
