package baseball.view;

import static baseball.constant.Finish.getFinishByCode;
import static baseball.hint.Hint.BALL;
import static baseball.hint.Hint.NOTHING;
import static baseball.hint.Hint.STRIKE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constant.Finish;
import baseball.hint.Hint;
import baseball.input.InputController;
import java.util.List;

public class ConsoleView implements View {

    private final InputController inputController;

    public ConsoleView(InputController inputController) {
        this.inputController = inputController;
    }

    @Override
    public List<Integer> inputIntegerList() {
        String input = inputString();
        return inputController.convertToIntegerList(input);
    }

    @Override
    public void printHint(Hint hint) {
        String hintMessage = convertHint(hint);
        System.out.println(hintMessage);
    }

    @Override
    public void printInlineMessage(String message) {
        System.out.print(message);
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Finish inputFinishCode() {
        String input = readLine();
        return getFinishByCode(input);
    }

    private String convertHint(Hint hint) {
        StringBuilder stringBuilder = new StringBuilder();
        int ball = hint.getBall();
        int strike = hint.getStrike();
        if (ball > 0) {
            stringBuilder.append(ball).append(BALL);
        }
        if (strike > 0) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(strike).append(STRIKE);
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append(NOTHING);
        }
        return stringBuilder.toString();
    }

    private String inputString() {
        String input = readLine();
        if (!inputController.checkValidAnswer(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }
}