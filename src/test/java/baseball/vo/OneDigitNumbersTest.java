package baseball.vo;

import org.junit.jupiter.api.*;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("OneDigitNumbers 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OneDigitNumbersTest {
    void 숫자_분할() {
        int number = 123;
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(number);

        assertThat(oneDigitNumbers.toList()).containsExactly(1, 2, 3);
    }

    @Nested
    class 숫자_길이_확인 {
        @Test
        void 중복_제거() {
            List<Integer> numbers = List.of(9,8,8);
            OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(numbers);

            assertThat(oneDigitNumbers.size(true)).isEqualTo(2);
        }

        @Test
        void 일반() {
            List<Integer> numbers = List.of(9,8,8);
            OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(numbers);

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

    @Test
    void 인덱스로_엘리먼트_찾기() {
        List<Integer> numbers = List.of(1, 2, 3);
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(numbers);

        assertThat(oneDigitNumbers.indexOf(1)).isEqualTo(0);
    }

    @Test
    void 원소_포함_여부() {
        List<Integer> numbers = List.of(1, 2, 3);
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(numbers);

        assertThat(oneDigitNumbers.contains(1)).isTrue();
    }

    @Test
    void 반복문() {
        List<Integer> numbers = List.of(1, 2, 3);
        OneDigitNumbers oneDigitNumbers = new OneDigitNumbers(numbers);
        List<Integer> afterNumbers = new LinkedList<>();

        for (int oneDigitNumber : oneDigitNumbers) {
            afterNumbers.add(oneDigitNumber);
        }

        assertThat(afterNumbers).containsExactly(1, 2, 3);
    }
}