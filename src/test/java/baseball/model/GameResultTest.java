package baseball.model;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 스트라이크_수_세기() {
        GameResult threeStrike = new GameResult(List.of(1, 2, 3), List.of(2, 3, 1));
        GameResult twoStrike = new GameResult(List.of(1, 2, 3), List.of(2, 3, 4));
        GameResult zeroStrike = new GameResult(List.of(1, 2, 3), List.of(6, 4, 3));

        Assertions.assertThat(threeStrike.isSameStrikeCount(3))
            .isTrue();
        Assertions.assertThat(twoStrike.isSameStrikeCount(2))
            .isTrue();
        Assertions.assertThat(zeroStrike.isSameStrikeCount(0))
            .isTrue();
    }
}