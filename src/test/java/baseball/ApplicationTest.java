package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_길이_초과() {
        String number = "12345";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_길이_미만() {
        String number = "12";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_Null() {
        String number = "";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_0_포함() {
        String number = "120";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_True() {
        String number = "123";
        assertThat(isValidUserNumber(number)).isTrue();
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_중복() {
        String number = "133";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호를_숫자로_변경하는_테스트_숫자가_아님() {
        String number = "12e";
        assertThatThrownBy(() -> getNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호를_숫자로_변경하는_테스트_숫자() {
        String number = "234";
        assertThat(getNumber(number)).isEqualTo(234);
    }

    @Test
    void 사용자_번호를_나눠_숫자로_변경하는_테스트_숫자() {
        String number = "234";
        int[] result = {2, 3, 4};
        assertThat(getNumbersToUserNumber(number)).isEqualTo(result);
    }

    @Test
    void 사용자_번호를_나눠_숫자로_변경하는_테스트_숫자_아님() {
        String number = "23e";
        assertThatThrownBy(() -> getNumbersToUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호가_중복인지_확인하는_테스트_True() {
        String number = "2234e";
        assertThat(isDistinct(number)).isTrue();
    }

    @Test
    void 번호가_중복인지_확인하는_테스트_False() {
        String number = "234e";
        assertThat(isDistinct(number)).isFalse();
    }

    @Test
    void 명령_번호가_유효한_숫자인지_확인_테스트_길이_초과() {
        String number = "12345";
        assertThatThrownBy(() -> isValidCommandNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 명령_번호가_유효한_숫자인지_확인_테스트_공백() {
        String number = "";
        assertThatThrownBy(() -> isValidCommandNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    void 명령_번호가_유효한_숫자인지_확인_테스트_1_2_미포함() {
        String number = "3";
        assertThatThrownBy(() -> isValidCommandNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 true를 반환")
    @ValueSource(strings = {"1", "2"})
    @DisplayName("명령 번호가 유효한 숫자인지 확인 테스트")
    void 명령_번호가_유효한_숫자인지_확인_테스트(String number) {
        assertThat(isValidCommandNumber(number)).isTrue();
    }

    @RepeatedTest(10)
    @DisplayName("랜덤 번호가 중복이 없는지 확인하는 테스트")
    void 랜덤_번호_생성_확인_테스트() {
        List<Integer> randomNumbers = getRandomNumbers();
        Set<Integer> notDistinctNumbers = new HashSet<>(randomNumbers);

        assertThat(randomNumbers.size()).isEqualTo(notDistinctNumbers.size());
    }

    @Test
    @DisplayName("유저 번호와 컴퓨터 번호의 게임 결과 확인 테스트")
    void 유저_번호와_컴퓨터_번호의_게임_결과_확인_테스트() {
        List<Integer> computerNumber = List.of(1, 2, 4);
        int[] userNumber = {1, 4, 3};
        assertThat(getGameResult(computerNumber, userNumber)).containsExactly(1, 1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
