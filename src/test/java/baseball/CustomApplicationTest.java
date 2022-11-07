package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CustomApplicationTest {
    @Test
    void 사용자_정답_입력_예외_테스트() {
        assertThatThrownBy(() -> User.checkGameInput("1234"))
                .isExactlyInstanceOf(Exception.class);
        assertThatThrownBy(() -> User.checkGameInput("224"))
                .isExactlyInstanceOf(Exception.class);
        assertThatThrownBy(() -> User.checkGameInput("a34"))
                .isExactlyInstanceOf(NumberFormatException.class);

    }
    @Test
    void 사용자_게임_재시작_입력_예외_테스트() {
        InputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> User.getRestartInput())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 힌트_정확성_테스트() {
        Hint hint = new Hint(Arrays.asList(1,2,3));
        assertThat(hint.get(Arrays.asList(1,2,3))).isEqualTo("3스트라이크");
        assertThat(hint.get(Arrays.asList(2,7,3))).isEqualTo("1볼 1스트라이크");
        assertThat(hint.get(Arrays.asList(9,9,9))).isEqualTo("낫싱");
    }
}