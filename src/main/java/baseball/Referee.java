package baseball;

import view.Message;

public class Referee {
    private int strikeCount;
    private int ballCount;

    public static final int INDEX_NOT_FOUND = -1;

    public Referee() {
        initCount();
    }

    public void initCount(){
        strikeCount = 0;
        ballCount = 0;
    }

    public void judge(String answer, String userNumber) {
        setStrikeCount(answer, userNumber);
        setBallCount(answer, userNumber);
    }

    private void setStrikeCount(String answer, String userNumber) {
        int count = 0;

        for (int index = 0; index < answer.length(); index++) {
            if (isStrike(answer, userNumber, index)) {
                count++;
            }
        }
        strikeCount = count;
    }

    private void setBallCount(String answer, String userNumber) {
        int count = 0;

        for (int index = 0; index < userNumber.length(); index++) {
            if (isBall(answer.indexOf(userNumber.charAt(index)), index)) {
                count++;
            }
        }
        ballCount = count;
    }

    private boolean isStrike(String answer, String userNumber, int i) {
        return answer.charAt(i) == userNumber.charAt(i);
    }

    private Boolean isBall(int findIndexWithUserChar, int userNumberCharIndex) {
        return (findIndexWithUserChar != INDEX_NOT_FOUND && findIndexWithUserChar != userNumberCharIndex);
    }

    public void showResult() {
        Message.showGameResultMessage(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
