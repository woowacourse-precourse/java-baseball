package baseball.Domain;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private List<String> computerNumber = new ArrayList<>();
    private List<String> inputNumber= new ArrayList<>();

    private int strike;

    private int ball;

    public Baseball(List<String> computerNumber, List<String> inputNumber) {
        this.computerNumber = computerNumber;
        this.inputNumber = inputNumber;
    }

    public void initBaseballGame() {
        strike=0;
        ball=0;
    }

    public List<String> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(List<String> randomNumberList) {
        computerNumber = randomNumberList;
    }

    public List<String> getInputNumber() {
        return inputNumber;
    }

    public void setInputNumber(List<String> inputNumberList) {
        inputNumber = inputNumberList;
    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strikeNum) {
        strike = strikeNum;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ballNum) {
        ball = ballNum;
    }

}
