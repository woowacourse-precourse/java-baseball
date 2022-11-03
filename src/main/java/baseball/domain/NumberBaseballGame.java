package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NumberBaseballGame {
    private ScoreBoard scoreBoard;

    private List<NumberBall> initializeSystemNumberBall() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return numbers.stream().map(NumberBall::new).collect(Collectors.toList());
    }
}