package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void 랜덤넘버생성테스트() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> randomNumbers = numberGenerator.createRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(3);
        System.out.println("randomNumbers = " + randomNumbers);
    }
}