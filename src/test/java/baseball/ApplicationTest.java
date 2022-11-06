package baseball;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Setting.LENGTH;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
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
    void 유저가_입력한_수의_스트라이크_수를_반환하는_기능() throws Exception {
        //given
        Computer computer = new Computer();
        Field field = Computer.class.getDeclaredField("computerNumber");
        field.setAccessible(true);

        //when
        field.set(computer, List.of(1, 2, 3));

        //then
        assertThat(computer.countStrike(List.of(1, 2, 3))).isEqualTo(3);
        assertThat(computer.countStrike(List.of(1, 2, 4))).isEqualTo(2);
    }

    @Test
    void 유저가_입력한_수의_볼_수를_반환하는_기능 () throws Exception {
        //given
        Computer computer = new Computer();
        Field field = Computer.class.getDeclaredField("computerNumber");
        field.setAccessible(true);

        //when
        field.set(computer, List.of(1, 2, 3));

        //then
        assertThat(computer.countBall(List.of(1, 2, 3))).isEqualTo(0);
        assertThat(computer.countBall(List.of(3, 1, 2))).isEqualTo(3);
        assertThat(computer.countBall(List.of(4, 5, 6))).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

/*    private static boolean isNaturalNumber(String input) {
        char[] userNumber = input.toCharArray();
        for (char c : userNumber) {
            int num = Character.getNumericValue(c);
            if(!(0 < num && num < 10)) return false;
        }
        return true;
    }

    private static boolean isContainOverlapNumber(String input) {
        Set<Character> numbers = new HashSet<>();

        for (char c : input.toCharArray()) {
            if(!numbers.add(c)) return false;
        }

        return true;
    }*/
}
