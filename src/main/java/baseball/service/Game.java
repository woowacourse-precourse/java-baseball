package baseball.service;

import baseball.domain.Number;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private Game() {
    }

    public static void start() {
        Numbers computer = new Numbers(getComputerInput());
    }

    private static List<Number> getComputerInput() {
        return IntStream.range(0, 3)
                .map(n -> Randoms.pickNumberInRange(1, 9))
                .mapToObj(Number::new)
                .collect(Collectors.toList());
    }
}
