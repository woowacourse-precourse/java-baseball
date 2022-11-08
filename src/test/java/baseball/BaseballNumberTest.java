package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class BaseballNumberTest {
    @Test
    void 정수_리스트를_인자로_받는_생성자() {
        List<Integer> numbers = new ArrayList<>();

        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            numbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }

        assertDoesNotThrow(() -> new BaseballNumber(numbers));
    }

    @Test
    void String을_인자로_받는_생성자() {
        List<Integer> numbers = new ArrayList<>();

        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            numbers.add(BaseballNumber.MIN_NUMBER + count - 1);
        }

        String numbersString = numbers.stream().map(x -> Integer.toString(x)).collect(Collectors.joining(""));
        assertDoesNotThrow(() -> new BaseballNumber(numbersString));
    }

    @Test
    void 숫자가_아닌_글자가_포함되면_예외_발생() {
        List<String> numbers = new ArrayList<>();

        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            numbers.add(String.valueOf((char) ('a' + count - 1)));
        }

        assertThatThrownBy(() -> new BaseballNumber(String.join("", numbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseballNumber.NOT_A_NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    void 중복된_숫자가_있다면_예외_발생() {
        List<Integer> numbers = new ArrayList<>();
        for (int count = 1; count <= BaseballNumber.NUMBER_COUNT; count++) {
            numbers.add(BaseballNumber.MIN_NUMBER);
        }

        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BaseballNumber.DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
    }

    @Test
    void 숫자_개수가_규칙보다_적으면_예외_발생() {
        List<Integer> numbers = new ArrayList<>();
        for (int count = 1; count <= 2; count++) {
            numbers.add(count);
        }
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BaseballNumber.NOT_PROPER_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    void 숫자_개수가_규칙보다_많으면_예외_발생() {
        List<Integer> numbers = new ArrayList<>();
        for (int count = 1; count <= 4; count++) {
            numbers.add(count);
        }
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BaseballNumber.NOT_PROPER_SIZE_EXCEPTION_MESSAGE);
    }

    @Test
    void 유효한_숫자가_범위를_벗어나면_에러발생2() {
        List<Integer> numbers = List.of(10, 1, 2);
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseballNumber.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }

    @Test
    void 유효한_숫자가_범위를_벗어나면_에러발생3() {
        List<Integer> numbers = List.of(0, 1, 2);
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseballNumber.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }

    @Test
    void 유효한_숫자가_범위를_벗어나면_에러발생4() {
        List<Integer> numbers = List.of(-1, 1, 2);
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseballNumber.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }

    @Test
    void 유효한_숫자가_범위를_벗어나면_에러발생5() {
        List<Integer> numbers = List.of(1000000, -1000000, 2);
        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BaseballNumber.OUT_OF_RANGE_EXCEPTION_MESSAGE);
    }

    @Test
    void 컴퓨터가_선택한_숫자는_항상_올바르다() {
        assertDoesNotThrow(BaseballNumber::getComputerPickedNumbers);
    }

    @Test
    void 특정_인덱스의_숫자를_가져온다() {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            numbers.add(index + 1);
        }

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            int expected = numbers.get(index);
            int result = baseballNumber.get(index);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Test
    void 특정_인덱스의_숫자가_맞다면_참_반환() {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            numbers.add(index + 1);
        }

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        boolean expected = true;

        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            boolean result = baseballNumber.is_number_in_index_equal_to(index, numbers.get(index));
            assertThat(result).isEqualTo(expected);
        }

    }

    @Test
    void 특정_인덱스의_숫자가_틀리다면_거짓_반환() {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            numbers.add(index + 1);
        }

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        boolean expected = false;
        boolean result = baseballNumber.is_number_in_index_equal_to
                (BaseballNumber.NUMBER_COUNT - 1, -1);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 숫자를_포함하고_있다면_참_반환() {

        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            numbers.add(index + 1);
        }

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        boolean expected = true;
        boolean result = baseballNumber.contains(baseballNumber.get(BaseballNumber.NUMBER_COUNT - 1));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 숫자를_포함하지_않는다면_거짓_반환() {

        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < BaseballNumber.NUMBER_COUNT; index++) {
            numbers.add(index + 1);
        }

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        boolean expected = false;
        boolean result = baseballNumber.contains(-1);
        assertThat(result).isEqualTo(expected);
    }

}