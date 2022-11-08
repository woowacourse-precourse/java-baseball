package baseball.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseballGameServiceTest {

    private BaseballGameService baseballGameService;
    private InputStream inputStream;

    private static InputStream generateInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void setUp() {
        baseballGameService = new BaseballGameService();
    }

    @DisplayName("입력 검증 기능에 부합하지 않은 입력시 예외 발생")
    @Test
    void 사용자_입력_길이예외_테스트() {
        String theInput = "1234";
        inputStream = generateInput(theInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> baseballGameService.readUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 검증 기능에 부합하지 않은 입력시 예외 발생")
    @Test
    void 사용자_입력_중복숫자_테스트() {
        String theInput = "111";
        inputStream = generateInput(theInput);
        System.setIn(inputStream);

        assertThatThrownBy(() -> baseballGameService.readUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

}