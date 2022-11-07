package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.Application.getNumber;
import static baseball.Application.isValidUserNumber;
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
        assertThatThrownBy(()->isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_길이_미만() {
        String number = "12";
        assertThatThrownBy(()->isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_Null() {
        String number = "";
        assertThatThrownBy(()->isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_번호가_유효한_숫자인지_확인_테스트_0_포함() {
        String number = "120";
        assertThatThrownBy(()->isValidUserNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 번호를_숫자로_변경하는_테스트_숫자가_아님() {
        String number = "12e";
        assertThatThrownBy(()->getNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
