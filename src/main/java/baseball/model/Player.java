package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumber;
    private Integer strike;
    private Integer ball;

    public Player() {
        this.playerNumber = new ArrayList<>();
        this.strike = 0;
        this.ball = 0;
    }

    public List<Integer> getPlayerNumber() {
        return this.playerNumber;
    }

    public void setPlayerNumber(String inputNumber) {
        checkInputStyle(inputNumber);
        setNumber(inputNumber);
    }

    public void checkInputStyle(String inputNumber) {
        String REGEX = "^[1-9]*";

        if (inputNumber.length() != 3 || !inputNumber.matches(REGEX)) {
            inputError();
        }
    }

    public void setNumber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            int unit = inputNumber.charAt(i) - '0';
            checkOverlab(unit);
            playerNumber.add(unit);
        }
    }

    public void checkOverlab(int unit) {
        if (playerNumber.contains(unit)) {
            inputError();
        }
    }

    public void inputError() {
        throw new IllegalArgumentException();
    }

    public Integer getStrike() {
        return this.strike;
    }

    public void countStrike() {
        this.strike += 1;
    }

    public Integer getBall() {
        return this.ball;
    }

    public void countBall() {
        this.ball += 1;
    }
}


