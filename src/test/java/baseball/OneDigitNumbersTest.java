package baseball;

import baseball.utils.GameUtil;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Scoreboard 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OneDigitNumbersTest {
    void 숫자_분할() {
        int number = 123;
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(number);

        assertThat(oneDigitNumbers.toList()).containsExactly(1, 2, 3);
    }

    @Nested
    class 숫자_길이_확인{
        @Test
        void 중복_제거() {
            List<Integer> number = List.of(9,8,8);
            OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(number);

            assertThat(oneDigitNumbers.size(true)).isEqualTo(2);
        }

        @Test
        void 일반() {
            List<Integer> number = List.of(9,8,8);
            OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(number);

            assertThat(oneDigitNumbers.size()).isEqualTo(3);
        }
    }

    @Test
    void 교집합_가져오기() {
        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = List.of(4, 3, 2);
        OneDigitNumbers oneDigitNumbers1 = new OneDigitNumbers(list1);
        OneDigitNumbers oneDigitNumbers2 = new OneDigitNumbers(list2);
        OneDigitNumbers retain = oneDigitNumbers1.retainAll(oneDigitNumbers2);

        assertThat(oneDigitNumbers1.toList()).containsExactly(1, 2, 3); // 리스트가 copy 되었는지 확인
        assertThat(retain.toList()).containsExactly(2, 3);
    }


}
