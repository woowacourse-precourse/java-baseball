package baseball.compare;

import java.util.List;
import java.util.Optional;

public class Referee {

    public static Optional<ComparisonResultType> judge(Integer userNumber, Integer index,
            List<Integer> opponentNumbers) {
        if (opponentNumbers.get(index).equals(userNumber)) {
            return Optional.of(ComparisonResultType.STRIKE);
        }

        if (opponentNumbers.contains(userNumber)) {
            return Optional.of(ComparisonResultType.BALL);
        }

        return Optional.empty();
    }
}
