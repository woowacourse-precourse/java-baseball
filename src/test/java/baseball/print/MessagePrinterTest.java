package baseball.print;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static baseball.config.GameConfiguration.DIGITS_FOR_THIS_GAME;
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

    @Nested
    class ball_및_strike_횟수에_대한_메시지가_출력된다 {
        @Test
        void ball과_strike가_섞여있는_경우() {
            int ballCount = DIGITS_FOR_THIS_GAME - 1;
            int strikeCount = DIGITS_FOR_THIS_GAME - ballCount;

            Map<String, Integer> ballAndStrikeCount = Map.of(
                    "ball", ballCount,
                    "strike", strikeCount
            );

            printer.printBallAndStrikeCount(ballAndStrikeCount);
            String result = ballCount + "볼 " + strikeCount + "스트라이크";

            assertThat(result).isEqualTo(outputStream.toString().trim());
        }

       @Nested
       class ball만_있는_경우 {
           @ParameterizedTest
           @ValueSource(ints = {1, 2, DIGITS_FOR_THIS_GAME})
           void ball만_있는_경우(int ballCount) {
               Map<String, Integer> ballAndStrikeCount = Map.of(
                       "ball", ballCount,
                       "strike", 0
               );

               printer.printBallAndStrikeCount(ballAndStrikeCount);
               String result = ballCount + "볼";
               assertThat(result).isEqualTo(outputStream.toString().trim());
           }
       }

        @Nested
        class strike만_있는_경우 {
            @ParameterizedTest
            @ValueSource(ints = {1, 2, DIGITS_FOR_THIS_GAME})
            void strike만_있는_경우(int strikeCount) {
                Map<String, Integer> ballAndStrikeCount = Map.of(
                        "ball", 0,
                        "strike", strikeCount
                );

                printer.printBallAndStrikeCount(ballAndStrikeCount);
                String result = strikeCount + "스트라이크";
                assertThat(result).isEqualTo(outputStream.toString().trim());
            }
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
}