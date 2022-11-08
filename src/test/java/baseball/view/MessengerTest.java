package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class MessengerTest {
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