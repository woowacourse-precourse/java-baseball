package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ListUtilityTest {
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SplitDigitsIntoList {
        @DisplayName("세자리 수가 리스트로 잘 변환되는지 테스트한다")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void setZero(int number, List<Integer> expected) {
            assertThat(ListUtility.splitDigitsIntoList(number)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(100, Arrays.asList(1, 0, 0)),
                    Arguments.of(999, Arrays.asList(9, 9, 9)),
                    Arguments.of(345, Arrays.asList(3, 4, 5)),
                    Arguments.of(344, Arrays.asList(3, 4, 4)),
                    Arguments.of(333, Arrays.asList(3, 3, 3)));
        }
    }

    @Nested
    class hasDuplicatedCharTest {
        @ParameterizedTest
        @CsvSource(value = {"123, false", "223, true", "222, true", "139, false"})
        @DisplayName("중복된 문자를 발견하면 true를 리턴하는지 테스트한다")
        void checkDuplicatedChar(String stringNumber, boolean expected) {
            assertThat(StringUtility.hasDuplicatedChar(stringNumber)).isEqualTo(expected);
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getDistinctCountInIntegerListTest {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        @DisplayName("Integer형 리스트에서 고유한 값의 개수를 추출하는지 테스트한다")
        void checkDistinctCountInIntegerListTest(List<Integer> list, int expected) {
            assertThat(ListUtility.getDistinctCountInIntegerList(list)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(Arrays.asList(), 0),
                    Arguments.of(Arrays.asList(1), 1),
                    Arguments.of(Arrays.asList(1, 2), 2),
                    Arguments.of(Arrays.asList(1, 2, 3), 3),
                    Arguments.of(Arrays.asList(1, 2, 2), 2),
                    Arguments.of(Arrays.asList(1, 1, 1), 1)
            );
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class mergeDistinctIntegerInListTest {
        @DisplayName("Integer형 리스트에서 각 원소들을 하나의 숫자로 합치는지 테스트한다")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void checkMergeDistinctIntegerInList(List<Integer> list, int expected) {
            assertThat(ListUtility.mergeDistinctIntegerInList(list)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(Arrays.asList(1, 2, 3), 123),
                    Arguments.of(Arrays.asList(9, 8, 7), 987),
                    Arguments.of(Arrays.asList(1, 3, 2), 132)
            );
        }
    }
}