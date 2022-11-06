package baseball.domain;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

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
}
