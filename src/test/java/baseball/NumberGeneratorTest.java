package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

}