package baseball.service;

import baseball.domain.ScoreBoard;

import java.util.List;

public class ScoreBoardService {
    ScoreBoard scoreBoard = new ScoreBoard();

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    private boolean hasNumberByComputerNumbers(List<Integer> computerNumbers, int playerNumber) {
        return computerNumbers.contains(playerNumber);
    }

    /**
     * 볼
     *
     * @return
     */
    public boolean isBall() {
        return scoreBoard.getBall() != 0;
    }

    /**
     * 볼 스트라이크
     *
     * @return
     */
    public boolean isBallAndStrike() {
        return scoreBoard.getBall() != 0 && scoreBoard.getStrike() != 0;
    }

    private boolean isEqualNumber(int computerNumber, int playerNumber) {
        return computerNumber == playerNumber;
    }

    /**
     * 낫싱
     *
     * @return
     */
    public boolean isNothing() {
        return scoreBoard.getBall() == 0 && scoreBoard.getStrike() == 0;
    }

    /**
     * 스트라이크
     *
     * @return
     */
    public boolean isStrike() {
        return scoreBoard.getStrike() != 0;
    }

    /**
     * 쓰리스트라이크
     *
     * @return
     */
    public boolean isThreeStrike() {
        return scoreBoard.isThreeStrike();
    }

    public void setScoreBoard(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computerNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int playerNumber = playerNumbers.get(i);
            if (isEqualNumber(computerNumber, playerNumber)) {
                strike += 1;
            } else if (hasNumberByComputerNumbers(computerNumbers, playerNumber)) {
                ball += 1;
            }
        }
        scoreBoard.setScoreBoard(ball, strike);
    }
}
