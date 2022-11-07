package baseball;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"14015", "47", "111023", "5"})
    @DisplayName("길이가 3이 아닌 숫자 확인 테스트")
    void 사용자_번호가_유효한_숫자인지_확인_테스트_길이_오류() {
        String number = "12345";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null이 들어갔을 경우 숫자 확인 테스트")
    void 사용자_번호가_유효한_숫자인지_확인_테스트_Null() {
        String number = "";
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"140", "503", "023", "500"})
    @DisplayName("길이가 3, 0이 포함 된 숫자 확인 테스트")
    void 사용자_번호가_유효한_숫자인지_확인_테스트_0_포함(String number) {
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 true 반환")
    @ValueSource(strings = {"143", "513", "823", "579"})
    @DisplayName("길이가 3, 0도 포함 안 됨, 중복도 없는 유효한 숫자인지 테스트")
    void 사용자_번호가_유효한_숫자인지_확인_테스트_True(String number) {
        assertThat(isValidUserNumber(number)).isTrue();
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"144", "113", "223,", "555"})
    @DisplayName("길이가 3이고 0도 포함 안 된 숫자 중복 확인 테스트")
    void 사용자_번호가_유효한_숫자인지_확인_테스트_중복(String number) {
        assertThatThrownBy(() -> isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"1e4", "1#3", "~23,", "00 "})
    @DisplayName("숫자가 아닌 번호를 숫자로 변경시 예외 확인 테스트")
    void 번호를_숫자로_변경하는_테스트_숫자가_아님(String number) {
        assertThatThrownBy(() -> getNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자인 변호를 숫자로 변경시 나온 숫자가 예상한 결과와 같은지 확인 테스트")
    void 번호를_숫자로_변경하는_테스트_숫자() {
        String number = "234";
        assertThat(getNumber(number)).isEqualTo(234);
    }

    @Test
    @DisplayName("숫자인 사용자 변호를 숫자로 변경시 나온 결과가 예상한 결과와 같은지 확인 테스트")
    void 사용자_번호를_나눠_숫자로_변경하는_테스트_숫자() {
        String number = "234";
        assertThat(getNumbersToUserNumber(number)).containsExactly(2, 3, 4);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"1e4", "1#3)", "~23,", "00 "})
    @DisplayName("숫자가 아닌 사용자 번호가 숫자로 변경시 예외 발생 확인 테스트")
    void 사용자_번호를_나눠_숫자로_변경하는_테스트_숫자_아님() {
        String number = "23e";
        assertThatThrownBy(() -> getNumbersToUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 true를 반환")
    @ValueSource(strings = {"1ee4", "1#3#?6)", "~2334@67,", "00000"})
    @DisplayName("중복인 번호가 중복인지 확인 테스트")
    void 번호가_중복인지_확인하는_테스트_True(String number) {
        assertThat(isDistinct(number)).isTrue();
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 false를 반환")
    @ValueSource(strings = {"12e4", "1#34?6)", "~234@67,", "0123456789"})
    @DisplayName("중복이 아닌 번호가 중복이 아닌지 확인 테스트")
    void 번호가_중복인지_확인하는_테스트_False(String number) {
        assertThat(isDistinct(number)).isFalse();
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"1234", "1234567", "12345678", "0123456789"})
    @DisplayName("명령 번호가 길이가 1이 아닐때 예외 발생 확인 테스트")
    void 명령_번호가_유효한_숫자인지_확인_테스트_길이_초과(String number) {
        assertThatThrownBy(() -> isValidCommandNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("명령 번호가 null일 때 예외 발생 확인 테스트")
    void 명령_번호가_유효한_숫자인지_확인_테스트_공백() {
        String number = "";
        assertThatThrownBy(() -> isValidCommandNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{0}을 넣었을 때 IllegalArgumentException 발생")
    @ValueSource(strings = {"0", "3", "4", "5"})
    @DisplayName("명령 번호가 1, 2가 아닐 때 예외 발생 확인 테스트")
    void 명령_번호가_유효한_숫자인지_확인_테스트_1_2_미포함(String number) {
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
