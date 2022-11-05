package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import baseball.Opponent;

import java.util.ArrayList;
import java.util.Arrays;
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
    void opponentHaveThreeNumber(){
        Opponent cpu = new Opponent();
        assertThat(cpu.getNumbers().size()).isEqualTo(3);
    }

    @Test
    void ballTestTrue(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);

        assertThat(cpu.isBall(0,3)).isEqualTo(true);
        assertThat(cpu.isBall(1,3)).isEqualTo(true);
    }

    @Test
    void ballTestFalse(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);

        //strike
        assertThat(cpu.isBall(0,1)).isEqualTo(false);
        assertThat(cpu.isBall(1,2)).isEqualTo(false);
        assertThat(cpu.isBall(2,3)).isEqualTo(false);

        //no-ball
        assertThat(cpu.isBall(0,5)).isEqualTo(false);
        assertThat(cpu.isBall(1,9)).isEqualTo(false);
    }

    @Test
    void strikeTestTrue(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);

        assertThat(cpu.isStrike(0,1)).isEqualTo(true);
        assertThat(cpu.isStrike(1,2)).isEqualTo(true);
        assertThat(cpu.isStrike(2,3)).isEqualTo(true);
    }

    @Test
    void strikeTestFalse(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);

        //ball
        assertThat(cpu.isStrike(0,2)).isEqualTo(false);
        assertThat(cpu.isStrike(1,3)).isEqualTo(false);
        assertThat(cpu.isStrike(2,1)).isEqualTo(false);
        //no-strike;
        assertThat(cpu.isStrike(1,9)).isEqualTo(false);
        assertThat(cpu.isStrike(2,8)).isEqualTo(false);
    }

    @Test
    void makeHintTest(){
        Opponent cpu = new Opponent();
        List<Integer> cpu_numbers = List.of(1,2,3);
        cpu.setNumbers(cpu_numbers);

        assertThat(cpu.makeHint("123")).isEqualTo("30");
        assertThat(cpu.makeHint("231")).isEqualTo("03");
        assertThat(cpu.makeHint("124")).isEqualTo("20");
        assertThat(cpu.makeHint("132")).isEqualTo("12");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
