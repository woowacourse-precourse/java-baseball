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
        if (!supportsNumberBallsInputLength(numberBallsInput)) {
            throw new IllegalArgumentException(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
        }

        try {
            hasNumber(numberBallsInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
        }

        if (includesDuplicateNumber(numberBallsInput)) {
            throw new IllegalArgumentException(GameExceptionMessage.ENTER_THREE_DIFFERENT_NUMBER);
        }
    }

    private boolean includesDuplicateNumber(String numberBallsInput) {
        String exceptDuplicateUserInput = Stream.of(numberBallsInput.split(""))
                .distinct()
                .collect(Collectors.joining());
        return !supportsNumberBallsInputLength(exceptDuplicateUserInput);
    }

    private void hasNumber(String numberBallsInput) {
        Integer.parseInt(numberBallsInput);
    }

    private boolean supportsNumberBallsInputLength(String numberBallsInput) {
        return numberBallsInput.length() == BALL_COUNT;
    }

    public List<NumberBall> toNumberBalls() {
        return Stream.of(numberBallsInput.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(NumberBall::new)
                .collect(Collectors.toList());
    }
}
