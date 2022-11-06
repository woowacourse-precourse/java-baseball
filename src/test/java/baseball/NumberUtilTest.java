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
