package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNumberTest {
    @Test
    void 야구공_개수가_3개가_아니라면_오류를_던진다() {
        // given
        List<BallNumber> testBallNumberSet = new ArrayList<>();
        testBallNumberSet.add(new BallNumber(1));
        testBallNumberSet.add(new BallNumber(2));
        testBallNumberSet.add(new BallNumber(3));
        testBallNumberSet.add(new BallNumber(4));

        // when, then
        assertThatThrownBy(() -> new PlayerNumber(testBallNumberSet))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
