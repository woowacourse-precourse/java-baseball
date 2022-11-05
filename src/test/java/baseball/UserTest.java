package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class UserTest {

    @Test
    void 숫자설정_후_값_확인() {
        final byte[] buf = new String("123").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        User user = new User();
        user.generateNumber();
        Assertions.assertThat(user.getNumbers().equals(List.of(1, 2, 3)));
    }

    @Test
    void 예외_테스트_1() {
        final byte[] buf = new String("1234").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        User user = new User();
        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_2() {
        final byte[] buf = new String("12").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        User user = new User();
        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_3() {
        final byte[] buf = new String("097").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        User user = new User();
        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_4() {
        final byte[] buf = new String("112").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        User user = new User();
        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }
}
