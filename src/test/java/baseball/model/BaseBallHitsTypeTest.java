package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallHitsTypeTest {
    @Test
    void findStrike() {
        BallNumbers homeRun = new BallNumbers(List.of('1', '2', '3'));
        BallNumbers input = new BallNumbers(List.of('3', '2', '1'));
        assertThat(BaseBallHitsType.findBallHitType(homeRun, input,1)).isEqualTo(BaseBallHitsType.STRIKE);
    }

}