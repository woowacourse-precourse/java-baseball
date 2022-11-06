package baseball;

import constantfield.*;

public class Messenger {
    private String message = "";

    public void printResultMessage(AnswerChecker answerChecker) {
        makeResultMessage(answerChecker.getStrikeCnt(), answerChecker.getBallCnt());
        System.out.println(message);
    }

    public void makeResultMessage(int strikeCnt, int ballCnt) {
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

    public boolean selectRepalyOrEnd(String userOpinion) {
        return userOpinion.equals(Message.REPLAY);
    }
}
