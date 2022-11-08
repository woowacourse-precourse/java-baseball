package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckAnswerTest {
    @Test
    void 플레이어수_판별하기_테스트() {
        List<Integer> computerNumber = List.of(8, 9, 3);
        List<Integer> playerNumber = List.of(1, 2, 3);
        Map<String, Integer> resultMap = Map.of("strike", 1, "nothing", 2);
        assertThat(Application.checkAnswer(computerNumber, playerNumber)).isEqualTo(resultMap);
    }

    @Test
    void 플레이어수_판별하기_테스트2() {
        List<Integer> computerNumber = List.of(7, 9, 3);
        List<Integer> playerNumber = List.of(1, 7, 3);
        Map<String, Integer> resultMap = Map.of("strike", 1, "ball", 1, "nothing", 1);
        assertThat(Application.checkAnswer(computerNumber, playerNumber)).isEqualTo(resultMap);
    }

}
