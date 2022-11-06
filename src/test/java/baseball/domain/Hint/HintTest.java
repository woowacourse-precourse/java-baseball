package baseball.domain.Hint;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
    private Hint hint;

    @Test
    @DisplayName("모두 스트라이크인 경우를 테스트한다")
    void 모두_스트라이크() {
        List<Integer> playerBalls = List.of(1, 2, 3);
        List<Integer> computerBalls = List.of(1, 2, 3);
        hint = new Hint(playerBalls, computerBalls);
        String result = HintString.STRIKE.print(3);

        assertThat(hint.printHint()).isEqualTo(result);
    }

    @Test
    @DisplayName("모두 볼인 경우를 테스트한다")
    void 모두_볼() {
        List<Integer> playerBalls = List.of(3, 1, 2);
        List<Integer> computerBalls = List.of(1, 2, 3);
        hint = new Hint(playerBalls, computerBalls);
        String result = HintString.BALL.print(3);

        assertThat(hint.printHint()).isEqualTo(result);
    }

    @Test
    @DisplayName("볼과 스트라이크가 함께있는 경우를 테스트한다")
    void 볼_스트라이크_혼합() {
        List<Integer> playerBalls = List.of(1, 5, 2);
        List<Integer> computerBalls = List.of(1, 2, 3);
        hint = new Hint(playerBalls, computerBalls);
        String result = HintString.BALL.print(1) + HintString.STRIKE.print(1);

        assertThat(hint.printHint()).isEqualTo(result);
    }

    @Test
    @DisplayName("낫싱인 경우를 테스트한다")
    void 낫싱() {
        List<Integer> playerBalls = List.of(7, 5, 8);
        List<Integer> computerBalls = List.of(1, 2, 3);
        hint = new Hint(playerBalls, computerBalls);
        String result = HintString.NOTHING.print();

        assertThat(hint.printHint()).isEqualTo(result);
    }


}
