package baseball.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserRetryNumberTest {

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