package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pitcher {
    private List<Integer> thrownBallList;

    public Pitcher() {
        initThrownBallList();
    }

    public List<Ball> throwRandomBalls(int count) {
        return IntStream.range(0, count)
                .mapToObj(this::throwRandomBall)
                .collect(Collectors.toList());
    }

    private Ball throwRandomBall(int order) {
        return new Ball(getNotDuplicatedRandomNumber(), order);
    }

    private int getNotDuplicatedRandomNumber() {
        while (true) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (isNotDuplicated(number)) {
                thrownBallList.set(number, 1);
                return number;
            }
        }
    }

    private boolean isNotDuplicated(int number) {
        return thrownBallList.get(number) == 0;
    }

    public void initThrownBallList() {
        thrownBallList = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(order -> thrownBallList.add(0));
    }
}
