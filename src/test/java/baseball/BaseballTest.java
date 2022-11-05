package baseball;

import baseball.domain.Ball;
import baseball.model.Computer;
import baseball.view.Messenger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
        @DisplayName("printStartMessage 메소드가 게임시작 메시지를 출력하는지 확인")
        void printStartMessage_test() {
            System.setOut(new PrintStream(outContent));

            String startMessage = "게임을 시작합니다.\n";
            messenger.printStartMessage();

            assertThat(outContent.toString()).isEqualTo(startMessage);
            System.setOut(originalOut);
        }
    }
}