package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("컴퓨터 숫자 생성 테스트")
    void inputValueLengthTest1() {

        BaseballGame baseballGame = new BaseballGame();
        List<Integer> computerNumber = baseballGame.createComputerNumber();

        assertThat(computerNumber)
                .isNotNull()
                .isNotEmpty()
                .doesNotContain(0);

        assertThat(computerNumber.size())
                .isEqualTo(3);
    }
}
