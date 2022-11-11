package baseball.game.generator;

import baseball.game.model.TargetNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public TargetNumber createTargetNumber(int length) {

        return new TargetNumber(
                Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                        .distinct()
                        .limit(length)
                        .collect(Collectors.toList())
        );
    }
}
