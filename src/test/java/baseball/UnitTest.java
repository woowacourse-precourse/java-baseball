package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

    // 2. Print the game start message test
    @Test
    void printTheGameStartMessageTest() {
        String message = Application.printTheGameStartMessage();
        Assertions.assertThat(message).isEqualTo("숫자 야구 게임을 시작합니다.");
    }
}
