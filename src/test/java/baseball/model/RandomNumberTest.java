package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @Nested
    @DisplayName("랜덤 숫자 생성")
    class SetRandomNumber {
        final List<Integer> randomNumber = RandomNumber.setRandomNumber();

        @Test
        @DisplayName("크기 3의 리스트")
        void 사이즈_체크() {
            assertThat(randomNumber.size())
                    .isEqualTo(3);
        }

        @Test
        @DisplayName("1~9 숫자만 존재")
        void 숫자_체크() {
            assertThat(randomNumber.stream().allMatch(number -> number >= 1 && number <= 9))
                    .isTrue();
        }

        @Test
        @DisplayName("중복 없음")
        void 중복_체크() {
            Set<Integer> randomSet = new HashSet<>(randomNumber);
            assertThat(randomNumber.size())
                    .isEqualTo(randomSet.size());
        }
    }
}
