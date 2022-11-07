package baseball;

import baseball.answer.RandomsGenerator;
import baseball.input.ConsoleInput;
import baseball.text.GameResultText;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    private final BaseBall baseBall = new BaseBall(new RandomsGenerator(),
            new ConsoleInput());

    private void mockInit() throws NoSuchFieldException, IllegalAccessException {
        Field mockAnswer = baseBall.getClass().getDeclaredField("answer");
        mockAnswer.setAccessible(true);
        mockAnswer.set(baseBall, List.of(1,2,3));

        Field ball = baseBall.getClass().getDeclaredField("ball");
        ball.setAccessible(true);
        ball.set(baseBall, 0);
        ball.setAccessible(false);

        Field strike = baseBall.getClass().getDeclaredField("strike");
        strike.setAccessible(true);
        strike.set(baseBall, 0);
        strike.setAccessible(false);
    }

    private int getBall() throws NoSuchFieldException, IllegalAccessException {
        Field ball = baseBall.getClass().getDeclaredField("ball");
        ball.setAccessible(true);
        return ball.getInt(baseBall);
    }

    private int getStrike() throws NoSuchFieldException, IllegalAccessException {
        Field strike = baseBall.getClass().getDeclaredField("strike");
        strike.setAccessible(true);
        return strike.getInt(baseBall);
    }


    @Test
    void play_test() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Method updateUserAnswer = baseBall.getClass().getDeclaredMethod("updateUserAnswer");
        updateUserAnswer.setAccessible(true);
        Method updateResult = baseBall.getClass().getDeclaredMethod("updateResult");
        updateResult.setAccessible(true);

        mockInit();
        updateUserAnswer.invoke(baseBall);
        updateResult.invoke(baseBall);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameResultText.print(getBall(), getStrike());

        Assertions.assertThat(out.toString())
                .isEqualTo("3스트라이크\n" +
                        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

}