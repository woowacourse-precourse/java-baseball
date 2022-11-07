package baseball.Controller;

import baseball.Model.Constant;

import java.util.List;

public class baseballSystem {

    private final List<Integer> userInputNumber;
    private final List<Integer> computerAnswerNumber;
    private int strikeNumber;
    private int ballNumber;
    private boolean winTheGame;
    private boolean nothingInNumber;

    public baseballSystem(List<Integer> userInputNumber, List<Integer> computerAnswerNumber) {
        this.userInputNumber = userInputNumber;
        this.computerAnswerNumber = computerAnswerNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public boolean isWinTheGame() {
        return winTheGame;
    }

    public boolean isNothingInNumber() {
        return nothingInNumber;
    }

    private void prepareGameStatus() {
        resetGame();
        countStrikeBallNumber();
        setNothingInNumber();
        setWinTheGame();
    }

    private void resetGame() {
        strikeNumber = 0;
        ballNumber = 0;
        winTheGame = false;
        nothingInNumber = false;
    }

    private void countStrikeBallNumber() {
        for(int number = 0; number < Constant.MAX_NUM_SIZE; number++) {
            if(isStrike(number)) {
                strikeNumber++;
                continue;
            }
            if(isBall(number)) {
                ballNumber++;
            }
        }
    }

    private boolean isStrike(int index) {
        return userInputNumber.get(index).equals(computerAnswerNumber.get(index));
    }

    private boolean isBall(int index) {
        return computerAnswerNumber.contains(userInputNumber.get(index));
    }

    private void setNothingInNumber() {
        if(strikeNumber == 0 && ballNumber == 0) {
            nothingInNumber = true;
        }
    }

    private void setWinTheGame() {
        if(strikeNumber == Constant.MAX_NUM_SIZE) {
            winTheGame = true;
        }
    }
}
