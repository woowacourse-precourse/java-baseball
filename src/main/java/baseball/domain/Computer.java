package baseball.domain;

import static baseball.BaseballGame.INPUT_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Computer {
    private BallNumber ballNumber;

    public void generateComputerNumber() {
        ballNumber = BallNumber.fromIntegerList(Stream.generate(() -> Randoms.pickNumberInRange(0, 9))
                .distinct()
                .limit(INPUT_SIZE)
                .collect(Collectors.toList()));
    }

    public BallNumber getBallNumber() {
        return ballNumber;
    }
}
