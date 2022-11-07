package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

class BaseballGameInputServiceTest {

    BaseballGameInputService baseballGameInputService = new BaseballGameInputService();

    @Test
    void 검증성공_인풋리스트_반환() {
        String input = "123";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        List<Integer> userInput = baseballGameInputService.getUserInput();

        Assertions.assertThat(userInput).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 숫자_이외의_문자포함_예외반환() {
        String input = "12a";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> baseballGameInputService.getUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복_숫자_예외반환() {
        String input = "121";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> baseballGameInputService.getUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_예외반환() {
        String input = "12345";

        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> baseballGameInputService.getUserInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

}