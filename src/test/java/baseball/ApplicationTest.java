package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.Application.generateComputerNum;
import static baseball.Application.splitUserNumToList;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void 예외_테스트2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABCD"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터가_세개의_수를_뽑는지(){
        assertThat(generateComputerNum().size()).isEqualTo(3);
    }

    @Test
    void 유저의_숫자들이_리스트로_저장되었는지(){
        String num="123";
        assertThat(splitUserNumToList(num)).containsExactly(1,2,3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
