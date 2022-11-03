package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private Computer computer;
    private Numbers numbers;

    private int countBall;
    private int countStrike;

    public Round(Computer computer) {
        this.computer = computer;
    }

    public void startNewRound() {
        Print.printRoundStart();
        String inputString = Console.readLine();
        resetScore();
        inputNewNumbers(inputString);
    }

    private void inputNewNumbers(String inputString) {
        int input = Integer.parseInt(inputString);
        numbers = new Numbers(input);
    }

    private void resetScore() {
        this.countBall = 0;
        this.countStrike = 0;
    }

    public void playRound() {
        List<Hint> hints = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            hints.add(getHint(i));
        }
    }

    private Hint getHint(int index) {
        if (isStrike(index)) {
            return Hint.STRIKE;
        }
        if (isBall(index)) {
            return Hint.BALL;
        }
        return Hint.NOTHING;
    }

    private boolean isBall(int index) {
        // 이전 인덱스 : 0 -> 2
        int prevIndex = (index + 2) % 3;
        // 이후 인덱스 : 2 -> 0;
        int nextIndex = (index + 1) % 3;

        boolean isPrevBall = computer.findComputerNumber(prevIndex)
                .equals(numbers.findNumber(index));
        boolean isNextBall = computer.findComputerNumber(nextIndex)
                .equals(numbers.findNumber(index));

        return  isPrevBall || isNextBall;
    }

    private boolean isStrike(int index) {
        return computer.findComputerNumber(index)
                .equals(numbers.findNumber(index));
    }
}
