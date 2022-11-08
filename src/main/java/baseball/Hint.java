package baseball;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public enum Hint {
    NOTHING(count -> "낫싱", count -> count.getBallCount() == 0 && count.getStrikeCount() == 0),
    ONLY_BALL(count -> String.format("%s볼", count.getBallCount()), count -> count.getBallCount() >= 1 && count.getStrikeCount() == 0),
    ONLY_STRIKE(count -> String.format("%s스트라이크", count.getStrikeCount()), count -> count.getBallCount() == 0 && count.getStrikeCount() >= 1),
    BALL_AND_STRIKE(count -> String.format("%s볼 %s스트라이크", count.getBallCount(), count.getStrikeCount()), count -> count.getBallCount() >= 1 && count.getStrikeCount() >= 1);

    private final Function<Count, String> messageExpression;
    private final Predicate<Count> conditionalExpression;

    Hint(Function<Count, String> messageExpression, Predicate<Count> conditionalExpression) {
        this.messageExpression = messageExpression;
        this.conditionalExpression = conditionalExpression;
    }

    public static void show(Count count) {
        System.out.println(Arrays.stream(values())
                .filter(hint -> hint.conditionalExpression.test(count))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값이 입력되었습니다."))
                .getMessage(count));
    }

    private String getMessage(Count count) {
        return messageExpression.apply(count);
    }
}
