package baseball.domain;

import baseball.domain.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseballManagerTest {
    @ParameterizedTest
    @DisplayName("initComputerNumber 테스트")
    @MethodSource("parameterProvider")
    void 컴퓨터_숫자가_잘_생성되는지_확인(int number, List<Integer> expected) {
        // given
        BaseballNumber userNumber = new BaseballNumber(number);
        BaseballManager baseballManager = new BaseballManager();
        // when
        baseballManager.addUserBaseballNumInfo(userNumber);
        // then
        assertRandomNumberInRangeTest(
                () -> {
                    baseballManager.initComputerNumber();
                    baseballManager.computeUserScore();
                    assertThat(baseballManager.getUserScore())
                            .isEqualTo(expected);
                },
                3, 9, 2
        );
    }

    private Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(392, Arrays.asList(0, 3))
        );
    }
}