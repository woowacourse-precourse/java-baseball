package baseball.util.input;

import baseball.domain.NumberBall;
import baseball.util.GameExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberBallsInput implements UserInput {
    private final String numberBallsInput;
    private final int MIN_BALL_NUMBER = '1';
    private final int MAX_BALL_NUMBER = '9';
    private final int BALL_LENGTH = 3;

    public NumberBallsInput() {
        numberBallsInput = get();
    }

    @Override
    public void validate(String input) {
        if (!supportsInputLength(input)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }

        if (!supportsNumberRange(input)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_RANGE);
        }

        if (includesDuplicateNumber(input)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }
    }

    private boolean includesDuplicateNumber(String userInput) {
        String exceptDuplicateUserInput = Stream.of(userInput.split("")).distinct().collect(Collectors.joining());
        return !supportsInputLength(exceptDuplicateUserInput);
    }

    private boolean supportsNumberRange(String userInput) {
        return userInput.chars().allMatch(this::fromOneToNine);
    }

    private boolean fromOneToNine(int character) {
        return character >= MIN_BALL_NUMBER && character <= MAX_BALL_NUMBER;
    }

    private boolean supportsInputLength(String userInput) {
        return userInput.length() == BALL_LENGTH;
    }

    public List<NumberBall> toNumberBalls() {
        return Stream.of(numberBallsInput.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(NumberBall::new)
                .collect(Collectors.toList());
    }
}
