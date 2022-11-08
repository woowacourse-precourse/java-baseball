package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallCountTest {

    @Test
    void 스트라이크_테스트() {
        Game game = new Game(List.of(1, 2, 3));
        
        assertThat(
                game.getCountOfStrike(
                        List.of(9, 5, 6)
                )
        ).isEqualTo(0);

        assertThat(
                game.getCountOfStrike(
                        List.of(1, 5, 6)
                )
        ).isEqualTo(1);

        assertThat(
                game.getCountOfStrike(
                        List.of(1, 2, 6)
                )
        ).isEqualTo(2);

        assertThat(
                game.getCountOfStrike(
                        List.of(1, 5, 3)
                )
        ).isEqualTo(2);

        assertThat(
                game.getCountOfStrike(
                        List.of(1, 2, 3)
                )
        ).isEqualTo(3);

    }

    @Test
    void 볼_테스트() {
        Game game = new Game(List.of(1, 2, 3));

        List<Integer> num = List.of(9, 5, 6);
        assertThat(
                game.getCountOfBall(
                        num, game.getCountOfStrike(num)
                )
        ).isEqualTo(0);

        List<Integer> num2 = List.of(4, 2, 3);
        assertThat(
                game.getCountOfBall(
                        num2, game.getCountOfStrike(num2)
                )
        ).isEqualTo(0);

        List<Integer> num3 = List.of(1, 2, 3);
        assertThat(
                game.getCountOfBall(
                        num3, game.getCountOfStrike(num3)
                )
        ).isEqualTo(0);

        List<Integer> num4 = List.of(1, 3, 2);
        assertThat(
                game.getCountOfBall(
                        num4, game.getCountOfStrike(num4)
                )
        ).isEqualTo(2);

        List<Integer> num5 = List.of(3, 1, 2);
        assertThat(
                game.getCountOfBall(
                        num5, game.getCountOfStrike(num5)
                )
        ).isEqualTo(3);

    }
}
