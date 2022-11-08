package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RandomBallNumbersGenerator {

    private static final int RANDOM_NUMBER_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public List<BallNumber> createRandomBallNumbers() {
        AtomicInteger cnt = new AtomicInteger();
        return getRandomNumbers().stream()
                .map(number -> new BallNumber(cnt.getAndIncrement(), number))
                .collect(Collectors.toList());
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> ballNumberList = new ArrayList<>();
        while (ballNumberList.size() < RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (duplicateCheck(ballNumberList, randomNumber)) {
                ballNumberList.add(randomNumber);
            }
        }
        return ballNumberList;
    }

    private boolean duplicateCheck(List<Integer> ballNumberList, int randomNumber) {
        return !ballNumberList.contains(randomNumber);
    }
}
