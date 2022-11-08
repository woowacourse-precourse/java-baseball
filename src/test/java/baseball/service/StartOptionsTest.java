package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StartOptionsTest {

    @Test
    void 파라미터로_넘겨진_StartOptions와_자신이_서로_같으면_true를_반환한다() {
        StartOptions startSign = StartOptions.START;
        assertThat(startSign.is(StartOptions.START)).isTrue();
    }

    @Test
    void 파라미터로_넘겨진_StartOptions와_자신이_서로_다르면_false를_반환한다() {
        StartOptions startSign = StartOptions.START;
        assertThat(startSign.is(StartOptions.STOP)).isFalse();
    }

    @Test
    void 파라미터로_넘겨진_int값이_0인_경우_StartOptions의_START가_생성된다() {
        StartOptions startOptions = StartOptions.of("0");
        assertThat(startOptions).isEqualTo(StartOptions.START);
    }

    @Test
    void 파라미터로_넘겨진_int값이_1인_경우_StartOptions의_RESTART가_생성된다() {
        StartOptions startOptions = StartOptions.of("1");
        assertThat(startOptions).isEqualTo(StartOptions.RESTART);
    }

    @Test
    void 파라미터로_넘겨진_int값이_2인_경우_StartOptions의_STOP이_생성된다() {
        StartOptions startOptions = StartOptions.of("2");
        assertThat(startOptions).isEqualTo(StartOptions.STOP);
    }

    @Test
    void 파라미터로_넘겨진_int값이_0_1_2외의_값이_들어올_경우_예외를_터트린다() {
        assertThatThrownBy(() -> StartOptions.of("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("StartOptions에 없는 sign값 입니다.");
    }
}