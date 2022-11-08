package baseball.service;

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

    }
}
