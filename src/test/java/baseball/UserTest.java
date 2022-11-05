package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void 사용자가_입력한_숫자가_정상적으로_할당된다() {
        // given
        String userNumber = "123";
        String expected = "123";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        user.enterNumber();

        // then
        assertThat(user.getInputNumber()).isEqualTo(expected);
    }

    @Test
    void 사용자가_입력한_숫자의_크기_예외발생1() {
        // given
        String userNumber = "1234";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> user.enterNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 크기(길이)를 확인하세요.");
    }

    @Test
    void 사용자가_입력한_숫자의_크기_예외발생2() {
        // given
        String userNumber = "12";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> user.enterNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 크기(길이)를 확인하세요.");
    }

    @Test
    void 입력한_숫자_범위가_조건에_맞지않는_경우_예외_발생1() {
        // given
        String userNumber = "104";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> user.enterNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 입력한_숫자_범위가_조건에_맞지않는_경우_예외_발생2() {
        // given
        String userNumber = "1@4";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> user.enterNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 입력한_숫자_범위가_조건에_맞지않는_경우_예외_발생3() {
        // given
        String userNumber = "kim";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(userNumber.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(() -> user.enterNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }
}