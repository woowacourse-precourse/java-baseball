package study;

import baseball.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.Application.startGame;
import static baseball.Application.validation;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyTest {

    @Test
    @DisplayName("게임 시작")
    void 게임_시작() {
        startGame();
        assertThat(true).isTrue();
    }

    @Test
    @DisplayName("사용자 숫자 입력시 유효성 검증")
    void 사용자_숫자_입력시_유효성_검증() {
        String input = "123";
        String wrongInput1 = "1234";
        String wrongInput2 = "120";
        String wrongInput3 = "111";
        String wrongInput4 = "1.3";
        String wrongInput5 = "abc";


        assertThat(validation(input)).isTrue();
        assertThatThrownBy(() -> {
            validation(wrongInput1);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation(wrongInput2);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation(wrongInput3);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation(wrongInput4);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            validation(wrongInput5);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
