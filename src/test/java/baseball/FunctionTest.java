package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionTest {
    @Test
    void 초과입력_예외_테스트() {
        Numbers numbers = new Numbers();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);

        assertThatThrownBy(numbers::validateNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위초과_입력_예외() {
        Numbers numbers = new Numbers();

        assertThatThrownBy(() -> numbers.add(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 1~9 사이의 수가 아닙니다.");
    }

    @Test
    void 문자가_입력될_때_예외() {
        BaseballGame baseballGame = new BaseballGame();

        assertThatThrownBy(() -> baseballGame.validateStringToInteger("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력되어야 합니다.");
    }

    @Test
    void 볼_확인_테스트() {
        Numbers numbers = new Numbers();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int result = numbers.check(2, 2);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 스트라이크_확인_테스트() {
        Numbers numbers = new Numbers();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int result = numbers.check(2, 1);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 재시작_테스트() {
        BaseballGame baseballGame = new BaseballGame();
        Boolean result = baseballGame.checkRetry("1");

        assertThat(result).isEqualTo(true);
    }

    @Test
    void 종료_테스트() {
        BaseballGame baseballGame = new BaseballGame();
        Boolean result = baseballGame.checkRetry("2");

        assertThat(result).isEqualTo(false);
    }

    @Test
    void 재시작_종료_에러_테스트() {
        BaseballGame baseballGame = new BaseballGame();

        assertThatThrownBy(() -> baseballGame.checkRetry("49"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 혹은 2가 입력되어야 합니다.");
    }
}
