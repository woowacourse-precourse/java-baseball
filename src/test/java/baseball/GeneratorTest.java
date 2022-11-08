package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    Generator generator = spy(new Generator());

    @Test
    @DisplayName("상대방의 랜덤 숫자 생성")
    void generateRandomNumber() {
        String randomNumber = generator.generateRandomNumber();

        HashSet<Character> overlapChecker = new HashSet<>();
        for (char c : randomNumber.toCharArray()) {
            overlapChecker.add(c);
        }

        assertThat(overlapChecker).hasSize(3);
        overlapChecker.forEach(number -> assertThat(isNumber(number)).isTrue());
    }

    private boolean isNumber(char n) {
        return '1' <= n || n <= '9';
    }

}