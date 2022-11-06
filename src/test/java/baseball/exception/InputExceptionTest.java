package baseball.exception;

import baseball.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @DisplayName("플레이어 입력 숫자 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"113", "12", "가13", "ABC", "12354", "1", "가나다라"})
    void checkExceptionNumberTest(String inputData) {
        // Given
        Player player = new Player();

        // When
        InputStream input = new ByteArrayInputStream(inputData.getBytes());
        System.setIn(input);

        // Then
        assertThatThrownBy(() -> player.enterNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
