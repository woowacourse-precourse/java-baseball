package baseball.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BaseballManagerTest {
    @ParameterizedTest
    @MethodSource("parameterProvider")
    @DisplayName("컴퓨터 숫자가 Randoms 모듈의 랜덤값으로 잘 생성되는지 테스트한다")
    void 컴퓨터_숫자가_랜덤값에_의해_잘_생성되는지_확인(int number, List<Integer> expected) {
        BaseballNumber userNumber = new BaseballNumber(number);
        BaseballManager baseballManager = new BaseballManager();
        baseballManager.addUserBaseballNumInfo(userNumber);

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