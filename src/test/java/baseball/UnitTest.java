package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {
    @Nested
    class GenerateRandomNumberStringTest {
        @Test
        @DisplayName("컴퓨터가 생성한 수 테스트")
        @RepeatedTest(100)
        void generateRandomNumberString_Success() {
            String randomNumberString = Application.generateRandomNumberString();
            List<Character> usedNumber = new ArrayList<>();

            // 컴퓨터가 생성한 수는 3자리 수여야 한다
            assertThat(randomNumberString.length()).isEqualTo(3);

            for (int i = 0; i < randomNumberString.length(); i++) {
                char ch = randomNumberString.charAt(i);

                // 각 자리는 1~9까지의 수이고 중복되어서는 안된다.
                assertThat(ch).isGreaterThanOrEqualTo('1')
                        .isLessThanOrEqualTo('9');
                assertThat(usedNumber).doesNotContain(ch);

                usedNumber.add(ch);
            }
        }
    }
}
