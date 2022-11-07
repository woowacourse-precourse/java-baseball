package baseball;

import constantfield.*;

public class Messenger {
    private String message = "";

    public Messenger(AnswerChecker answerChecker) {
        makeResultMessage(answerChecker);
    }

    public void makeResultMessage(AnswerChecker answerChecker) {
        int strikeCnt = answerChecker.getStrikeCnt();
        int ballCnt = answerChecker.getBallCnt();

        if (ballCnt > Detail.ZERO_COUNT) {
            message += ballCnt + Message.BALL;
        }
        if (strikeCnt > Detail.ZERO_COUNT) {
            message += strikeCnt + Message.STRIKE;
        }
        if (message.equals("")) {
            message = Message.NOTHING;
        }
    }

    public void printResultMessage() {
        System.out.println(message);
    }

    public boolean selectRepalyOrEnd(String userOpinion) {
        return userOpinion.equals(Message.REPLAY);
    }
}
