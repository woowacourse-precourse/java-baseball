package baseball.domain;

import baseball.domain.User;
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
        assertThatThrownBy(user::enterNumber)
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
        assertThatThrownBy(user::enterNumber)
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
        assertThatThrownBy(user::enterNumber)
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
        assertThatThrownBy(user::enterNumber)
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
        assertThatThrownBy(user::enterNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 재시작_응답이_1인경우_참_반환() {
        // given
        String retryIntention = "1";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(retryIntention.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThat(user.hasRetryIntention()).isEqualTo(true);
    }

    @Test
    void 재시작_응답이_2인경우_거짓_반환() {
        // given
        String retryIntention = "2";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(retryIntention.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThat(user.hasRetryIntention()).isEqualTo(false);
    }

    @Test
    void 재시작_응답이_조건에_맞지않는_경우_예외_발생1() {
        // given
        String retryIntention = "a";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(retryIntention.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(user::hasRetryIntention)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

    @Test
    void 재시작_응답이_조건에_맞지않는_경우_예외_발생2() {
        // given
        String retryIntention = "0";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(retryIntention.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(user::hasRetryIntention)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

    @Test
    void 재시작_응답이_조건에_맞지않는_경우_예외_발생3() {
        // given
        String retryIntention = "asd";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(retryIntention.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(user::hasRetryIntention)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

    @Test
    void 재시작_응답이_조건에_맞지않는_경우_예외_발생4() {
        // given
        String retryIntention = "123";

        // when
        User user = new User();
        InputStream in = new ByteArrayInputStream(retryIntention.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        // then
        assertThatThrownBy(user::hasRetryIntention)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }
}