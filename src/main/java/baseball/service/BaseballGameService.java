package baseball.service;


import java.util.List;

public class BaseballGameService {
    private static int strikeCount;
    private static int ballCount;

    private final int NUMBER_LENGTH = 3;

    public void updateStrikeCount(List<Integer> computerNumber, List<Integer> userNumber) {
        strikeCount = 0;
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (computerNumber.get(index).equals(userNumber.get(index))) {
                strikeCount++;
            }
        }
    }

}


