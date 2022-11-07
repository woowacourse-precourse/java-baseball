package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
    }

    @Test
    void validateIsThreeNumber_메서드_사용시_서로다른_3자리숫자_입력한_경우_정상종료() throws Exception {
        // given
        String playerInput = "123";
        Method validateMethod1 = player.getClass().getDeclaredMethod("validateIsThreeNumber", String.class);
        Method validateMethod2 = player.getClass().getDeclaredMethod("validateIsUniqueNumber", String.class);

        validateMethod1.setAccessible(true);
        validateMethod2.setAccessible(true);

        // when, then
        validateMethod1.invoke(player, playerInput);
        validateMethod2.invoke(player, playerInput);
    }

    @Test
    void validateIsThreeNumber_메서드_사용시_숫자가_아닌값을_입력한경우_예외발생() throws Exception {
        // given
        String playerInput = "가나다";
        Method method = player.getClass().getDeclaredMethod("validateIsThreeNumber", String.class);
        method.setAccessible(true);
        // when, then
        assertThrows(InvocationTargetException.class, () -> method.invoke(player, playerInput));
    }

    @Test
    void validateIsThreeNumber_메서드_사용시_세자리_숫자를_입력하지_않은_경우_예외발생() throws Exception {
        // given
        String playerInput = "12";
        Method method = player.getClass().getDeclaredMethod("validateIsThreeNumber", String.class);
        method.setAccessible(true);
        // when, then
        assertThrows(InvocationTargetException.class, () -> method.invoke(player, playerInput));
    }

    @Test
    void validateIsUniqueNumber_메서드_사용시_중복된_숫자를_입력한경우_예외발생() throws Exception {
        // given
        String playerInput = "112";
        Method method = player.getClass().getDeclaredMethod("validateIsUniqueNumber", String.class);
        method.setAccessible(true);
        // when, then
        assertThrows(InvocationTargetException.class, () -> method.invoke(player, playerInput));
    }

    @Test
    void validateIsRestartNumber_메서드_사용시_입력값이_1인경우_정상_종료() throws Exception {
        // given
        String playerInput = "1";

        Method method = player.getClass().getDeclaredMethod("validateIsRestartNumber", String.class);
        method.setAccessible(true);
        // when, then
        method.invoke(player, playerInput);
    }

    @Test
    void validateIsRestartNumber_메서드_사용시_입력값이_2인경우_정상_종료() throws Exception {
        // given
        String playerInput = "2";
        Method method = player.getClass().getDeclaredMethod("validateIsRestartNumber", String.class);
        method.setAccessible(true);
        // when, then
        method.invoke(player, playerInput);
    }

    @Test
    void validateIsRestartNumber_메서드_사용시_1과_2가_아닌값을_입력한_경우_예외발생() throws Exception {
        // given
        String playerInput = "3";
        Method method = player.getClass().getDeclaredMethod("validateIsRestartNumber", String.class);
        method.setAccessible(true);
        // when, then
        assertThrows(InvocationTargetException.class, () -> method.invoke(player, playerInput));
    }

}