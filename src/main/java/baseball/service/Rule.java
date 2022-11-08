package baseball.service;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private static final String STRIKE = "STRIKE";
    private static final String BALL = "BALL";
    private static final int SIZE = 3;

    private final Player player;
    private final Computer computer;

    public Rule() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void generateRandomNumber() {
        computer.generateRandomNumber();
    }

    public List<Integer> decideStrikeOrBall() {
        List<Integer> result = new ArrayList<>();
        int ball = countBall();
        int strike = countStrike();
        ball = ball - strike;
        result.add(strike);
        result.add(ball);

        return result;
    }

    private int countStrike() {
        int strike = 0;
        for (int position = 0; position < SIZE; position++) {
            if(computer.getNumber(position) == player.getNumber(position)) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall() {
        int ball = 0;
        for (int position = 0; position < SIZE; position++) {
            if(computer.getThreeNumber().contains(player.getNumber(position))) {
                ball++;
            }
        }
        return ball;
    }

    public void getNumberByPlayer() {
        String input = InputView.read();
        if(Validation.isValidNumber(input)) {
            player.setNumber(input);
        }
    }
}
