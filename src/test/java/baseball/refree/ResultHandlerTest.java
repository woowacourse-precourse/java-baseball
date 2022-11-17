package baseball.refree;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import baseball.constant.BallStrikeConstant;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultHandlerTest {
    @Test
    void 낫싱() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(4, 5, 6));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.NOTHING);
    }

    @Test
    void 원볼() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(2, 5, 6));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.ONE_BALL);
    }

    @Test
    void 원볼원스트라이크() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(2, 5, 3));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.ONE_BALL_ONE_STRIKE);
    }


    @Test
    void 투볼() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(2, 5, 1));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.TWO_BALL);
    }

    @Test
    void 투볼원스트라이크() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(1, 3, 2));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.TWO_BALL_ONE_STRIKE);
    }

    @Test
    void 쓰리볼() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(2, 3, 1));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.THREE_BALL);
    }

    @Test
    void 쓰리스트라이크() {
        BallStrikeConstant ballStrikeResult = ResultHandler.createBallStrikeResult(List.of(1, 2, 3), List.of(1, 2, 3));
        assertThat(ballStrikeResult).isEqualTo(BallStrikeConstant.THREE_STRIKE);
    }


}