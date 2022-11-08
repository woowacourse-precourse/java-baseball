package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PitcherTest {
    private Pitcher pitcher;

    @BeforeEach
    void init() {
        pitcher = new Pitcher(new Validator());
    }

    @DisplayName("투수는 1부터 9까지 이루어진 서로 다른 3자리 수 입력 시 각 자리 수를 담은 List 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void pitch(String input) {
        System.setIn(MockPitcherInput.mockPitcherInput(input));
        List<Integer> pitcherNumbers = pitcher.pitch();
        assertThat(pitcherNumbers)
                .hasSize(3)
                .doesNotContain(0)
                .doesNotHaveDuplicates();
    }

    @DisplayName("투수는 정답을 맞춘 뒤 게임 재시작(1) 또는 게임 종료(2) 입력 시 해당 값을 Integer 를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void selectGameProcess(String input) {
        System.setIn(MockPitcherInput.mockPitcherInput(input));
        Integer result = pitcher.selectGameRestartOrEnd();
        assertThat(result).isEqualTo(Integer.valueOf(input));
    }
}