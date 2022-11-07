package baseball;

import baseball.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class UserTest {
    private static User user;

    @BeforeAll
    static void init() {
        user = new User();
    }

    @Test
    void 숫자설정_후_값_확인() {
        final byte[] buf = new String("123").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        user.generateNumber();
        Assertions.assertThat(user.getNumbers()).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 예외_테스트_네자리_숫자() {
        final byte[] buf = new String("1234").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_두자리_숫자() {
        final byte[] buf = new String("12").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_첫자리_0() {
        final byte[] buf = new String("097").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_테스트_같은_숫자_존재() {
        final byte[] buf = new String("112").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력_1() {
        final byte[] buf = new String("-1").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력_2() {
        final byte[] buf = new String("-12").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력_3() {
        final byte[] buf = new String("-123").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_문자열_입력() {
        final byte[] buf = new String(" ").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        Assertions.assertThatThrownBy(() -> user.generateNumber()).isInstanceOf(IllegalArgumentException.class);
    }
}
