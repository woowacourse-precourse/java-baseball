package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class UserTest {
    User user = new User();

    @Test
    void 유저_입력_숫자_검증() {
        command("123");
        user.inputNumbers();
        assertThat(user.getNumbers()).isEqualTo("123");

        command("456");
        user.inputNumbers();
        assertThat(user.getNumbers()).isEqualTo("456");

        command("789");
        user.inputNumbers();
        assertThat(user.getNumbers()).isEqualTo("789");
    }

    @Test
    void 게임_재시작_입력_검증_올바름() {
        command("1");
        assertThat(user.inputRetry()).isEqualTo('1');

        command("2");
        assertThat(user.inputRetry()).isEqualTo('2');
    }

    @Test
    void 게임_재시작_입력_검증_예외발생() {
        command("3");
        assertThatThrownBy(() -> user.inputRetry()).isInstanceOf(IllegalArgumentException.class);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}