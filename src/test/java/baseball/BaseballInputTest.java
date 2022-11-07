package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballInputTest {

    @Test
    void nextBaseballNum_isNotNumber() {
        assertThatThrownBy(() -> BaseballInput.nextBaseballNum("12abcd"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void nextBaseballNum_hasSpaceInner() {
        assertThatThrownBy(() -> BaseballInput.nextBaseballNum("12 3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void nextBaseballNum_negativeNumber() {
        assertThatThrownBy(() -> BaseballInput.nextBaseballNum("-142"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 입력할 수 없습니다.");
    }

    @Test
    void nextBaseballNum_wrongLength() {
        assertThatThrownBy(() -> BaseballInput.nextBaseballNum("1422"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 수만 입력할 수 있습니다.");
    }

    @Test
    void nextBaseballNum_duplicate() {
        assertThatThrownBy(() -> BaseballInput.nextBaseballNum("522"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 포함되어 있습니다.");
    }

    @Test
    void nextBaseballNum_correct() {
        assertThat(BaseballInput.nextBaseballNum("612")).isEqualTo(612);
    }

    @Test
    void nextSelect_isNotNumber() {
        assertThatThrownBy(() -> BaseballInput.nextSelect("da"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void nextSelect_hasSpaceInner() {
        assertThatThrownBy(() -> BaseballInput.nextSelect("2 1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력할 수 있습니다.");
    }

    @Test
    void nextSelect_wrongSelect() {
        List<String> inputs = Arrays.asList("-2", "0", "3", "5");
        inputs.forEach(it ->
                assertThatThrownBy(() -> BaseballInput.nextSelect(it))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("1 또는 2만 입력할 수 있습니다.")
                );
    }

    @Test
    void nextSelect_correct() {
        assertThat(BaseballInput.nextSelect("1")).isEqualTo(1);
        assertThat(BaseballInput.nextSelect("2")).isEqualTo(2);
    }
}
