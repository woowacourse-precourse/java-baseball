package baseball;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OpponentTest {
    @Test
    void 랜덤_생성되는_값_유효성_검증() {
        for (int i = 0; i < 1000; ++i) {
            Opponent opponent = new ComputerOpponent();
        }
    }

}
