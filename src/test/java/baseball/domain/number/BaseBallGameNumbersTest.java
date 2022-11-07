package baseball.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BaseBallGameNumbers 는 ")
class BaseBallGameNumbersTest {

    @Test
    @DisplayName("문자열을 통해 생성된다.")
    void constructedByString() {
        // given
        String input = "123";

        // when
        BaseBallGameNumbers ballGameNumbers = new BaseBallGameNumbers(input);

        // then
        assertThat(ballGameNumbers.numbers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("정수 리스트를 통해 생성된다.")
    void constructedByIntegerList() {
        // given
        List<Integer> integers = List.of(1, 2, 3);

        // when
        BaseBallGameNumbers ballGameNumbers = new BaseBallGameNumbers(integers);

        // then
        assertThat(ballGameNumbers.numbers().size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "입력된 순서({arguments})가 유지된다.")
    @ValueSource(strings = {"123", "321", "132"})
    void maintainInputOrder(final String input) {
        // given
        List<BaseBallGameNumber> inputNumbers = stream(input.split(""))
                .map(BaseBallGameNumber::new)
                .collect(Collectors.toList());

        // when
        BaseBallGameNumbers ballGameNumbers = new BaseBallGameNumbers(input);

        // then
        List<BaseBallGameNumber> numbers = ballGameNumbers.numbers();
        int size = inputNumbers.size();
        for (int i = 0; i < size; i++) {
           assertThat(numbers.get(i).value()).isEqualTo(inputNumbers.get(i).value());
        }
    }


    @ParameterizedTest(name = "({arguments})를 통해 총 3개의 BaseBallGameNumber를 생성하지 못했다면 IllegalArgumentException을 발생시킨다.")
    @ValueSource(strings = {"102", "998", "987654323123321564123", "13d", "abc", ""})
    void throwIllegalArgumentExceptionWhenConstructedByInvalidStringInput(final String input) {

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(input));
    }

    @Test
    @DisplayName("정수 리스트를 통해 총 3개의 BaseBallGameNumber를 생성하지 못했다면 IllegalArgumentException을 발생시킨다.")
    void throwIllegalArgumentExceptionWhenConstructedByInvalidIntegerInput() {
        // given
        List<Integer> underRangeInput = List.of(1, 0, 2);
        List<Integer> upperRangeInput = List.of(12, 3, 5);
        List<Integer> duplicatedIntegerInput = List.of(9, 9, 8);
        List<Integer> largerThenInputSizeInput = List.of(9,8,7,6,5,4,3,2,1);
        List<Integer> emptyInput = List.of();

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(underRangeInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(upperRangeInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(duplicatedIntegerInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(largerThenInputSizeInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(emptyInput));
    }
}