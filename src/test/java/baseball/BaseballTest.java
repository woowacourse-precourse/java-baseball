package baseball;

import baseball.controller.GameController;
import baseball.domain.Action;
import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import baseball.view.PrintMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;

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
                            .hasMessageContaining(Ball.EXCEPTION_MESSAGE_FOR_DUPLICATE);
                }
            }
        }

        @Test
        @DisplayName("toString 메소드가 String을 반환하는지 확인")
        void toString_test() {
            String nonDuplicateThreeDigitNumber = "123";
            Ball ball = new Ball(nonDuplicateThreeDigitNumber);

            assertThat(ball.toString()).isEqualTo(nonDuplicateThreeDigitNumber);
        }

        @Nested
        @DisplayName("compareByIndex 메소드는")
        class CompareByIndex_test {
            @Nested
            @DisplayName("숫자가 동일한 Ball 인스턴스가 입력되었을 때")
            class Context_with_identical_number_Ball_instance {
                @Test
                @DisplayName("3을 반환한다.")
                void it_returns_integer_vale_of_3() {
                    String number = "123";

                    Ball ball = new Ball(number);
                    Ball identicalNumberBall = new Ball(number);

                    assertThat(ball.compareByIndex(identicalNumberBall)).isEqualTo(3);
                }
            }

            @Nested
            @DisplayName("숫자가 하나 다른 Ball 인스턴스가 입력되었을 때")
            class Context_with_different_one_number_Ball_instance {
                @Test
                @DisplayName("2를 반환한다.")
                void it_returns_integer_value_of_2() {
                    String number = "123";
                    String differentNumber = "124";
                    Ball ball = new Ball(number);
                    Ball differentNumberBall = new Ball(differentNumber);

                    assertThat(ball.compareByIndex(differentNumberBall)).isEqualTo(2);
                }
            }
        }

        @Nested
        @DisplayName("compareByValue 메소드는")
        class compareByValue_test {
            @Nested
            @DisplayName("Ball 인스턴스가 입력되었을 때")
            class Context_with_Ball_instance {
                @Test
                @DisplayName("포함하는 숫자를 세서 반환한다.")
                void it_returns_count_of_containing_number() {
                    String number = "123";
                    String otherNumber = "512";
                    Ball ball = new Ball(number);
                    Ball otherBall = new Ball(otherNumber);

                    assertThat(ball.compareByValue(otherBall)).isEqualTo(2);
                }
            }
        }
    }

    @Nested
    @DisplayName("Computer 클래스")
    class Computer_test {

        @Nested
        @DisplayName("getComputerRandomNumber 메소드는")
        class getComputerRandomNumber_test {

            private final Computer computer = new Computer();

            @Nested
            @DisplayName("setComputerRandomNumber를 호출하지 않았을 때")
            class Context_without_set_method_call {
                @Test
                @DisplayName("null을 반환한다.")
                void it_returns_null() {
                    assertThat(computer.getComputerRandomNumber()).isNull();
                }
            }

            @Nested
            @DisplayName("setComputerRandomNumber를 한 번 호출하였을 때")
            class Context_with_set_method_call {
                @Test
                @DisplayName("동일한 값을 반환한다.")
                void it_returns_equal_value() {
                    computer.setComputerRandomNumber();
                    Ball computerNumber = computer.getComputerRandomNumber();

                    assertThat(computer.getComputerRandomNumber()).isEqualTo(computerNumber);
                }
            }

            @Nested
            @DisplayName("setComputerRandomNumber를 두 번 호출하였을 때")
            class Context_with_two_set_method_calls {
                @Test
                @DisplayName("서로 다른 값을 반환한다.")
                void it_returns_equal_value() {
                    computer.setComputerRandomNumber();
                    Ball computerNumber = computer.getComputerRandomNumber();

                    computer.setComputerRandomNumber();

                    assertThat(computer.getComputerRandomNumber()).isNotEqualTo(computerNumber);
                }
            }
        }
    }

    @Nested
    @DisplayName("Messenger 클래스")
    class Messenger_test {

        private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        private final Messenger messenger = new Messenger();

        @Test
        @DisplayName("printStartMessage 메소드가 게임 시작 메시지를 출력하는지 확인")
        void printStartMessage_test() {
            System.setOut(new PrintStream(outContent));
            messenger.printStartMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.START.getMessage());
        }

        @Test
        @DisplayName("printInputMessage 메소드가 숫자 입력 메시지를 출력하는지 확인")
        void printInputMessage_test() {
            System.setOut(new PrintStream(outContent));
            messenger.printInputMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.INPUT.getMessage());
        }

        @Test
        @DisplayName("printAnswerMessage 메소드가 정답 메시지를 출력하는지 확인")
        void printAnswerMessage_test() {
            System.setOut(new PrintStream(outContent));
            messenger.printAnswerMessage();

            assertThat(outContent.toString()).isEqualTo(PrintMessages.ANSWER.getMessage());
        }

        @Test
        @DisplayName("printRestartOrEndMessage 메소드가 재시작/종료 메시지를 출력하는지 확인")
        void printRestartOrEndMessage_test() {
            System.setOut(new PrintStream(outContent));
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
                    System.setOut(new PrintStream(outContent));
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
                    System.setOut(new PrintStream(outContent));
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
                    System.setOut(new PrintStream(outContent));
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
                    System.setOut(new PrintStream(outContent));
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

        private final GameController gameController = new GameController();

        @Test
        @DisplayName("receiveUserBall 메소드에 세 자리 숫자가 입력되었을 때 Ball 객체를 반환하는지 확인")
        void receiveUserBall_test() {
            String input = "123";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            assertThat(gameController.receiveUserBall()).isInstanceOf(Ball.class);
        }

        @Test
        @DisplayName("compareComputerBallWith 메소드에 Ball 객체가 입력되었을 때 스트라이크의 개수를 int 값으로 반환하는지 확인")
        void compareComputerBallWith_test() {
            String input = "123";
            Ball ball = new Ball(input);
            gameController.setComputerBall();

            assertThat(gameController.compareComputerBallWith(ball)).isInstanceOf(Integer.class);
        }

        @Test
        @DisplayName("receiveUserAction 메소드가 \"1\"을 입력받으면 Action 객체를 생성해 반환하는지 확인")
        void receiveUserAction_test_with_String_1() {
            String input = "1";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            assertThat(gameController.receiveUserAction()).isInstanceOf(Action.class);
        }

        @Test
        @DisplayName("receiveUserAction 메소드가 \"2\"을 입력받으면 Action 객체를 생성해 반환하는지 확인")
        void receiveUserAction_test_String_2() {
            String input = "2";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);

            assertThat(gameController.receiveUserAction()).isInstanceOf(Action.class);
        }
    }

    @Nested
    @DisplayName("Action 클래스")
    class Action_test {

        @Test
        @DisplayName("생성자에 숫자 1이 입력되었을 때 객체를 생성하는지 확인")
        void constructor_with_integer_1_test() {
            String normalNumber = "1";
            assertThat(new Action(normalNumber)).isInstanceOf(Action.class);
        }

        @Test
        @DisplayName("생성자에 숫자 2가 입력되었을 때 객체를 생성하는지 확인")
        void constructor_with_integer_2_test() {
            String normalNumber = "2";
            assertThat(new Action(normalNumber)).isInstanceOf(Action.class);
        }

        @Test
        @DisplayName("생성자에 숫자 12가 입력되었을 때 예외를 발생시키는지 확인")
        void constructor_with_integer_12_test() {
            String exceptionNumber = "12";
            assertThatThrownBy(() -> new Action(exceptionNumber)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("생성자에 숫자 3이 입력되었을 때 예외를 발생시키는지 확인")
        void constructor_with_integer_3_test() {
            String exceptionNumber = "3";
            assertThatThrownBy(() -> new Action(exceptionNumber)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("isRestart 메소드가 멤버변수 numberAction 으로 \"1\"을 가진 Action 객체를 참조하여 호출하였을 때 true를 반환하는지 확인")
        void isRestart_with_integer_1_test() {
            String numberAction = "1";
            Action actionOf1 = new Action(numberAction);

            assertThat(actionOf1.isStart()).isTrue();
        }

        @Test
        @DisplayName("isRestart 메소드가 멤버변수 numberAction 으로 \"2\"를 가진 Action 객체를 참조하여 호출하였을 때 false를 반환하는지 확인")
        void isRestart_with_integer_2_test() {
            String numberAction = "2";
            Action actionOf2 = new Action(numberAction);

            assertThat(actionOf2.isStart()).isFalse();
        }
    }
}
