package baseball.domain.Hint;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
    private Hint hint;
    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        hint = new Hint();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("모두_스트라이크인_경우를_테스트한다")
    void 모두_스트라이크() {
        List<Integer> playerBalls = List.of(1, 2, 3);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = String.format(HintString.STRIKE.getContent(), 3);

        hint.printHint(playerBalls, computerBalls);

        assertThat(outputStream.toString()).isEqualToIgnoringNewLines(result);
    }

    @Test
    @DisplayName("모두_볼인_경우를_테스트한다")
    void 모두_볼() {
        List<Integer> playerBalls = List.of(3, 1, 2);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = String.format(HintString.BALL.getContent(), 3);

        hint.printHint(playerBalls, computerBalls);

        assertThat(outputStream.toString()).isEqualToIgnoringNewLines(result);
    }

    @Test
    @DisplayName("볼과_스트라이크가_함께있는_경우를_테스트한다")
    void 볼_스트라이크_혼합() {
        List<Integer> playerBalls = List.of(1, 5, 2);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = String.format(HintString.BALL.getContent() + HintString.STRIKE.getContent(), 1, 1);

        hint.printHint(playerBalls, computerBalls);

        assertThat(outputStream.toString()).isEqualToIgnoringNewLines(result);
    }

    @Test
    @DisplayName("낫싱인_경우를_테스트한다")
    void 낫싱() {
        List<Integer> playerBalls = List.of(7, 5, 8);
        List<Integer> computerBalls = List.of(1, 2, 3);
        String result = String.format(HintString.NOTHING.getContent());

        hint.printHint(playerBalls, computerBalls);

        assertThat(outputStream.toString()).isEqualToIgnoringNewLines(result);
    }


}
