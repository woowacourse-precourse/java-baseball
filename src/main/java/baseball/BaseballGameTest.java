package baseball;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

public class BaseballGameTest {
    private final OutputStream out = new ByteArrayOutputStream();

    @Nested
    class announceBallAndStrikeTest {
        @Test
        void case1() {
            Application.ball = 1;
            Application.strike = 2;
            String result = "1볼 2스트라이크";

            System.setOut(new PrintStream(out));
            Application.announceBallAndStrike();

            assertThat(out.toString().trim()).isEqualTo(result);
        }

        @Test
        void case2() {
            Application.ball = 3;
            Application.strike = 0;
            String result = "3볼";

            System.setOut(new PrintStream(out));
            Application.announceBallAndStrike();

            assertThat(out.toString().trim()).isEqualTo(result);
        }

        @Test
        void case3() {
            Application.ball = 0;
            Application.strike = 0;
            String result = "낫싱";

            System.setOut(new PrintStream(out));
            Application.announceBallAndStrike();

            assertThat(out.toString().trim()).isEqualTo(result);
        }
    }

    @Nested
    class setGameStateTest {
        @Test
        void case1() {
            Application.ball = 1;
            Application.strike = 2;
            int result = Application.MIDGAME;

            assertThat(Application.setGameState()).isEqualTo(result);
        }

        @Test
        void case2() {
            Application.ball = 0;
            Application.strike = 3;
            int result = Application.ENDGAME;

            assertThat(Application.setGameState()).isEqualTo(result);
        }
    }

    @Nested
    class findBallAndStrikeTest {
        @Test
        void case1() {
            String userInput = "165";
            List<Integer> answerNumber = List.of(5,4,2);
            Application.ball = 0;
            Application.strike = 0;
            List<Integer> result = List.of(1,0); //1볼
            Application.findBallAndStrike(userInput, answerNumber);

            assertThat(List.of(Application.ball, Application.strike)).isEqualTo(result);
        }

        @Test
        void case2() {
            String userInput = "574";
            List<Integer> answerNumber = List.of(5,4,2);
            Application.ball = 0;
            Application.strike = 0;
            List<Integer> result = List.of(1,1); //1볼 1스트라이크
            Application.findBallAndStrike(userInput, answerNumber);

            assertThat(List.of(Application.ball, Application.strike)).isEqualTo(result);
        }

        @Test
        void case3() {
            String userInput = "542";
            List<Integer> answerNumber = List.of(5,4,2);
            Application.ball = 0;
            Application.strike = 0;
            List<Integer> result = List.of(0,3); //3스트라이크
            Application.findBallAndStrike(userInput, answerNumber);

            assertThat(List.of(Application.ball, Application.strike)).isEqualTo(result);
        }
    }

    @Nested
    class isValidInputNumberTest {
        @Test
        void case1() {
            String userInput = "1234";
            assertThatThrownBy(() -> Application.isValidInputNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case2() {
            String userInput = "121";
            assertThatThrownBy(() -> Application.isValidInputNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case3() {
            String userInput = "370";
            assertThatThrownBy(() -> Application.isValidInputNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void case4() {
            String userInput = "12a";
            assertThatThrownBy(() -> Application.isValidInputNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class isInput1Or2Test {
        @Test
        void case1() {
            String userInput = "y";
            assertThatThrownBy(() -> Application.isValidInputNumber(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
