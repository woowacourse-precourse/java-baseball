package baseball.util.input;

import baseball.domain.NumberBall;
import baseball.util.GameExceptionMessage;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberBallsInput implements UserInput {
    private final String numberBallsInput;
    public static final int BALL_COUNT = 3;

    public NumberBallsInput() {
        numberBallsInput = get();
    }

    @Override
    public void validate(String input) {
        if (!supportsInputLength(input)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }

        try {
            hasNumber(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }

        if (includesDuplicateNumber(input)) {
            throw new IllegalArgumentException(GameExceptionMessage.USER_NUMBER_LENGTH);
        }
    }

    private boolean includesDuplicateNumber(String userInput) {
        String exceptDuplicateUserInput = Stream.of(userInput.split("")).distinct().collect(Collectors.joining());
        return !supportsInputLength(exceptDuplicateUserInput);
    }

    private void hasNumber(String userInput) {
        Integer.parseInt(userInput);
    }

    private boolean supportsInputLength(String userInput) {
        return userInput.length() == BALL_COUNT;
    }

    public List<NumberBall> toNumberBalls() {
        return Stream.of(numberBallsInput.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(NumberBall::new)
                .collect(Collectors.toList());
    }
}
