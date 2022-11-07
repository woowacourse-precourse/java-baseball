package baseball.hint;

import baseball.baesball.Baseball;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HintGenerator {
    public Hint generate(Baseball computerBaseball, Baseball playerBaseball) {
        List<Integer> computer = computerBaseball.getBaseballs();
        List<Integer> player = playerBaseball.getBaseballs();
        List<HintType> hints = IntStream.range(0, computer.size())
                .mapToObj(ballIndex -> {
                    Integer computerBall = computer.get(ballIndex);
                    Integer playerBall = player.get(ballIndex);
                    if (matchNumber(computerBall, playerBall)) {
                        return HintType.STRIKE;
                    }
                    if (matchAnyNumber(computerBall, player)) {
                        return HintType.BALL;
                    }
                    return HintType.NOTHING;
                }).collect(Collectors.toUnmodifiableList());

        return new Hint(hints);
    }

    private boolean matchAnyNumber(Integer matchNumber, List<Integer> target) {
        return target.stream()
                .anyMatch(number -> Objects.equals(number, matchNumber));
    }

    private boolean matchNumber(Integer matchNumber, Integer target) {
        return Objects.equals(matchNumber, target);
    }
}
