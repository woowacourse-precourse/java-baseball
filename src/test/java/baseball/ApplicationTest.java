package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터_숫자_크기_테스트(){
        Assertions.assertThat(Application.reComputerNumber().size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터_숫자_다른숫자_테스트(){
        org.junit.jupiter.api.Assertions.assertFalse(Application.reComputerNumber().get(0).equals(Application.reComputerNumber().get(1)));
        org.junit.jupiter.api.Assertions.assertFalse(Application.reComputerNumber().get(0).equals(Application.reComputerNumber().get(2)));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
