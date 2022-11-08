package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {
    @DisplayName("상대방(컴퓨터)의 수와 입력한 수 비교 기능1: 숫자와 자리까지 일치할 경우 스트라이크")
    @Test
    public void strikeTest() {
        final List<Integer> opponentNum = Arrays.asList(1, 2, 3);
        final List<Integer> inputNum = Arrays.asList(1, 2, 3);
        final Hint hint = new Hint(opponentNum, inputNum);

        hint.checkHint();

        assertThat(hint.strike).isEqualTo(3);
    }

    @DisplayName("상대방(컴퓨터)의 수와 입력한 수 비교 기능2: 숫자만 일치할 경우 볼")
    @Test
    public void ballTest() {
        final List<Integer> opponentNum = Arrays.asList(1, 2, 3);
        final List<Integer> inputNum = Arrays.asList(4, 2, 1);
        final Hint hint = new Hint(opponentNum, inputNum);

        hint.checkHint();

        assertThat(hint.ball).isEqualTo(1);
    }
}
