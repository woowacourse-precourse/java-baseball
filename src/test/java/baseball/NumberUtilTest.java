package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilTest {
    @RepeatedTest(10)
    @DisplayName("random 함수가 1부터 9 사이의 서로 다른 임의의 숫자 3개를 반환하는지 확인한다")
    void randomTest() {
        List<Integer> numbers = NumberUtil.random();
        Assertions.assertAll(
                () -> assertEquals(3, numbers.size()),
                () -> assertTrue(numbers.stream().allMatch(i -> NumberUtil.NUMBER_START <= i && i <= NumberUtil.NUMBER_END)),
                () -> assertEquals(NumberUtil.NUMBER_SIZE, numbers.stream().distinct().count())
        );
    }

    @Test
    @DisplayName("inputNumber 함수가 1부터 9 사이의 서로 다른 임의의 숫자 3개를 반환하는지 확인한다")
    void inputNumbersTest() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        List<Integer> numbers = NumberUtil.inputNumbers();
        Assertions.assertAll(
                () -> assertEquals(3, numbers.size()),
                () -> assertTrue(numbers.stream().allMatch(i -> NumberUtil.NUMBER_START <= i && i <= NumberUtil.NUMBER_END)),
                () -> assertEquals(NumberUtil.NUMBER_SIZE, numbers.stream().distinct().count())
        );
    }

    @ParameterizedTest
    @CsvSource(
            value = {"119:1", "가나다라:1", ":2", "-12:2", "a@c!ef:3"}
    )
    @DisplayName("inputNumber 함수가 null을 반환하는지 확인한다")
    void inputNumbersNullTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        List<Integer> numbers = NumberUtil.inputNumbers();
        assertThat(numbers).isEqualTo(null);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    @DisplayName("inputNumber 함수가 1 또는 2를 반환하는지 확인한다")
    void inputNumberTest(String input, int result) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        int number = NumberUtil.inputNumber();
        assertThat(number).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"12:0", "a:0"}, delimiter = ':')
    @DisplayName("inputNumber 함수가 0을 반환하는지 확인한다")
    void inputNumberZeroTest(String input, int result) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        int number = NumberUtil.inputNumber();
        assertThat(number).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(
            value = {"119:3", "가나다라:4", ":0", "-12:3", "a@c!ef:6"},
            delimiter = ':'
    )
    @DisplayName("lengthCheck 함수가 주어진 문자열의 길이와 length 가 같다고 판단하는지 확인한다")
    void lengthCheckTestO(String str, int length) {
        assertTrue(NumberUtil.lengthCheck(str, length));
    }

    @ParameterizedTest
    @CsvSource(
            value = {"119:1", "가나다라:1", ":2", "-12:2", "a@c!ef:3"},
            delimiter = ':'
    )
    @DisplayName("lengthCheck 함수가 주어진 문자열의 길이와 length 가 다르다고 판단하는지 확인한다")
    void lengthCheckTestX(String str, int length) {
        assertFalse(NumberUtil.lengthCheck(str, length));
    }

    @ParameterizedTest
    @CsvSource(
            value = {"2:1:9", "51:1:8", "127:1:9", "113:1:9"},
            delimiter = ':'
    )
    @DisplayName("numericBoundCheck 함수가 모든 문자열 구성 문자가 start 부터 end 사이의 숫자라고 판단하는 것을 확인한다")
    void numericBoundCheckTestO(String str, int start, int end) {
        assertTrue(NumberUtil.numericBoundCheck(str, start, end));
    }

    @ParameterizedTest
    @CsvSource(
            value = {":1:9", "a11:1:8", "179:0:3"},
            delimiter = ':'
    )
    @DisplayName("numericBoundCheck 함수가 문자열 구성 문자 중 일부가 start 부터 end 사이의 숫자가 아니라고 판단하는 것을 확인한다")
    void numericBoundCheckTestX(String str, int start, int end) {
        assertFalse(NumberUtil.numericBoundCheck(str, start, end));
    }

    @ParameterizedTest
    @MethodSource({"provideNoDuplTestcase"})
    @DisplayName("noDuplicateCheck 함수가 문자열에 중복이 없는 것을 감지하는지 확인한다")
    void noDuplicateCheckTestO(String str) {
        assertTrue(NumberUtil.noDuplicateCheck(str));
    }

    @ParameterizedTest
    @CsvSource({"aab", "1122", "!!-", "a11", "**b1"})
    @DisplayName("oDuplicateCheck 함수가 문자열에 중복이 있는 것을 감지하는지 확인한다")
    void noDuplicateCheckTestX(String str) {
        assertFalse(NumberUtil.noDuplicateCheck(str));
    }

    private static Stream<Arguments> provideNoDuplTestcase() {
        return Stream.of(
                Arguments.of("", null),
                Arguments.of("abc", null),
                Arguments.of("123", Arrays.asList(1, 2, 3)),
                Arguments.of("!-*", null),
                Arguments.of("a1", null));
    }
}
