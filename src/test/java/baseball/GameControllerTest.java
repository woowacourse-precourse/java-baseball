package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GameControllerTest {

    @Test
    void inputStatementNumber_메소드로_statement_입력받음()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameController gameController = new GameController();
        Method method = gameController.getClass().getDeclaredMethod("inputStatementNumber");
        method.setAccessible(true);

        String input = "1";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = (String) method.invoke(gameController);

        Assertions.assertThat(result).isEqualTo("1");
    }

    @Test
    void restartGame_메소드로_1_입력_시_게임_재시작()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameController gameController = new GameController();

        Method method = gameController.getClass().getDeclaredMethod("restartGame");
        method.setAccessible(true);

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = (boolean) method.invoke(gameController);
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void restartGame_메소드로_2_입력_시_종료()
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        GameController gameController = new GameController();

        Method method = gameController.getClass().getDeclaredMethod("restartGame");
        method.setAccessible(true);

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = (boolean) method.invoke(gameController);
        Assertions.assertThat(result).isFalse();
    }
}