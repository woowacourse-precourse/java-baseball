package baseball.model;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 스트라이크_수_세기() {
        GameResult threeStrike = new GameResult(List.of(1, 2, 3), List.of(1, 2, 3));
        GameResult oneStrike = new GameResult(List.of(1, 2, 3), List.of(1, 3, 2));
        GameResult zeroStrike = new GameResult(List.of(1, 2, 3), List.of(2, 3, 1));

        Assertions.assertThat(threeStrike.getStrikeCount())
                .isEqualTo(3);
        Assertions.assertThat(oneStrike.getStrikeCount())
                .isEqualTo(1);
        Assertions.assertThat(zeroStrike.getStrikeCount())
                .isEqualTo(0);
    }

    @Test
    void 볼_수_세기() {
        GameResult zeroBall = new GameResult(List.of(1, 2, 3), List.of(1, 2, 3));
        GameResult twoBall = new GameResult(List.of(1, 2, 3), List.of(1, 3, 2));
        GameResult threeBall = new GameResult(List.of(1, 2, 3), List.of(2, 3, 1));

        Assertions.assertThat(zeroBall.getBallCount())
                .isEqualTo(0);
        Assertions.assertThat(twoBall.getBallCount())
                .isEqualTo(2);
        Assertions.assertThat(threeBall.getBallCount())
                .isEqualTo(3);
    }

    @Test
    void 낫싱인지_확인() {
        GameResult nothing = new GameResult(List.of(1, 2, 3), List.of(4, 5, 6));
        GameResult something = new GameResult(List.of(1, 2, 3), List.of(4, 5, 1));

        Assertions.assertThat(nothing.isNothing())
                .isTrue();
        Assertions.assertThat(something.isNothing())
                .isFalse();
    }

    @Test
    void _3스트라이크인지_확인() {
        GameResult threeStrike = new GameResult(List.of(1, 2, 3), List.of(1, 2, 3));
        GameResult twoStrike = new GameResult(List.of(1, 2, 3), List.of(1, 2, 4));

        Assertions.assertThat(threeStrike.isThreeStrike())
                .isTrue();
        Assertions.assertThat(twoStrike.isThreeStrike())
                .isFalse();
    }
}