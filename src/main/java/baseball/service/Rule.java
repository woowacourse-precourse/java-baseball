package baseball.service;

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
        computer.number = ThreeNumberGenerator.generate();
    }

    public List<Integer> decideStrikeOrBall() {
        List<Integer> result = new ArrayList<>();
        result.add(countStrike(result));
        result.add(countBall(result));
        return result;
    }

    private int countStrike(List<Integer> result) {

    }

    private int countBall(List<Integer> result) {

    }
}
