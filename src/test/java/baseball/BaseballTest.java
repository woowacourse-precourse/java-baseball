package baseball;

import baseball.controller.GameController;
import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

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
                    assertThatThrownBy(() -> new Ball(twoDigitNumber)).isInstanceOf(IllegalArgumentException.class);
                }
            }
        }

        @Nested
        @DisplayName("validateDuplication 메소드는")
        class validateDuplication_test {

            @Nested
            @DisplayName("중복을 갖는 숫자가 입력되었을 때")
            class Context_with_duplicated_number {
                @Test
                @DisplayName("IllegalArgumentException을 발생시킨다.")
                void it_returns_IllegalArgumentException() {
                    String duplicatedNumber = "333";
                    assertThatThrownBy(() -> new Ball(duplicatedNumber)).isInstanceOf(IllegalArgumentException.class);
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

            @Nested
            @DisplayName("setComputerRandomNumber를 호출하지 않았을 때")
            class Context_without_set_method_call {
                @Test
                @DisplayName("null을 반환한다.")
                void it_returns_null() {
                    Computer computer = new Computer();
                    assertThat(computer.getComputerRandomNumber()).isNull();
                }
            }

            @Nested
            @DisplayName("setComputerRandomNumber를 한 번 호출하였을 때")
            class Context_with_set_method_call {
                @Test
                @DisplayName("동일한 값을 반환한다.")
                void it_returns_equal_value() {
                    Computer computer = new Computer();
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
                    Computer computer = new Computer();
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
        private final PrintStream originalOut = System.out;
        private final Messenger messenger = new Messenger();

        @Test
        @DisplayName("printStartMessage 메소드가 게임 시작 메시지를 출력하는지 확인")
        void printStartMessage_test() {
            System.setOut(new PrintStream(outContent));

            String startMessage = "게임을 시작합니다.\n";
            messenger.printStartMessage();

            assertThat(outContent.toString()).isEqualTo(startMessage);
            System.setOut(originalOut);
        }

        @Test
        @DisplayName("printInputMessage 메소드가 숫자 입력 메시지를 출력하는지 확인")
        void printInputMessage_test() {
            System.setOut(new PrintStream(outContent));

            String inputMessage = "숫자를 입력하세요. : ";
            messenger.printInputMessage();

            assertThat(outContent.toString()).isEqualTo(inputMessage);
            System.setOut(originalOut);
        }

        @Test
        @DisplayName("printAnswerMessage 메소드가 정답 메시지를 출력하는지 확인")
        void printAnswerMessage_test() {
            System.setOut(new PrintStream(outContent));

            String answerMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
            messenger.printAnswerMessage();

            assertThat(outContent.toString()).isEqualTo(answerMessage);
            System.setOut(originalOut);
        }

        @Test
        @DisplayName("printRestartOrEndMessage 메소드가 재시작/종료 메시지를 출력하는지 확인")
        void printRestartOrEndMessage_test() {
            System.setOut(new PrintStream(outContent));

            String restartOrEndMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
            messenger.printRestartOrEndMessage();

            assertThat(outContent.toString()).isEqualTo(restartOrEndMessage);
            System.setOut(originalOut);
        }

        @Test
        @DisplayName("printResultMessage 메소드가 를 출력하는지 확인")
        void printResultMessage_test() {
            System.setOut(new PrintStream(outContent));

            String restartOrEndMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
            messenger.printRestartOrEndMessage();

            assertThat(outContent.toString()).isEqualTo(restartOrEndMessage);
            System.setOut(originalOut);
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

        @Test
        @DisplayName("receiveBall 메소드는 세 자리 숫자가 입력되었을 때 Ball 객체를 반환하는지 확인")
        void receiveBall_test() {
            String input = "123";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            GameController gameController = new GameController();

            assertThat(gameController.receiveBall()).isInstanceOf(Ball.class);
        }
    }
}