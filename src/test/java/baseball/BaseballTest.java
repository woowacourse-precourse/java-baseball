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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballTest {
    @Nested
    @DisplayName("Ball 클래스")
    class Ball_test {
        @Nested
        @DisplayName("validateForm 메소드는")
        class validateForm_test {
            @Nested
            @DisplayName("세 자리 숫자가 입력되지 않았을 때")
            class Context_with_non_three_digit_number {
                @Test
                @DisplayName("IllegalArgumentException을 발생시킨다.")
                void it_returns_IllegalArgumentException() {
                    String twoDigitNumber = "12";

                    assertThatThrownBy(() -> new Ball(twoDigitNumber))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(Ball.EXCEPTION_MESSAGE_FOR_INVALID_FORM);
                }
            }
        }

        @Nested
        @DisplayName("validateDuplication 메소드는")
        class validateDuplication_test {
            @Nested
            @DisplayName("중복을 갖는 숫자가 입력되었을 때")
            class Context_with_duplicate_number {
                @Test
                @DisplayName("IllegalArgumentException을 발생시킨다.")
                void it_returns_IllegalArgumentException() {
                    String duplicateNumber = "333";

                    assertThatThrownBy(() -> new Ball(duplicateNumber))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(Ball.EXCEPTION_MESSAGE_FOR_DUPLICATION);
                }
            }
        }

        @Test
        @DisplayName("toString 메소드가 String을 반환하는지 확인")
        void toString_test() {
            String nonDuplicateThreeDigitNumber = "123";
            Ball ball = new Ball(nonDuplicateThreeDigitNumber);

            String ballString = ball.toString();

            assertThat(ballString).isEqualTo(nonDuplicateThreeDigitNumber);
        }

        @Nested
        @DisplayName("compareByIndex 메소드는")
        class CompareByIndex_test {
            @Nested
            @DisplayName("각 숫자의 위치와 값이 동일한 Ball 인스턴스가 입력되었을 때")
            class Context_with_same_number_Ball_instance {
                @Test
                @DisplayName("3을 반환한다.")
                void it_returns_integer_vale_of_3() {
                    String number = "123";
                    Ball ball = new Ball(number);
                    Ball sameNumberBall = new Ball(number);

                    int countOfSameNumber = ball.compareByIndex(sameNumberBall);

                    assertThat(countOfSameNumber).isEqualTo(3);
                }
            }

            @Nested
            @DisplayName("각 숫자의 위치와 값이 하나 다른 Ball 인스턴스가 입력되었을 때")
            class Context_with_different_one_number_Ball_instance {
                @Test
                @DisplayName("2를 반환한다.")
                void it_returns_integer_value_of_2() {
                    String number = "123";
                    String differentNumber = "124";
                    Ball ball = new Ball(number);
                    Ball differentNumberBall = new Ball(differentNumber);

                    int countOfSameNumber = ball.compareByIndex(differentNumberBall);

                    assertThat(countOfSameNumber).isEqualTo(2);
                }
            }
        }

        @Nested
        @DisplayName("compareByValue 메소드는")
        class compareByValue_test {
            @Nested
            @DisplayName("위치와 무관하게 숫자가 동일한 Ball 인스턴스가 입력되었을 때")
            class Context_with_same_number_Ball_instance {
                @Test
                @DisplayName("3을 반환한다.")
                void it_returns_integer_value_of_3() {
                    String number = "123";
                    String sameNumber = "312";
                    Ball ball = new Ball(number);
                    Ball sameBall = new Ball(sameNumber);

                    int countOfSameNumber = ball.compareByValue(sameBall);

                    assertThat(countOfSameNumber).isEqualTo(3);
                }
            }

            @Nested
            @DisplayName("위치와 무관하게 숫자가 하나 다른 Ball 인스턴스가 입력되었을 때")
            class Context_with_different_number_Ball_instance {
                @Test
                @DisplayName("2를 반환한다.")
                void it_returns_count_of_containing_number() {
                    String number = "123";
                    String differentNumber = "512";
                    Ball ball = new Ball(number);
                    Ball differentBall = new Ball(differentNumber);

                    int countOfSameNumber = ball.compareByValue(differentBall);

                    assertThat(countOfSameNumber).isEqualTo(2);
                }
            }
        }
    }

    @Nested
    @DisplayName("Computer 클래스")
    class Computer_test {
        private final Computer computer = new Computer();

        @Nested
        @DisplayName("addUniqueString 메소드는")
        class addUniqueString_test {
            @Nested
            @DisplayName("리스트와 리스트에 이미 포함된 문자열을 입력하였을 때")
            class Context_with_list_and_contained_string {
                @Test
                @DisplayName("리스트에 해당 문자열을 add하지 않는다.")
                void it_does_not_add_the_string_into_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
                    Method method = computer.getClass().getDeclaredMethod("addUniqueString", List.class, String.class);
                    method.setAccessible(true);
                    List<String> list = new ArrayList<>(List.of("1", "2", "3"));
                    String containedString = "1";
                    int listSize = list.size();

                    method.invoke(computer, list, containedString);
                    method.invoke(computer, list, containedString);

                    assertThat(list.size()).isEqualTo(listSize);
                }
            }

            @Nested
            @DisplayName("리스트와 리스트에 포함되지 않은 문자열을 입력하였을 때")
            class Context_with_list_and_new_string {
                @Test
                @DisplayName("리스트에 해당 문자열을 add한다.")
                void it_does_not_add_the_string_into_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
                    Method method = computer.getClass().getDeclaredMethod("addUniqueString", List.class, String.class);
                    method.setAccessible(true);
                    List<String> list = new ArrayList<>(List.of("1", "2", "3"));
                    String newString = "4";
                    int listSize = list.size();

                    method.invoke(computer, list, newString);

                    assertThat(list.contains(newString)).isTrue();
                }
            }
        }

        @Test
        @DisplayName("createRandomNumber 메소드가 String 숫자 하나를 반환하는지 확인")
        void createRandomNumber_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = computer.getClass().getDeclaredMethod("createRandomNumber");
            method.setAccessible(true);
            String numberRegularExpression = "\\d";

            String randomNumber = (String) method.invoke(computer);

            assertThat(randomNumber.matches(numberRegularExpression)).isTrue();
        }

        @Test
        @DisplayName("createRandomNumberInLength 메소드에 3을 입력하였을 때 String의 중복이 없는 세 자리 숫자를 반환하는지 확인")
        void createRandomNumberInLength_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = computer.getClass().getDeclaredMethod("createRandomNumberInLength", int.class);
            method.setAccessible(true);
            int lengthOfThree = 3;
            String threeNumberRegularExpression = "\\d{3}";

            String randomNumber = (String) method.invoke(computer, lengthOfThree);

            assertThat(randomNumber.matches(threeNumberRegularExpression)).isTrue();
            assertThat(isContainingDuplication(randomNumber)).isFalse();
        }

        private boolean isContainingDuplication(String number) {
            return number.length() != number.chars()
                    .distinct()
                    .count();
        }

        @Test
        @DisplayName("createRandomBall 메소드가 Ball 객체를 반환하는지 확인")
        void createRandomBall_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = computer.getClass().getDeclaredMethod("createRandomBall");
            method.setAccessible(true);

            Ball randomNumber = (Ball) method.invoke(computer);

            assertThat(randomNumber).isInstanceOf(Ball.class);
        }

        @Test
        @DisplayName("createRandomBall 메소드가 서로 다른 Ball 객체를 반환하는지 확인")
        void createRandomBall_twice_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
            Method method = computer.getClass().getDeclaredMethod("createRandomBall");
            method.setAccessible(true);

            Ball randomNumber = (Ball) method.invoke(computer);
            Ball otherRandomNumber = (Ball) method.invoke(computer);

            assertThat(randomNumber.toString()).isNotEqualTo(otherRandomNumber.toString());
        }
    }

    @Nested
    @DisplayName("Messenger 클래스")
    class Messenger_test {
        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final Messenger messenger = new Messenger();

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outContent));
        }

        @Test
        @DisplayName("printStartMessage 메소드가 게임 시작 메시지를 출력하는지 확인")
        void printStartMessage_test() {
            messenger.printStartMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.START.getMessage());
        }

        @Test
        @DisplayName("printInputMessage 메소드가 숫자 입력 메시지를 출력하는지 확인")
        void printInputMessage_test() {
            messenger.printInputMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.INPUT.getMessage());
        }

        @Test
        @DisplayName("printAnswerMessage 메소드가 정답 메시지를 출력하는지 확인")
        void printAnswerMessage_test() {
            messenger.printAnswerMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.ANSWER.getMessage());
        }

        @Test
        @DisplayName("printRestartOrEndMessage 메소드가 재시작/종료 메시지를 출력하는지 확인")
        void printRestartOrEndMessage_test() {
            messenger.printRestartOrEndMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.RESTART_OR_END.getMessage());
        }

        @Nested
        @DisplayName("printResultMessage 메소드는")
        class printResultMessage_test {
            @Nested
            @DisplayName("1과 0을 입력하였을 때")
            class Context_with_1_strike_and_0_ball {
                @Test
                @DisplayName("\"1스트라이크\"를 반환한다.")
                void it_returns_one_strike_message() {
                    int strike = 1;
                    int ball = 0;
                    String decision = "1스트라이크\n";

                    messenger.printResultMessage(strike, ball);

                    assertThat(outContent.toString()).isEqualTo(decision);
                }
            }

            @Nested
            @DisplayName("0과 3을 입력하였을 때")
            class Context_with_0_strike_and_3_ball {
                @Test
                @DisplayName("\"3볼\"을 반환한다.")
                void it_returns_3_ball_message() {
                    int strike = 0;
                    int ball = 3;
                    String decision = "3볼\n";

                    messenger.printResultMessage(strike, ball);

                    assertThat(outContent.toString()).isEqualTo(decision);
                }
            }

            @Nested
            @DisplayName("2과 1을 입력하였을 때")
            class Context_with_2_strike_and_1_ball {
                @Test
                @DisplayName("\"1볼 2스트라이크\"을 반환한다.")
                void it_returns_1_ball_2_strike_message() {
                    int strike = 2;
                    int ball = 1;
                    String decision = "1볼 2스트라이크\n";

                    messenger.printResultMessage(strike, ball);

                    assertThat(outContent.toString()).isEqualTo(decision);
                }
            }

            @Nested
            @DisplayName("0과 0을 입력하였을 때")
            class Context_with_0_strike_and_0_ball {
                @Test
                @DisplayName("\"낫싱\"을 반환한다.")
                void it_returns_nothing_message() {
                    int strike = 0;
                    int ball = 0;
                    String decision = "낫싱\n";

                    messenger.printResultMessage(strike, ball);

                    assertThat(outContent.toString()).isEqualTo(decision);
                }
            }
        }
    }

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

    @Nested
    @DisplayName("Action 클래스")
    class Action_test {
        @Test
        @DisplayName("생성자에 \"1\"이 입력되었을 때 객체를 생성하는지 확인")
        void constructor_with_String_1_test() {
            String normalNumber = "1";

            assertThat(new Action(normalNumber)).isInstanceOf(Action.class);
        }

        @Test
        @DisplayName("생성자에 \"2\"가 입력되었을 때 객체를 생성하는지 확인")
        void constructor_with_String_2_test() {
            String normalNumber = "2";

            assertThat(new Action(normalNumber)).isInstanceOf(Action.class);
        }

        @Test
        @DisplayName("생성자에 \"12\"가 입력되었을 때 예외를 발생시키는지 확인")
        void constructor_with_String_12_test() {
            String exceptionNumber = "12";

            assertThatThrownBy(() -> new Action(exceptionNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Action.EXCEPTION_MESSAGE_FOR_INVALID_FORM);
        }

        @Test
        @DisplayName("생성자에 \"3\"이 입력되었을 때 예외를 발생시키는지 확인")
        void constructor_with_String_3_test() {
            String exceptionNumber = "3";

            assertThatThrownBy(() -> new Action(exceptionNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(Action.EXCEPTION_MESSAGE_FOR_INVALID_FORM);
        }

        @Test
        @DisplayName("isStart 메소드가 \"1\"을 가진 Action 객체를 참조하여 호출되었을 때 true를 반환하는지 확인")
        void isStart_with_String_1_test() {
            String numberAction = "1";
            Action actionOf1 = new Action(numberAction);

            boolean startAction = actionOf1.isStart();

            assertThat(startAction).isTrue();
        }

        @Test
        @DisplayName("isStart 메소드가 \"2\"를 가진 Action 객체를 참조하여 호출되었을 때 false를 반환하는지 확인")
        void isStart_with_String_2_test() {
            String numberAction = "2";
            Action actionOf2 = new Action(numberAction);

            boolean nonStartAction = actionOf2.isStart();

            assertThat(nonStartAction).isFalse();
        }
    }
}
