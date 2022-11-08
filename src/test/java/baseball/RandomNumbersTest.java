package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.game.number.RandomNumbers.createThreeRandomNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumbersTest {

    @RepeatedTest(10)
    @DisplayName("서로 다른 3개의 숫자 생성")
    void generateDistinctThreeNumber() {
        List<Integer> randomNumbers = createThreeRandomNumbers();
        List<Integer> isDistincted = randomNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(isDistincted.size()).isEqualTo(3);

    }
}