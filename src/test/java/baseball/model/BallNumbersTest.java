package baseball.model;

import baseball.BallInputException;
import baseball.model.BallNumber;
import baseball.model.BallNumbers;
import baseball.model.BaseBallHitsType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BallNumbersTest {
    private static Stream<Arguments> provideInput() {
        return Stream.of(
                Arguments.of(List.of('1', '2', '2')),
                Arguments.of(List.of('2', '3', '1', '4')),
                Arguments.of(List.of('1','0','9'))
        );
    }

    @Test
    void roundResult() {
        List<Character> homeRun = List.of('1', '2', '3');

        BallNumbers ballNumbers = new BallNumbers(homeRun);

        assertAll(() -> assertEquals(ballNumbers.roundResult(2, BallNumber.ballNumber('1')), BaseBallHitsType.BALL.getBallRules()),
                () -> assertEquals(ballNumbers.roundResult(2, BallNumber.ballNumber('3')), BaseBallHitsType.STRIKE.getBallRules()),
                () -> assertEquals(ballNumbers.roundResult(0, BallNumber.ballNumber('0')), BaseBallHitsType.NOTING.getBallRules())
        );
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void if_wrong_list(List<Character> input) {
        assertThrows(BallInputException.class, () -> new BallNumbers(input));
    }
}