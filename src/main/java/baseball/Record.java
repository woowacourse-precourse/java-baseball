package baseball;

import java.util.List;

public class Record {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static final int ZERO = 0;

    int ballCount;
    int strikeCount;

    public void setEachCounts(Game computer, Game user) {

        List<Integer> computerNumbers = computer.numbers;
        List<Integer> userNumbers = user.numbers;

        for (int i = 0; i < ReferenceValue.SIZE; i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);

            if (userNumber == computerNumber) {
                strikeCount++;
                continue;
            }
            if (computerNumbers.contains(userNumber)) {
                ballCount++;
            }
        }
    }
    public void displayRecord() {
        String record = "";

        if (ballCount > ZERO && strikeCount > ZERO) {
            record = ballCount + BALL + " " + strikeCount + STRIKE;
        } else if (ballCount > ZERO) {
            record = ballCount + BALL;
        } else if (strikeCount > ZERO) {
            record = strikeCount + STRIKE;
        } else if (ballCount == ZERO && strikeCount == ZERO) {
            record = NOTHING;
        }

        System.out.println(record);
    }
}
