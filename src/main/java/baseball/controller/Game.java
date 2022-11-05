package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;

public class Game {
    private Player player = new Player();
    private Computer computer = new Computer();
    private int strikeCount = 0, ballCount = 0;

    private final String answerNumber = computer.getRandomBaseballNumber();

    public String getAnswerNumber() {
        return answerNumber;
    }
}
