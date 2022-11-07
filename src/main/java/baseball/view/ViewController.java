package baseball.view;

import baseball.configuration.InputConfigure;
import baseball.entity.Type;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static baseball.entity.NumberBaseball.GAME_ANSWER_MAX_VALUE;

public class ViewController {

    private final Display display;

    public ViewController() {
        this.display = new Display();
    }

    public void closeBufferedWriter() {
        display.closeBufferedWriter();
    }

    public void printGameStartMessage() {
        display.printInitMessage();
    }

    public String printAndInputNumber() {
        display.printInputNumberMessage();
        String input = Console.readLine();
        InputConfigure.verifyInput(input);
        return input;
    }

    public boolean printRoundResult(Map<Type, Integer> resultMap) {
        int ball = resultMap.get(Type.BALL);
        int strike = resultMap.get(Type.STRIKE);

        printBallStrikeNothing(ball, strike);

        if (checkThreeStrike(strike)) {
            display.printEndingMessage();
            return true;
        }
        return false;
    }

    private void printBallStrikeNothing(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            display.printNothingMessage();
            display.printNewLine();
            return;
        }

        if (ball > 0 && strike > 0) {
            display.printBallAndStrikeMessage(ball, strike);
            display.printNewLine();
            return;
        }

        if (ball > 0) {
            display.printBallMessage(ball);
        }
        if (strike > 0) {
            display.printStrikeMessage(strike);
        }
        display.printNewLine();
    }

    private boolean checkThreeStrike(int strike) {
        return strike == GAME_ANSWER_MAX_VALUE;
    }

    public boolean printReGameAndInput() {
        display.printReGameMessage();

        String input = Console.readLine();
        InputConfigure.verifyReGameInput(input);

        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
