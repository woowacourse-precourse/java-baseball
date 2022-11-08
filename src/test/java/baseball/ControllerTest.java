package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ControllerTest {

    @Test
    void 점수_최대값_예외처리() {
        Map<String, Integer> scoreMap = Controller.getScoreMap();
        scoreMap.put("스트라이크", 5);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Controller.validateScoreCount())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 점수_낫싱_예외처리() {
        Map<String, Integer> scoreMap = Controller.getScoreMap();
        scoreMap.put("스트라이크", 1);
        scoreMap.put("낫싱", 1);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> Controller.validateNothing())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_점수_계산() {
        Map<String, Integer> scoreMap = Controller.getScoreMap();
        scoreMap.put("스트라이크", 1);
        Controller.increaseScore("스트라이크");

        assertThat(scoreMap.get("스트라이크")).isEqualTo(2);
    }

    @BeforeEach
    void scoreMap_초기화() {
        Controller.clearScoreMap();
    }
}