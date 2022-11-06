package baseball;

import baseball.model.BallNumber;
import baseball.model.BallNumbers;
import baseball.model.BaseBallHitsType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallNumbersTest {

    @Test
    void roundResult() {
        List<Character> homeRun = List.of('1', '2', '3');

        BallNumbers ballNumbers = new BallNumbers(homeRun);

        assertAll(() -> assertEquals(ballNumbers.roundResult(2, BallNumber.ballNumber('1')), BaseBallHitsType.BALL.getBallRules()),
                () -> assertEquals(ballNumbers.roundResult(2, BallNumber.ballNumber('3')), BaseBallHitsType.STRIKE.getBallRules()),
                () -> assertEquals(ballNumbers.roundResult(0, BallNumber.ballNumber('0')), BaseBallHitsType.NOTING.getBallRules())
        );
    }
}