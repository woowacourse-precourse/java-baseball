package baseball.service;

import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private static final String STRIKE = "STRIKE";
    private static final String BALL = "BALL";

    private Player player;
    private Computer computer;

    public Rule() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void generateRandomNumber() {
        computer.generateRandomNumber();
    }

    public List<Integer> decideStrikeOrBall() {
        List<Integer> result = new ArrayList<>();
        result.add(countStrike(result));
        result.add(countBall(result));
        return result;
    }

    private int countStrike(List<Integer> result) {
        return 0;
    }

    private int countBall(List<Integer> result) {
        return 0;
    }

    public void getNumberByPlayer() {
        String input = InputView.read();
        if(isValid(input)) {
            player.setNumber(input);
        }
    }

    public boolean isValid(String input) {
    }
}
