package baseball.counter;

import java.util.List;

public class Counter {

    private int strikeCount;
    private int ballCount;

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private void initCount() {
        strikeCount = 0;
        ballCount = 0;
    }

    public void count(List<Integer> userNumbers, List<Integer> computerNumbers) {
        initCount();
        for (int i = 0; i < 3; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (computerNumber == userNumber) {
                strikeCount++;
            } else if (userNumbers.contains(computerNumber)) {
                ballCount++;
            }
        }
    }
}
