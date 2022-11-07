package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    @Test
    void 반환된_스트라이크_수를_검증하는_기능() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("countStrike", List.class, List.class);
        method.setAccessible(true);

        // when
        List<Character> computerNumber = Arrays.asList('1', '2', '3');
        List<Character> userNumber = Arrays.asList('9', '2', '1');

        // then
        Assertions.assertThat(method.invoke(game, computerNumber, userNumber)).isEqualTo(1);
    }

    @Test
    void 반환된_볼_수를_검증하는_기능() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("countBall", List.class, List.class);
        method.setAccessible(true);

        // when
        List<Character> computerNumber = Arrays.asList('1', '2', '3');
        List<Character> userNumber = Arrays.asList('9', '3', '1');

        // then
        Assertions.assertThat(method.invoke(game, computerNumber, userNumber)).isEqualTo(2);
    }

    @Test
    void 같은_수가_없을_때_낫싱을_출력하는_기능() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("checkNothing", int.class, int.class);
        method.setAccessible(true);

        // then
        Assertions.assertThat(method.invoke(game, 0, 0)).isEqualTo(true);
    }

    @Test
    void 볼_스트라이크_상태출력_기능() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("printState", int.class, int.class);
        method.setAccessible(true);

        // then
        Assertions.assertThat(method.invoke(game, 2, 1)).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 컴퓨터가_정한_숫자의_리스트를_반환하는_기능() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("getComputerNumberList");
        method.setAccessible(true);

        // then
        Assertions.assertThat(method.invoke(game)).isInstanceOf(List.class);
    }

    @Test
    void 사용자의_입력을_받아_리스트_형태로_반환하는_기능_테스트() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("getUserNumberList", String.class);
        method.setAccessible(true);

        //when
        List<Character> list = Arrays.asList('1', '2', '3');

        // then
        Assertions.assertThat(method.invoke(game, "123")).isEqualTo(list);
    }

    @Test
    void 재시작_여부를_확인하는_입력값을_확인_후_예외_발생() throws NoSuchMethodException, InvocationTargetException {
        // given
        Game game = new Game();
        Method method = game.getClass().getDeclaredMethod("checkInputValidity", String.class);
        method.setAccessible(true);

        // when
        InvocationTargetException exception = assertThrows(InvocationTargetException.class, () -> method.invoke(game, "3"));

        // then
        assertThat(exception.getCause().getMessage()).isEqualTo("1이나 2가 아닌 숫자가 입력됐습니다.");
    }
}
