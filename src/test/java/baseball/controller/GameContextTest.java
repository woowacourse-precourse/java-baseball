package baseball.controller;

import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.view.PrintMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class GameContextTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final GameContext gameContext = new GameContext(new BasicBaseballGame());

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("startGame 메소드 게임시작 메시지를 출력하는지 확인")
    void startGame_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("startGame");
        method.setAccessible(true);

        method.invoke(gameContext);

        assertThat(outContent.toString()).isEqualTo(PrintMessages.START.getMessage());
    }

    @Test
    @DisplayName("setComputerBall 메소드가 Ball 객체를 반환하는지 확인")
    void setComputerBall_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("setComputerBall");
        method.setAccessible(true);

        Ball computerBall = (Ball) method.invoke(gameContext);

        assertThat(computerBall).isInstanceOf(Ball.class);
    }

    @Test
    @DisplayName("setComputerBall 메소드를 두 번 호출하면 서로 다른 Ball 객체를 반환하는지 확인")
    void setComputerBall_test_twice() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("setComputerBall");
        method.setAccessible(true);

        Ball firstComputerBall = (Ball) method.invoke(gameContext);
        Ball secondComputerBall = (Ball) method.invoke(gameContext);

        assertThat(firstComputerBall).isNotEqualTo(secondComputerBall);
    }

    @Test
    @DisplayName("initializeStartAction 메소드 멤버변수로 Action.START를 갖는 Action 객체를 반환하는지 확인")
    void initializeStartAction_test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("initializeStartAction");
        method.setAccessible(true);

        Action startAction = (Action) method.invoke(gameContext);

        assertThat(startAction.isStart()).isTrue();
    }

    @Test
    @DisplayName("receiveUserAction 메소드가 \"1\"을 입력 시, START Action 객체 반환 및 메시지 출력 확인")
    void receiveUserAction_test_with_String_1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("receiveUserAction");
        method.setAccessible(true);
        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Action userAction = (Action) method.invoke(gameContext);

        assertThat(userAction.isStart()).isTrue();
        assertThat(outContent.toString()).isEqualTo(PrintMessages.RESTART_OR_END.getMessage());
    }

    @Test
    @DisplayName("receiveUserAction 메소드가 \"2\"을 입력 시, END Action 객체 반환 및 메시지 출력 확인")
    void receiveUserAction_test_with_String_2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("receiveUserAction");
        method.setAccessible(true);
        String input = "2";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Action userAction = (Action) method.invoke(gameContext);

        assertThat(userAction.isStart()).isFalse();
        assertThat(outContent.toString()).isEqualTo(PrintMessages.RESTART_OR_END.getMessage());
    }

    @Test
    @DisplayName("resetComputerBall 메소드가 new Action(Action.START)를 입력받으면 Ball 객체를 반환하는지 확인")
    void resetComputerBall_test_with_start_action() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("resetComputerBall", Action.class);
        method.setAccessible(true);

        Ball computerBall = (Ball) method.invoke(gameContext, new Action(Action.START));

        assertThat(computerBall).isInstanceOf(Ball.class);
    }

    @Test
    @DisplayName("resetComputerBall 메소드가 new Action(Action.END)를 입력받으면 null을 반환하는지 확인")
    void resetComputerBall_test_with_end_action() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = gameContext.getClass().getDeclaredMethod("resetComputerBall", Action.class);
        method.setAccessible(true);

        Ball computerBall = (Ball) method.invoke(gameContext, new Action(Action.END));

        assertThat(computerBall).isNull();
    }
}
