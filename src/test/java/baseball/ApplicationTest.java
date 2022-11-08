package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임시작_메시지출력() {
        assertSimpleTest(
                () -> {
                    run();
                    assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
                }
        );
    }

    @Test
    void 컴퓨터_세자리난수배정(){
        Computer computer = new Computer();
        computer.setComputerRandomNumber();
        List<Integer> testNumber1 = computer.getComputerNumber();

        System.out.println(testNumber1);

        assertThat(testNumber1.size()).isEqualTo(3);
    }

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
    void 숫자길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_입력_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("n12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
