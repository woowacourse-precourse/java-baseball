package baseball.controller;

import baseball.domain.Ball;
import baseball.view.PrintMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class BasicBaseballGameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final BasicBaseballGame basicBaseballGame = new BasicBaseballGame();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("isThreeStrike 메소드에 숫자 2를 입력하면 false를 반환하는지 확인")
    void isThreeStrike_test_with_integer_2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = basicBaseballGame.getClass().getDeclaredMethod("isThreeStrike", int.class);
        method.setAccessible(true);
        int twoStrike = 2;

        boolean judgement = (boolean) method.invoke(basicBaseballGame, twoStrike);

        assertThat(judgement).isFalse();
    }

    @Test
    @DisplayName("isThreeStrike 메소드에 숫자 3를 입력하면 true를 반환하는지 확인")
    void isThreeStrike_test_with_integer_3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = basicBaseballGame.getClass().getDeclaredMethod("isThreeStrike", int.class);
        method.setAccessible(true);
        int threeStrike = 3;

        boolean judgement = (boolean) method.invoke(basicBaseballGame, threeStrike);

        assertThat(judgement).isTrue();
    }

    @Test
    @DisplayName("receiveUserBall 메소드에 세 자리 숫자가 입력 시, Ball 객체 반환 및 메시지 출력 확인")
    void receiveUserBall_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = basicBaseballGame.getClass().getDeclaredMethod("receiveUserBall");
        method.setAccessible(true);
        String input = "123";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Ball userBall = (Ball) method.invoke(basicBaseballGame);

        assertThat(userBall).isInstanceOf(Ball.class);
        assertThat(outContent.toString()).isEqualTo(PrintMessages.INPUT.getMessage());
    }

    @Test
    @DisplayName("compareComputerBallWith 메소드에 Ball 객체가 입력 시, int 스트라이크 개수 반환 및 메시지 출력 확인")
    void compareComputerBallWith_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = basicBaseballGame.getClass().getDeclaredMethod("compareComputerBallWith", Ball.class, Ball.class);
        method.setAccessible(true);
        Ball computerBall = new Ball("123");
        Ball userBall = new Ball("124");
        int strikeCount = 2;
        String twoStrikeMessage = "2스트라이크\n";

        int strikeReturn = (int) method.invoke(basicBaseballGame, computerBall, userBall);

        assertThat(strikeReturn).isEqualTo(strikeCount);
        assertThat(outContent.toString()).isEqualTo(twoStrikeMessage);
    }
}
