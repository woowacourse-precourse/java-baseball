package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    NumberGenerator numberGenerator;

    @BeforeEach
    void beforeEach() {
        numberGenerator = new NumberGenerator();
    }

    @Test
    void generateRandomNumber_메서드로_서로다른_3자리의수_반환() {
        // given
        int expectedNumberLength = 3;
        // when
        List<Integer> integerList = numberGenerator.generateRandomNumber();
        // then
        long uniqueNumberLength = integerList.stream().distinct().count();
        assertThat(uniqueNumberLength).isEqualTo(expectedNumberLength);
    }

    @Test
    void generateRandomNumber_메서드로_1과9사이의_3자리수_반환() {
        // given, when
        List<Integer> integerList = numberGenerator.generateRandomNumber();
        // then
        List<Integer> collect = integerList.stream()
                .filter(integer -> integer < 1 || integer > 9).collect(Collectors.toList());
        assertThat(collect).isEmpty();
    }

}