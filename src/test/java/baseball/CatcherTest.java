package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CatcherTest {
    private Catcher catcher;
    private List<Integer> catcherNumbers;

    @BeforeEach
    void init() {
        catcher = new Catcher();
        catcherNumbers = catcher.generateRandomNumbers();
    }

    @Test
    @DisplayName("포수는 3자리 수를 생성한다.")
    void generateCatcherNumbers() {
        assertThat(catcherNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("포수는 1부터 9까지 이루어진 3자리 수를 생성한다.")
    void generateCatcherNumbersInRange1To9() {
        for (int digit : catcherNumbers) {
            assertThat(digit).isBetween(1, 9);
        }
    }

    @Test
    @DisplayName("포수는 1부터 9까지 이루어진 서로 다른 3자리 수를 생성한다.")
    void generateCatcherSeparateNumbers() {
        assertThat(catcherNumbers).doesNotHaveDuplicates();
    }
}