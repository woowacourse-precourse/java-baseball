package baseball.engine;

import baseball.model.Numbers;
import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NextStepNumberGeneratorTest {
    private final static int RANDOM_NUMBER_SIZE = 3;
    private NumberGenerator generator;

    @BeforeEach
    void setup() {
        generator = new NextStepNumberGenerator();
    }

    @Nested
    @DisplayName("generate 메서드는")
    class DescribeGenerate {
        @Test
        @DisplayName("랜덤 숫자 생성 기능 테스트")
        void randomNumberGenerate() {
            Numbers numbers = generator.generate(RANDOM_NUMBER_SIZE);
            Set<Integer> distinctNumbers = new HashSet<>();

            numbers.iterateForEach((i, number) -> distinctNumbers.add(number));

            Assertions.assertThat(distinctNumbers.size()).isEqualTo(RANDOM_NUMBER_SIZE);
        }
    }
}
