package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class HomeRunStrategy implements BallNumbersCreateStrategy {
    private static final int MAX = 3;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 9;

    @Override
    public List<Integer> createBallNumbers() {
        List<Integer> result = new ArrayList<>();

        while (result.size() < MAX) {
            int random = Randoms.pickNumberInRange(RANGE_MIN, RANGE_MAX);
            addRandom(result, random);
        }

        return result;
    }

    private static void addRandom(List<Integer> result, int random) {
        if (!duplicate(result, random)) {
            result.add(random);
        }
    }

    private static boolean duplicate(List<Integer> result, int random) {
        return result.contains(random);
    }
}
