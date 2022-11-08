package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    void 게임종료_후_재시작2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "357", "246", "1", "795", "859", "589", "2");
                    assertThat(output()).contains("3스트라이크", "낫싱", "3스트라이크", "2볼", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 2, 4, 6, 5, 8, 9
        );
    }

    @Test
    @DisplayName("False: 낫싱")
    void comparator_숫자_비교_결과_1() {
        Application application = new Application();
        List<Integer> userNum = List.of(1, 7, 5);
        List<Integer> computerNum = List.of(2, 3, 4);
        assertThat(application.compareNums(computerNum, userNum)).isEqualTo(false);
    }

    @Test
    @DisplayName("True: 3스트라이크")
    void comparator_숫자_비교_결과_2() {
        Application application = new Application();
        List<Integer> userNum = List.of(1, 7, 5);
        List<Integer> computerNum = List.of(1, 7, 5);
        assertThat(application.compareNums(computerNum, userNum)).isEqualTo(true);
    }

    @Test
    @DisplayName("False: 2볼 1스트라이크")
    void comparator_숫자_비교_결과_3() {
        Application application = new Application();
        List<Integer> userNum = List.of(1, 7, 5);
        List<Integer> computerNum = List.of(1, 5, 7);
        assertThat(application.compareNums(computerNum, userNum)).isEqualTo(false);
    }

    @Test
    @DisplayName("False: 1스트라이크")
    void comparator_숫자_비교_결과_4() {
        Application application = new Application();
        List<Integer> userNum = List.of(1, 7, 5);
        List<Integer> computerNum = List.of(2, 4, 5);
        assertThat(application.compareNums(computerNum, userNum)).isEqualTo(false);
    }

    @Test
    @DisplayName("False: 2스트라이크")
    void comparator_숫자_비교_결과_5() {
        Application application = new Application();
        List<Integer> userNum = List.of(1, 7, 5);
        List<Integer> computerNum = List.of(2, 7, 5);
        assertThat(application.compareNums(computerNum, userNum)).isEqualTo(false);
    }

    @Test
    @DisplayName("False: 3볼")
    void comparator_숫자_비교_결과_6() {
        Application application = new Application();
        List<Integer> userNum = List.of(1, 7, 5);
        List<Integer> computerNum = List.of(5, 1, 7);
        assertThat(application.compareNums(computerNum, userNum)).isEqualTo(false);
    }

    @Test
    @DisplayName("Exception: 숫자의 길이가 3보다 클 떄")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("Exception: 입력값이 서로 다른 숫자가 아닐 때")
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("Exception: 입력값이 서로 다른 숫자가 아니고, 길이가 3이 넘을 때")
    void 예외_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
