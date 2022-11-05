package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User();

    @Test
    void input() {
        command("123");
        user.input();
        Assertions.assertThat(user.getNumbers()).isEqualTo("123");

        command("456");
        user.input();
        Assertions.assertThat(user.getNumbers()).isEqualTo("456");

        command("789");
        user.input();
        Assertions.assertThat(user.getNumbers()).isEqualTo("789");
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}