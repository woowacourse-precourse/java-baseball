package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class Messenger {

    public void printStartMessage() {
        System.out.print(Messages.START.getMessage());
    }

    public void printInputMessage() {
        System.out.print(Messages.INPUT.getMessage());
    }

    public void printAnswerMessage() {
        System.out.print(Messages.ANSWER.getMessage());
    }

    public void printRestartOrEndMessage() {
        System.out.print(Messages.RESTART_OR_END.getMessage());
    }

    public void printResultMessage(int strike, int ball) {
        List<String> decisions = new ArrayList<>();
        String countMessage;
        if (!isZero(ball)) {
            countMessage = String.format("%d" + Messages.BALL.getMessage(), ball);
            decisions.add(countMessage);
        }
        if (!isZero(strike)) {
            countMessage = String.format("%d" + Messages.STRIKE.getMessage(), strike);
            decisions.add(countMessage);
        }
        if (isZero(ball) && isZero(strike)) {
            countMessage = Messages.NOTHING.getMessage();
            decisions.add(countMessage);
        }
        System.out.print(String.join(" ", decisions) + "\n");
    }

    private boolean isZero(int number) {
        return number == 0;
    }
}
