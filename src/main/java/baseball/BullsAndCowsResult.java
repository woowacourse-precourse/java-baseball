package baseball;

import static baseball.message.Message.END_MESSAGE;
import static baseball.message.Message.NOTHING_MESSAGE;

public class BullsAndCowsResult {

    private int ballCount;
    private int strikeCount;

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void init() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void addCount(int userIndex, int computerIndex) {
        if (userIndex == -1) {
            return;
        }

        if (userIndex == computerIndex) {
            strikeCount++;
            return;
        }

        ballCount++;
    }

    public void printResult() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING_MESSAGE);
        } else if (isFinish()) {
            System.out.println("3스트라이크");
            System.out.println(END_MESSAGE);
        } else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼 ");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
    }

    public boolean isFinish() {
        return strikeCount == 3;
    }
}
