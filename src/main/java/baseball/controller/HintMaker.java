package baseball.controller;

import baseball.view.Printer;
import java.util.List;

public class HintMaker {
    private static final int NUMBER_LENGTH = 3;
    private int ball;
    private int strike;

    public HintMaker() {
        this.ball = 0;
        this.strike = 0;
    }

    public void init() {
        this.ball = 0;
        this.strike = 0;
    }

    public boolean isAnswer(List<Integer> userInput, List<Integer> answer) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userInput.get(i) != answer.get(i)) {
                init();
                increaseStrike(userInput, answer);
                increaseBall(userInput, answer);
                printHint(this.ball, this.strike);
                return false;
            }
        }
        Printer.printEnd();
        return true;
    }

    private void increaseStrike(List<Integer> userInput, List<Integer> answer) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            if (userInput.get(i) == answer.get(i)) {
                this.strike++;
            }
        }
    }

    private void increaseBall(List<Integer> userInput, List<Integer> answer) {
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            increaseBallByElements(userInput.get(i), i, answer);//TODO: 수정 필요
        }
    }

    private void increaseBallByElements(Integer integer, int i, List<Integer> answer) {
        for (int j = 0; j < NUMBER_LENGTH; j++) {
            if (j != i && integer == answer.get(j)) {
                this.ball++;
            }
        }
    }

    private static void printHint(int ball, int strike) {

        if (ball == 0 && strike == 0) {
            Printer.printNothing();
        }
        if (ball > 0 && strike > 0) {
            Printer.printStrikeAndBall(ball, strike);
        }
        if (ball > 0 && strike == 0) {
            Printer.printOnlyBall(ball);
        }
        if (ball == 0 && strike > 0) {
            Printer.printOnlyStrike(strike);
        }
    }
}
