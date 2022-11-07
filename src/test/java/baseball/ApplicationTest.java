package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {

    Computer computer = new Computer();
    Player player = new Player();

    final int digitNumber = 3;
    String input = "123";

    @Test
    void 컴퓨터의_수_개수_확인() {
        List<Integer> numberList = computer.makeNumber();
        assertEquals(numberList.size(), digitNumber);
    }

    @Test
    void 컴퓨터의_수_범위_확인(){
        List<Integer> numberList = computer.makeNumber();
        int num = (int) numberList.stream()
                .filter(n -> n >= 1 && n <= 9).count();
        assertThat(num).isEqualTo(digitNumber);
    }

    @Test
    void 플레이어의_숫자_개수_확인(){
        List<Integer> numberList = player.getNumberList(input,digitNumber);
        assertEquals(numberList.size(), digitNumber);
    }

    @Test
    void 플레이어의_숫자_범위_확인(){
        List<Integer> numberList = player.getNumberList(input,digitNumber);
        int num = (int) numberList.stream()
                .filter(n -> n >= 1 && n <= 9).count();
        assertThat(num).isEqualTo(digitNumber);
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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자릿수_부족_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_경우_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
