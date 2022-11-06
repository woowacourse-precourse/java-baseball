package baseball.util;

import org.junit.jupiter.api.Test;

import static baseball.util.InputValidator.*;
import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {

    @Test
    void 재시작_여부_유효값_검증() {
        validatePlayerInputRetry(RETRY_GAME);
        validatePlayerInputRetry(EXIT_GAME);
    }

    @Test
    void 재시작_여부_예외값_검증() {
        // 1 또는 2가 아닌 수
        assertThatThrownBy(() -> {
            validatePlayerInputRetry("12345");
        }).isExactlyInstanceOf(IllegalArgumentException.class);

        // 숫자가 아닌 문자
        assertThatThrownBy(() -> {
            validatePlayerInputRetry("종료");
        }).isExactlyInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 플레이어_입력_숫자_유효값_검증() {
        String playerInput = GameNumberGenerator.createGameNumber();
        validatePlayerInputNumber(playerInput);
    }

    @Test
    void 플레이어_입력_숫자_예외값_검증() {
        // 세 자리 수가 아니다
        assertThatThrownBy(() -> {
            validatePlayerInputNumber("1234");
        }).isExactlyInstanceOf(IllegalArgumentException.class);
        // 동일한 숫자가 존재한다
        assertThatThrownBy(() -> {
            validatePlayerInputNumber("111");
        }).isExactlyInstanceOf(IllegalArgumentException.class);
        // 도메인 값이 아닌 0이 존재한다
        assertThatThrownBy(() -> {
            validatePlayerInputNumber("805");
        }).isExactlyInstanceOf(IllegalArgumentException.class);
        // 숫자가 아닌 문자를 입력한다
        assertThatThrownBy(() -> {
            validatePlayerInputNumber("정답알려주세요");
        }).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
