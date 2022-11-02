package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Baseball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BALL_COUNT = 3;

    public static int generateNumber() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, BALL_COUNT);
        String ballNumber = list.stream().map(String::valueOf).collect(Collectors.joining());
        return Integer.parseInt(ballNumber);
    }

}
