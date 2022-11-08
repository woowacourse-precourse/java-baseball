package baseball.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StartOptionsTest {

    @DisplayName("파라미터로 넘겨진 StartOptions와 자신이 서로 같으면 true를 반환한다")
    @Test
    void returnTrue() {
        StartOptions startSign = StartOptions.START;
        assertThat(startSign.is(StartOptions.START)).isTrue();
    }

    @DisplayName("파라미터로 넘겨진 StartOptions와 자신이 서로 다르면 false를 반환한다")
    @Test
    void returnFalse() {
        StartOptions startSign = StartOptions.START;
        assertThat(startSign.is(StartOptions.STOP)).isFalse();
    }

    @DisplayName("파라미터로 넘겨진 int값이 0인 경우 StartOptions의 START가 생성된다")
    @Test
    void ofTest1() {
        StartOptions startOptions = StartOptions.of("0");
        assertThat(startOptions).isEqualTo(StartOptions.START);
    }

    @DisplayName("파라미터로 넘겨진 int값이 1인 경우 StartOptions의 RESTART가 생성된다")
    @Test
    void ofTest2() {
        StartOptions startOptions = StartOptions.of("1");
        assertThat(startOptions).isEqualTo(StartOptions.RESTART);
    }

    @DisplayName("파라미터로 넘겨진 int값이 2인 경우 StartOptions의 STOP이 생성된다")
    @Test
    void ofTest3() {
        StartOptions startOptions = StartOptions.of("2");
        assertThat(startOptions).isEqualTo(StartOptions.STOP);
    }

    @DisplayName("파라미터로 넘겨진 int값이 0 1 2외의 값이 들어올 경우 예외를 터트린다")
    @Test
    void ofTest4() {
        assertThatThrownBy(() -> StartOptions.of("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("StartOptions에 없는 sign값 입니다.");
    }
}