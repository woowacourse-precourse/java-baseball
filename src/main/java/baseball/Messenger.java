package baseball;

public class Messenger {
    private String message = "";

    public void printResultMessage (AnswerChecker answerChecker) {
        makeResultMessage(answerChecker.getStrikeCnt(), answerChecker.getBallCnt());
        System.out.println(message);
    }

    public void makeResultMessage (int strikeCnt, int ballCnt) {
        if (ballCnt > 0) {
            message += ballCnt + "볼 ";
        }
        if (strikeCnt > 0) {
            message += strikeCnt + "스트라이크";
        }
        if (message.equals("")) {
            message = "낫싱";
        }
    }

    public boolean selectRepalyOrEnd (String userOpinion) {
        return userOpinion.equals("1");
    }
}
