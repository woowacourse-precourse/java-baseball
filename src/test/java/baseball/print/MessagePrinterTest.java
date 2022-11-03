package baseball.print;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MessagePrinterTest {

    private final MessagePrinter printer = new MessagePrinter();

    private final PrintStream printStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));  // 출력 스트림 재할당
    }

    @AfterEach
    void tearDown() {
        System.setOut(printStream);
    }

    @Test
    void 게임_시작_메시지가_출력된다() {
        printer.printStartMessage();
        String result = "숫자 야구 게임을 시작합니다.";
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void 숫자_입력_요청_메시지가_출력된다() {
        printer.printEnterNumberMessage();
        String result = "숫자를 입력해주세요 :";
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

    @Nested
    class ball_및_strike_횟수에_대한_메시지가_출력된다 {
        @Test
        void ball과_strike가_섞여있는_경우() {
            Map<String, Integer> ballAndStrikeCount = Map.of(
                    "ball", 2,
                    "strike", 1
            );

            printer.printBallAndStrikeCount(ballAndStrikeCount);
            String result = "2볼 1스트라이크";
            assertThat(result).isEqualTo(outputStream.toString().trim());
        }

        @Test
        void ball만_3개인_경우() {
            Map<String, Integer> ballAndStrikeCount = Map.of(
                    "ball", 3,
                    "strike", 0
            );

            printer.printBallAndStrikeCount(ballAndStrikeCount);
            String result = "3볼";
            assertThat(result).isEqualTo(outputStream.toString().trim());
        }

        @Test
        void strike만_3개인_경우() {
            Map<String, Integer> ballAndStrikeCount = Map.of(
                    "ball", 0,
                    "strike", 3
            );

            printer.printBallAndStrikeCount(ballAndStrikeCount);
            String result = "3스트라이크";
            assertThat(result).isEqualTo(outputStream.toString().trim());
        }

        @Test
        void 아무것도_못_맞춘_경우() {
            Map<String, Integer> ballAndStrikeCount = Map.of(
                    "ball", 0,
                    "strike", 0
            );

            printer.printBallAndStrikeCount(ballAndStrikeCount);
            String result = "낫싱";
            assertThat(result).isEqualTo(outputStream.toString().trim());
        }
    }

    @Test
    void 정답임을_알리는_메시지가_출력된다() {
        printer.printCorrectAnswerMessage();
        String result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

    @Test
    void 게임_재시작_안내_메시지가_출력된다() {
        printer.printRestartMessage();
        String result = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

}