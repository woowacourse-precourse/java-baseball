package baseball;

import static baseball.constant.Finish.getFinishByCode;
import static baseball.constant.Hint.BALL;
import static baseball.constant.Hint.NOTHING;
import static baseball.constant.Hint.STRIKE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constant.Finish;
import java.util.List;

public class ConsoleView implements View {

    private final InputController inputController;

    public ConsoleView(InputController inputController) {
        this.inputController = inputController;
    }

    public List<Integer> inputIntegerList() {
        String input = inputString();
        return inputController.convertToIntegerList(input);
    }

    public void printHint(Hint hint) {
        String hintMessage = convertHint(hint);
        System.out.println(hintMessage);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

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