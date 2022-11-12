package baseball.service;

import baseball.view.InputView;

public class Rule {
    private static final int SIZE = 3;

    public void generateRandomNumber(Computer computer) {
        computer.generateRandomNumber();
    }

    public BallStatus decideStrikeOrBall(ThreeNumber playerNumber, ThreeNumber computerNumber) {
        int ball = countBall(playerNumber, computerNumber);
        int strike = countStrike(playerNumber, computerNumber);
        ball = ball - strike;

        return new BallStatus(strike, ball);
    }

    private int countStrike(ThreeNumber playerNumber, ThreeNumber computerNumber) {
        int strike = 0;
        for (int position = 0; position < SIZE; position++) {
            if(computerNumber.getNumber(position) == playerNumber.getNumber(position)) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(ThreeNumber playerNumber, ThreeNumber computerNumber) {
        int ball = 0;
        for (int position = 0; position < SIZE; position++) {
            if(computerNumber.getThreeNumber().contains(playerNumber.getNumber(position))) {
                ball++;
            }
        }
        return ball;
    }

    public void getNumberByPlayer(Player player, String input) {
        if(Validation.isValidNumber(input)) {
            player.setNumber(input);
        }
    }
}
