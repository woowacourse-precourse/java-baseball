package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int BALL_COUNT = 3;

    public static String generateNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() != BALL_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer.stream().map(String::valueOf).collect(Collectors.joining());
    }

}