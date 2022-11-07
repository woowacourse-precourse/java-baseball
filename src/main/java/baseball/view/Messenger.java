package baseball.view;

import baseball.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Messenger {

    public void printStartMessage() {
        System.out.print(PrintMessages.START.getMessage());
    }

    public void printInputMessage() {
        System.out.print(PrintMessages.INPUT.getMessage());
    }

    public void printAnswerMessage() {
        System.out.print(PrintMessages.ANSWER.getMessage());
    }

    public void printRestartOrEndMessage() {
        System.out.print(PrintMessages.RESTART_OR_END.getMessage());
    }

    public void printResultMessage(int strike, int ball) {
        System.out.print(makeResultMessage(strike, ball));
    }

    public String makeResultMessage(int strike, int ball) {
        List<String> decisions = new ArrayList<>();
        String countMessage;
        if (!isZero(ball)) {
            countMessage = String.format(PrintMessages.BALL.getMessageForIntegerFormatting(), ball);
            decisions.add(countMessage);
        }
        if (!isZero(strike)) {
            countMessage = String.format(PrintMessages.STRIKE.getMessageForIntegerFormatting(), strike);
            decisions.add(countMessage);
        }
        if (isZero(ball) && isZero(strike)) {
            countMessage = PrintMessages.NOTHING.getMessage();
            decisions.add(countMessage);
        }
        return String.join(Constant.SPACE_STRING, decisions) + Constant.NEW_LINE_STRING;
    }

    private boolean isZero(int number) {
        return number == Constant.ZERO_NUM;
    }
}
