package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user;

    @BeforeEach
    void 유저_객체_생성() {
        user = new User();
    }

    @Test
    void 정상_입력() {
        user.generateNumbers("123");

        assertThat(user
                .getNumbers())
                .isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 중복_문자_2개() {
        assertThatThrownBy(() -> user.generateNumbers("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_문자_3개() {
        assertThatThrownBy(() -> user.generateNumbers("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_길이_3미만() {
        assertThatThrownBy(() -> user.generateNumbers("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_길이_3초과() {
        assertThatThrownBy(() -> user.generateNumbers("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}