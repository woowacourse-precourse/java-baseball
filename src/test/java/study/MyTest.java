package study;

import baseball.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static baseball.Application.*;
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

    @Test
    @DisplayName("랜덤 숫자 생성 시 validation 검증")
    void 랜덤_숫자_생성시_validation_검증() {
        for (int i = 0; i < 10000; i++) {
            String randomNumber = generateRandomNumber();
            assertThat(validation(randomNumber)).isTrue();
        }
    }

    @Test
    @DisplayName("볼/스트라이크/낫싱 판별")
    void 볼_스트라이크_낫싱_판별(){
        String computer = "425";
        String mine1 = "123";
        String mine2 = "456";
        String mine3 = "789";

        assertThat(judgeResult(mine1, computer)).isEqualTo("10");
        assertThat(judgeResult(mine2, computer)).isEqualTo("11");
        assertThat(judgeResult(mine3, computer)).isEqualTo("00");
    }
}
