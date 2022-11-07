package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @BeforeEach
    void 초기화() {
        Application.getResultMap().clear();
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
    void 서로_다른_임의의_수_3개_선택하여_저장하기() {
        List<Integer> numberList = new ArrayList<>();
        Application.makeRandomNumbers(numberList);
        Set<Integer> numberSet = new HashSet<>(numberList);
        assertThat(numberList).hasSameSizeAs(numberSet);
    }

    @Test
    void 컴퓨터의_수와_플레이어의_수_비교하기_1볼_1스트라이크() {
       List<Integer> computer = List.of(1,5,9);
       List<Integer> player = List.of(1,6,5);
       Application.calculate(computer, player);
       Map<State, Integer> map = Application.getResultMap();

       assertThat(map.get(State.STRIKE)).isEqualTo(1);
       assertThat(map.get(State.BALL)).isEqualTo(1);
        assertThat(map.get(State.NOTHING)).isEqualTo(1);
    }

    @Test
    void 컴퓨터의_수와_플레이어의_수_비교하기_3볼() {
        List<Integer> computer = List.of(1,5,9);
        List<Integer> player = List.of(9,1,5);
        Application.calculate(computer, player);
        Map<State, Integer> map = Application.getResultMap();

        assertThat(map.get(State.BALL)).isEqualTo(3);
        assertThat(map).doesNotContainKey(State.NOTHING);
        assertThat(map).doesNotContainKey(State.STRIKE);
    }

    @Test
    void 컴퓨터의_수와_플레이어의_수_비교하기_1스트라이크() {
        List<Integer> computer = List.of(1,5,9);
        List<Integer> player = List.of(1,4,3);
        Application.calculate(computer, player);
        Map<State, Integer> map = Application.getResultMap();

        assertThat(map.get(State.STRIKE)).isEqualTo(1);
        assertThat(map.get(State.NOTHING)).isEqualTo(2);
        assertThat(map).doesNotContainKey(State.BALL);
    }

    @Test
    void 출력테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<Integer> computer = List.of(1,5,9);
        List<Integer> player = List.of(1,9,3);
        Application.calculate(computer, player);
        Map<State, Integer> map = Application.getResultMap();
        IOUtil.printMapToConsole(map);

        assertThat(out).asString().isEqualTo("1볼 1스트라이크\n");
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
