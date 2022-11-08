package baseball;

public class Calculator {

    private static final int NumberLength = 3;
    private static int ballNum = 0;
    private static int strikeNum = 0;

    Calculator() {
    }

    public int getBallNum() {
        return ballNum;
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public void addBall() {
        ballNum++;
    }

    public void addStrike() {
        strikeNum++;
    }

    public boolean IsBall(int computerOneNumber, String userNumber) {
        return userNumber.contains(Integer.toString(computerOneNumber));
    }

    public boolean IsStrike(int computerOneNumber, int userOneNumber) {
        return computerOneNumber == userOneNumber;
    }

    public void calculateNum(String computerNumber, String userNumber) {
        ballNum = 0;
        strikeNum = 0;
        for (int i = 0; i < NumberLength; i++) {
            if (IsStrike(computerNumber.charAt(i) - '0', userNumber.charAt(i) - '0')) {
                addStrike();
                continue;
            }
            if (IsBall(computerNumber.charAt(i) - '0', userNumber)) {
                addBall();
            }
        }
    }
}
