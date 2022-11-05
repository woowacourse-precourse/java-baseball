package baseball.refree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.BallStrikeConstant;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultHandlerTest {
    @Test
    void 볼스트라이크맞는지확인1() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(4, 5, 6));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.NOTHING);
    }

    @Test
    void 볼스트라이크맞는지확인2() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(2, 5, 6));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.ONE_BALL);
    }

    @Test
    void 볼스트라이크맞는지확인3() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(1, 3, 6));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.ONE_BALL_ONE_STRIKE);
    }

    @Test
    void 볼스트라이크맞는지확인4() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.THREE_STRIKE);
    }
}