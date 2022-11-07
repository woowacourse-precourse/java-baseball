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
        List<Integer> thrownBallList = initThrownBallList();
        return new Balls(IntStream.range(0, count)
                        .mapToObj(order -> throwRandomBall(thrownBallList, order))
                        .collect(Collectors.toList()));
    }

    private Ball throwRandomBall(List<Integer> thrownBallList, int order) {
        return new Ball(getNotDuplicatedRandomNumber(thrownBallList), order);
    }

    private int getNotDuplicatedRandomNumber(List<Integer> thrownBallList) {
        while (true) {
            int number = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
            if (isNotDuplicated(thrownBallList, number)) {
                thrownBallList.set(number, 1);
                return number;
            }
        }
    }

    private boolean isNotDuplicated(List<Integer> thrownBallList, int number) {
        return thrownBallList.get(number) == 0;
    }

    private List<Integer> initThrownBallList() {
        List<Integer> thrownBallList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(order -> thrownBallList.add(0));
        return thrownBallList;
    }
}
