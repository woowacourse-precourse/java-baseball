package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class GameNumberCalculatorService {
    private static final int NUMBER_LENGTH = 3;
    private int ballCount;
    private int strikeCount;
    private List<Integer> strikeAndBallCountList = new ArrayList<>();

    public void resetCalculator() {
        strikeAndBallCountList.clear();
        ballCount = 0;
        strikeCount = 0;
    }
}
