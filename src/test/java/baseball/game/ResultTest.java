package baseball.game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("스트라이크와 볼 개수에 따라 결과를 반환하는데 성공한다")
    @Test
    void 스트라이크와_볼_개수에_따라_결과반환_성공() {
        // given
        Result result = new Result();

        // when
        GameResult threeStrike = result.getGameResult(3, 0);
        GameResult nothing = result.getGameResult(0, 0);
        GameResult etc = result.getGameResult(2, 1);

        // then
        assertAll(
                () -> Assertions.assertThat(threeStrike).isEqualTo(GameResult.THREE_STRIKE),
                () -> Assertions.assertThat(nothing).isEqualTo(GameResult.NOTHING),
                () -> Assertions.assertThat(etc).isEqualTo(GameResult.ETC)
        );
    }
}