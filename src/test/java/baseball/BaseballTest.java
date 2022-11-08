package baseball;

import baseball.controller.GameController;
import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import baseball.view.PrintMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballTest {

    @Nested
    @DisplayName("GameController 클래스")
    class GameController_test {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final GameController gameController = new GameController();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outContent));
        }

        @Test
        @DisplayName("receiveUserBall 메소드에 세 자리 숫자가 입력 시, Ball 객체 반환 및 메시지 출력 확인")
        void receiveUserBall_test() {
            String input = "123";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            Ball userBall = gameController.receiveUserBall();

            assertThat(userBall).isInstanceOf(Ball.class);
            assertThat(outContent.toString()).isEqualTo(PrintMessages.INPUT.getMessage());
        }

        @Test
        @DisplayName("compareComputerBallWith 메소드에 Ball 객체가 입력 시, int 스트라이크 개수 반환 및 메시지 출력 확인")
        void compareComputerBallWith_test() {
            String input = "123";
            Ball ball = new Ball(input);
            gameController.setComputerBall();

            int strike = gameController.compareComputerBallWith(ball);

            assertThat(strike).isInstanceOf(Integer.class);
            assertThat(outContent.toString()).isNotNull();
        }

        @Test
        @DisplayName("receiveUserAction 메소드가 \"1\"을 입력 시, Action 객체 반환 및 메시지 출력 확인")
        void receiveUserAction_test_with_String_1() {
            String input = "1";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            Action userAction = gameController.receiveUserAction();

            assertThat(userAction).isInstanceOf(Action.class);
            assertThat(outContent.toString()).isNotNull();
        }

        @Test
        @DisplayName("receiveUserAction 메소드가 \"2\"을 입력 시, Action 객체 반환 및 메시지 출력 확인")
        void receiveUserAction_test_String_2() {
            String input = "2";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            Action userAction = gameController.receiveUserAction();

            assertThat(userAction).isInstanceOf(Action.class);
            assertThat(outContent.toString()).isNotNull();
        }

        @Test
        @DisplayName("setComputerBall 메소드가 호출되면 멤버변수를 초기화하는지 확인")
        void setComputerBall_test() throws NoSuchFieldException, IllegalAccessException {
            Field field = gameController.getClass().getDeclaredField("computerBall");
            field.setAccessible(true);

            gameController.setComputerBall();

            assertThat(field.get(gameController)).isInstanceOf(Ball.class);
        }

        @Test
        @DisplayName("setComputerBall 메소드가 두 번 호출되면 멤버변수를 서로 다르게 갖는지 확인")
        void setComputerBall_twice_call_test() throws NoSuchFieldException, IllegalAccessException {
            Field field = gameController.getClass().getDeclaredField("computerBall");
            field.setAccessible(true);

            gameController.setComputerBall();
            Ball firstBall = (Ball) field.get(gameController);
            gameController.setComputerBall();
            Ball secondBall = (Ball) field.get(gameController);

            assertThat(firstBall).isNotEqualTo(secondBall);
        }

        @Test
        @DisplayName("resetComputerBall 메소드가 new Action(Action.START)를 입력받으면 멤버변수를 다시 초기화하는지 확인")
        void resetComputerBall_test_with_start_action() throws NoSuchFieldException, IllegalAccessException {
            Field field = gameController.getClass().getDeclaredField("computerBall");
            field.setAccessible(true);

            gameController.setComputerBall();
            Ball firstBall = (Ball) field.get(gameController);
            gameController.resetComputerBall(new Action(Action.START));
            Ball secondBall = (Ball) field.get(gameController);

            assertThat(firstBall).isNotEqualTo(secondBall);
        }

        @Test
        @DisplayName("resetComputerBall 메소드가 new Action(Action.END)를 입력받으면 멤버변수 그대로인지 확인")
        void resetComputerBall_test_with_end_action() throws NoSuchFieldException, IllegalAccessException {
            Field field = gameController.getClass().getDeclaredField("computerBall");
            field.setAccessible(true);

            gameController.setComputerBall();
            Ball firstBall = (Ball) field.get(gameController);
            gameController.resetComputerBall(new Action(Action.END));
            Ball secondBall = (Ball) field.get(gameController);

            assertThat(firstBall).isEqualTo(secondBall);
        }
    }
}
