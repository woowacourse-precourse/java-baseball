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
}
