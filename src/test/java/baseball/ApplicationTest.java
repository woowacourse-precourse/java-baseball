package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.internal.bytebuddy.asm.Advice.Thrown;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

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

    @DisplayName("중복된 숫자 여부 테스트")
    @Test
    void 예외_중복문자_테스트() {
        //given
        BaseballNumber dupNumber= new BaseballNumber();

        //then
        assertSimpleTest(() ->
                assertThatThrownBy(()->dupNumber.set("313"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("올바르게 숫자가 생성되었는지 테스트")
    @Test
    void 올바른_숫자_생성_테스트() {
        //given
        Computer computer = new Computer();

        //when
        computer.generateNumber();
        String number = computer.getBaseballNumber();

        //then
        assertThat(BaseballNumber.isValid(number)).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
