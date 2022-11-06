package baseball.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Setting.LENGTH;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

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

    @Test
    void 유저가_입력한_수가_정답인지_확인하는_기능 () throws Exception {
        //given
        Game game = new Game();
        Method method = Game.class.getDeclaredMethod("isComplete", int.class);
        method.setAccessible(true);
        //when

        //then
        assertThat(method.invoke(game, 3)).isEqualTo(true);
        assertThat(method.invoke(game, 1)).isEqualTo(false);
    }


    @Test
    void 서로_다른_임의의_수_3개를_선택하는_기능() throws Exception {
        //given
        Computer computer = new Computer();
        Method method = Computer.class.getDeclaredMethod("initComputerNumber");
        method.setAccessible(true);
        method.invoke(computer);

        Field field = Computer.class.getDeclaredField("computerNumber");
        field.setAccessible(true);

        List<Integer> computerNumber = (List<Integer>) field.get(computer);

        //when

        //then
        assertThat(isNaturalNumber(computerNumber)).isEqualTo(true);
        assertThat(isRightLength(computerNumber)).isEqualTo(true);
        assertThat(isContainOverlapNumber(computerNumber)).isEqualTo(false);
    }

    private static boolean isNaturalNumber(List<Integer> computerNumber) {
        for (int num : computerNumber) {
            if(!(0 < num && num < 10)) return false;
        }
        return true;
    }

    private static boolean isContainOverlapNumber(List<Integer> computerNumber) {
        Set<Integer> numbers = new HashSet<>();

        for (Integer num : computerNumber) {
            if(!numbers.add(num)) return true;
        }

        return false;
    }

    private static boolean isRightLength(List<Integer> computerNumber) {
        if(computerNumber.size() != LENGTH) return false;
        return true;
    }
}
