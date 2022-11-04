package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersGeneratorTest {

    @Test
    @DisplayName("1부터 9까지의 난수 숫자 3자리를 생성하는 테스트")
    void GenerateNumberTest() {
        // given
        NumberGenerator generateNumber = new NumberGenerator();
        List<Integer> randomNumbers = new ArrayList<>();

        // when
        generateNumber.generate(randomNumbers);

        // then
        assertThat(randomNumbers.size()).isEqualTo(3);
        assertThat(randomNumbers.stream().allMatch(number -> number >= 1 && number <= 9))
                .isTrue();
    }
}