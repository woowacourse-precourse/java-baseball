package baseball;

import baseball.input.MockInputReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    void 입력_성공() {
        Player player = new Player(new MockInputReader("123"));
        List<Integer> guessedNumber = player.guessNumber();

        assertThat(guessedNumber.size()).isEqualTo(3);
        assertThat(guessedNumber.get(0)).isEqualTo(1);
        assertThat(guessedNumber.get(1)).isEqualTo(2);
        assertThat(guessedNumber.get(2)).isEqualTo(3);
    }

    @ParameterizedTest(name = "{0}가 3자리 수가 아니어서 실패")
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void _3자리_수가_아닌_입력으로_실패(String input) {
        Player player = new Player(new MockInputReader(input));

        assertThatThrownBy(() -> player.guessNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}에 숫자가 아닌 문자가 포함되어 실패")
    @ValueSource(strings = {"a12", "12b", "!@#", "-12"})
    void 숫자가_아닌_입력으로_실패(String input) {
        Player player = new Player(new MockInputReader(input));

        assertThatThrownBy(() -> player.guessNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력에_0포함으로_실패() {
        Player player = new Player(new MockInputReader("120"));

        assertThatThrownBy(() -> player.guessNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_숫자_입력으로_실패() {
        Player player = new Player(new MockInputReader("112"));

        assertThatThrownBy(() -> player.guessNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
