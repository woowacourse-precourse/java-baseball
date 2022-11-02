package baseball;

import static baseball.utils.Constants.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomThreeDigitNumberGeneratorTest {

    @Test
    void generate_메서드로_임의의_세_자리_숫자_리스트_생성() {
        List<Integer> randomThreeDigitNumber = RandomThreeDigitNumberGenerator.generate();

        assertThat(randomThreeDigitNumber.size()).isEqualTo(RANDOM_NUMBER_LENGTH);
        assertThat(randomThreeDigitNumber.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER)).isTrue();
    }
}
