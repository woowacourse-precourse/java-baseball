package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void 예외_테스트1_숫자가_아닌_문자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트2_숫자가_아닌_문자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!!!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트3_중복된_숫자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트4_3자리_이상_숫자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자리와_숫자가_맞을_떄_스트라이크_증가_테스트() {
        //Given
        List<Integer> computerNum = List.of(3, 4, 5);
        Computer computer = new Computer();
        computer.setComputerNumber(computerNum);

        //When
        List<Integer> testNum = List.of(1, 4, 5);

        //Then
        Assertions.assertThat(computer.countStrike(testNum)).isEqualTo(2);
    }

    @Test
    void 숫자만_맞을_떄_볼_증가_테스트() {
        //Given
        List<Integer> computerNum = List.of(3, 4, 5);
        Computer computer = new Computer();
        computer.setComputerNumber(computerNum);

        //When
        List<Integer> testNum = List.of(4, 1, 5);

        //Then
        Assertions.assertThat(computer.countBall(testNum)).isEqualTo(1);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
