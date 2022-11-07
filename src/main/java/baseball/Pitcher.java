package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pitcher {
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;
    
    public Balls throwRandomBalls(int count) {
        List<Boolean> thrownBallList = initThrownBallList();
        return new Balls(IntStream.range(0, count)
                        .mapToObj(order -> throwRandomBall(thrownBallList, order))
                        .collect(Collectors.toList()));
    }

    private Ball throwRandomBall(List<Boolean> thrownBallList, int order) {
        return new Ball(getNotDuplicatedRandomNumber(thrownBallList), order);
    }

    private int getNotDuplicatedRandomNumber(List<Boolean> thrownBallList) {
        while (true) {
            int number = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
            if (isNotDuplicated(thrownBallList, number)) {
                thrownBallList.set(number, true);
                return number;
            }
        }
    }

    private boolean isNotDuplicated(List<Boolean> thrownBallList, int number) {
        return !thrownBallList.get(number);
    }

    private List<Boolean> initThrownBallList() {
        List<Boolean> thrownBallList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(order -> thrownBallList.add(false));
        return thrownBallList;
    }
}
