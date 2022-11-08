package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_0_입력_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_이외_값_입력_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터_게임_준비_테스트(){
        Computer computer = new Computer();
        computer.ready();
        assertThat(computer.getIsGameEnd()).isEqualTo(false);
    }

    @Test
    void 컴퓨터_게임_결과_주기_테스트(){
        Computer computer = new Computer();
        computer.ready();
        List<Integer> suggestion = new ArrayList<>();
        suggestion.add(1);
        suggestion.add(2);
        suggestion.add(3);
        computer.giveResult(suggestion);
        assertThat(output()).containsAnyOf("낫싱", "스트라이크", "볼");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
