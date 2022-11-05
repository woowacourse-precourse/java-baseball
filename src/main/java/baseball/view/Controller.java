package baseball.view;

import baseball.configuration.InputConfigure;
import baseball.entity.Type;
import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

import static baseball.entity.NumberBaseball.GAME_ANSWER_MAX_VALUE;
import static baseball.view.Display.printReGameMessage;

public class Controller {

    private final Display display;

    public Controller() {
        this.display = new Display();
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

        if(checkThreeStrike(strike)) {
            return true;
        }

        printBallStrikeNothing(ball, strike);
        return false;
    }

    private void printBallStrikeNothing(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            display.printNothingMessage();
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
        printReGameMessage();

        String input = Console.readLine();
        InputConfigure.verifyReGameInput(input);

        if (input.equals("1")) {
            return true;
        }
        return false;
    }
}
