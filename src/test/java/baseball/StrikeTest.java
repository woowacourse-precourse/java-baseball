package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StrikeTest {

    Strike strike = new Strike();

    @DisplayName("스트라이크 판독")
    @ParameterizedTest
    @MethodSource("generateData")
    void checkNumberOfStrikes(String inputNumber, String computerNumber, int index) {
        int strikeCount = strike.compareCharacterLocationMatch(inputNumber, computerNumber);
        int[] result = {3, 2, 1, 1, 0};
        assertThat(strikeCount).isEqualTo(result[index]);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("123", "123", 0),
                Arguments.of("123", "124", 1),
                Arguments.of("123", "134", 2),
                Arguments.of("123", "273", 3),
                Arguments.of("123", "567", 4)
        );
    }
}