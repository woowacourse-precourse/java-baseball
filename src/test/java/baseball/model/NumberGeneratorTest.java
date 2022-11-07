package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @DisplayName("컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.")
    @Test
    void generate() {
        List<Integer> computer = NumberGenerator.generate();
        assertThat(computer).hasSize(3);
    }
}
