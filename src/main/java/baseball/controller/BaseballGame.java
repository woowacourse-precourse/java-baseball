package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballGame {
    private static final Input inputView = new Input();
    ComputerNumber computerNumber = new ComputerNumber();

    private final String correctNumber = computerNumber.getBaseballNumber();

    private boolean exit = false;

    private int strike = 0;
    private int ball = 0;

    public void startGame() {
        Output.baseballStartMessage();

        do {
            System.out.println(correctNumber);
            String input = inputView.inputNumber();
            resetScore();
            compareNumber(input);
            Output.baseballResult(strike, ball);

            if (strike == 3) {
                exit = true;
            }
        } while (!exit);
    }
    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    public void compareNumber(String input) {
        for (int i = 0; i < 3; i++) {
            char onePlayerNumber = input.charAt(i);
            if (isStrike(onePlayerNumber, i))
                strike++;
            if (isBall(onePlayerNumber, i))
                ball++;
        }
    }

    private boolean isStrike(char onePlayerNum, int idx) {
        return correctNumber.charAt(idx) == onePlayerNum;
    }

    private boolean isBall(char onePlayerNum, int idx) {
        for (int i = 0; i < 3; i++) {
            if (i == idx) {
                continue;
            }
            if (correctNumber.charAt(i) == onePlayerNum) {
                return true;
            }
        }
        return false;

    }

}
