package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.rule.GameOption;
import org.junit.jupiter.api.Test;

public class GameOptionTest {

    @Test
    void 예외_테스트_다른옵션입력() {
        assertThatThrownBy(() -> GameOption.isCorrectOption(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
