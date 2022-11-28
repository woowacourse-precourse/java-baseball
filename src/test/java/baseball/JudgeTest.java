package baseball;

import baseball.model.Judge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JudgeTest {

    @Test
    @DisplayName("상대방과 플레이어의 수 비교")
    void compareNumbers() {
        Judge judge = new Judge();
        judge.compareNumbers(List.of(1, 2, 3), List.of(3, 2, 7));
        String result = judge.setResult().toString();
        assertThat(result).isEqualTo("1볼 1스트라이크\n");
    }
}
