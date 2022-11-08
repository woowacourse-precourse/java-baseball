package baseball.util.input;

import baseball.domain.NumberBall;
import baseball.util.GameExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberBallsInput {
    private final String numberBallsInput;
    public static final int BALL_COUNT = 3;

    public NumberBallsInput(String numberBallsInput) {
        validate(numberBallsInput);
        this.numberBallsInput = numberBallsInput;
    }

    public void validate(String numberBallsInput) {
        if (supportsNumberBallsInputLength(numberBallsInput) &&
                hasNumber(numberBallsInput) &&
                !includesDuplicateNumber(numberBallsInput)
        ) {
            return;
        }
        throw new IllegalArgumentException(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
    }

    private boolean includesDuplicateNumber(String numberBallsInput) {
        String exceptDuplicateUserInput = Stream.of(numberBallsInput.split(""))
                .distinct()
                .collect(Collectors.joining());
        return !supportsNumberBallsInputLength(exceptDuplicateUserInput);
    }

    private boolean hasNumber(String numberBallsInput) {
        try {
            Integer.parseInt(numberBallsInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean supportsNumberBallsInputLength(String numberBallsInput) {
        return !numberBallsInput.isBlank() && numberBallsInput.length() == BALL_COUNT;
    }

    public List<NumberBall> toNumberBalls() {
        return Stream.of(numberBallsInput.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(NumberBall::new)
                .collect(Collectors.toList());
    }
}
