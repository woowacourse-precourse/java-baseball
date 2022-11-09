package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
                () -> assertThat(threeStrike).isEqualTo(GameResult.THREE_STRIKE),
                () -> assertThat(nothing).isEqualTo(GameResult.NOTHING),
                () -> assertThat(etc).isEqualTo(GameResult.ETC)
        );
    }
}