package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberUtilTest {
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
