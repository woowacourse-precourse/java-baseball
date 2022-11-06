package baseball.domain.Hint;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
    private Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    @DisplayName("모두_스트라이크인_경우를_테스트한다")
    void 모두_스트라이크() {
        List<Integer> playerBalls = List.of(1, 2, 3);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = HintString.STRIKE.print(3);

        assertThat(hint.printHint(playerBalls, computerBalls)).isEqualTo(result);
    }

    @Test
    @DisplayName("모두_볼인_경우를_테스트한다")
    void 모두_볼() {
        List<Integer> playerBalls = List.of(3, 1, 2);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = HintString.BALL.print(3);

        assertThat(hint.printHint(playerBalls, computerBalls)).isEqualTo(result);
    }

    @Test
    @DisplayName("볼과_스트라이크가_함께있는_경우를_테스트한다")
    void 볼_스트라이크_혼합() {
        List<Integer> playerBalls = List.of(1, 5, 2);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = HintString.BALL.print(1) + HintString.STRIKE.print(1);

        assertThat(hint.printHint(playerBalls, computerBalls)).isEqualTo(result);
    }

    @Test
    @DisplayName("낫싱인_경우를_테스트한다")
    void 낫싱() {
        List<Integer> playerBalls = List.of(7, 5, 8);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = HintString.NOTHING.print();

        assertThat(hint.printHint(playerBalls, computerBalls)).isEqualTo(result);
    }


}
