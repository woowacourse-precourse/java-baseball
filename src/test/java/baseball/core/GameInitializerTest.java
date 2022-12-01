package baseball.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


class GameInitializerTest {

    @DisplayName("정답 숫자는 1에서 9까지 서로 다른 숫자여야 한다.")
    @Test
    void createTargetNumber() {
        BaseballNumber baseballNumber = GameInitializer.initBaseballNumber();
        String targetNumber = baseballNumber.getTargetNumber();
        List<Integer> digits = targetNumber
                .chars()
                .mapToObj(c -> c - '0')
                .collect(Collectors.toList());
        digits.forEach(digit -> {
            assertThat(digit).isGreaterThanOrEqualTo(1);
            assertThat(digit).isLessThanOrEqualTo(9);
        });
        assertThat(digits).doesNotHaveDuplicates();
    }

}