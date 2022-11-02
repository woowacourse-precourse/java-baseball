package baseball.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BaseBallGameNumbers 는 ")
class BaseBallGameNumbersTest {

    @Test
    @DisplayName("문자열을 통해 생성된다.")
    public void constructedByString() {
        // given
        String input = "123";

        // when
        BaseBallGameNumbers ballGameNumbers = new BaseBallGameNumbers(input);

        // then
        assertThat(ballGameNumbers.numbers().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력된 순서가 유지된다.")
    public void maintainInputOrder() {
        // given
        String input = "296";
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


    @Test
    @DisplayName("총 3개의 BaseBallGameNumber를 생성하지 못했다면 IllegalArgumentException을 발생시킨다.")
    public void throwIllegalArgumentExceptionWhenConstructedByInvalidInput() {
        // given
        String underRangeInput = "102";
        String duplicatedIntegerInput = "998";
        String largerThenInputSizeInput = "987654323123321564123";
        String containsNonIntegerInput = "13d";
        String consistOfAllNonIntegerInput = "abc";
        String emptyInput = "";

        // when, then
        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(underRangeInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(duplicatedIntegerInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(largerThenInputSizeInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(containsNonIntegerInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(consistOfAllNonIntegerInput));

        assertThrows(IllegalArgumentException.class,
                () -> new BaseBallGameNumbers(emptyInput));
    }
}