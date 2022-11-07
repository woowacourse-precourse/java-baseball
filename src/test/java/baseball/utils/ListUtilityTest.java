package baseball.utils;

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

import static org.assertj.core.api.Assertions.assertThat;

class UtilityTest {
    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class SplitDigitsIntoList {
        @DisplayName("세자리 수가 잘 입력되는지 확인")
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void setZero(int number, List<Integer> expected) {
            assertThat(Utility.splitDigitsIntoList(number)).isEqualTo(expected);
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
        void checkDuplicatedChar(String stringNumber, boolean expected) {
            assertThat(Utility.hasDuplicatedChar(stringNumber)).isEqualTo(expected);
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getDistinctCountInIntegerListTest {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void checkDistinctCountInIntegerListTest(List<Integer> list, int expected) {
            assertThat(Utility.getDistinctCountInIntegerList(list)).isEqualTo(expected);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(Arrays.asList(), 0),
                    Arguments.of(Arrays.asList(1), 1),
                    Arguments.of(Arrays.asList(1, 2), 2),
                    Arguments.of(Arrays.asList(1, 2, 3), 3)
            );
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class mergeDistinctIntegerInListTest {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void checkMergeDistinctIntegerInList(List<Integer> list, int expected) {
            assertThat(Utility.mergeDistinctIntegerInList(list)).isEqualTo(expected);
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