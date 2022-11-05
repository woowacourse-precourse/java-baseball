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

    private boolean isStrike(char onePlayerNum, int idx) {
        return answerNumber.charAt(idx) == onePlayerNum;
    }

    public void compareNumber(String playerNumber) {
        for (int i = 0; i < 3; i++) {
            char onePlayerNumber = playerNumber.charAt(i);
            if (isStrike(onePlayerNumber, i))
                strikeCount++;
            if (isBall(onePlayerNumber, i))
                ballCount++;
        }
    }

    private boolean isBall(char onePlayerNum, int idx) {
        for (int i = 0; i < 3; i++) {
            if (i == idx) {
                continue;
            }
            if (answerNumber.charAt(i) == onePlayerNum) {
                return true;
            }
        }
        return false;

    }
}
