package baseball.Game;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgeTest {

    @Nested
    class StrikeTest {
        @Test
        void countStrike_WhenStrikeIsZero() {
            List<Integer> userNumbers = Arrays.asList(4, 5, 6);
            List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
            Judge judge = new Judge(userNumbers, computerNumbers);
            int strikeCnt = judge.countStrike();
            assertThat(strikeCnt).isEqualTo(0);
        }

        @Test
        void countStrike_WhenStrikeIsNotZero() {
            List<Integer> userNumbers = Arrays.asList(4, 5, 6);
            List<Integer> computerNumbers = Arrays.asList(4, 5, 8);
            Judge judge = new Judge(userNumbers, computerNumbers);
            int strikeCnt = judge.countStrike();
            assertThat(strikeCnt).isEqualTo(2);
        }
    }

    @Nested
    class BallTest {
        @Test
        void countBall_WhenBallIsZero() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 3);
            List<Integer> computerNumbers = Arrays.asList(4, 5, 6);
            Judge judge = new Judge(userNumbers, computerNumbers);
            int strikeCnt = judge.countBall();
            assertThat(strikeCnt).isEqualTo(0);
        }

        @Test
        void countBall_WhenBallIsOne() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 3);
            List<Integer> computerNumbers = Arrays.asList(5, 1, 6);
            Judge judge = new Judge(userNumbers, computerNumbers);
            int strikeCnt = judge.countBall();
            assertThat(strikeCnt).isEqualTo(1);
        }

        @Test
        void countBall_WhenBallIsTwo() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 3);
            List<Integer> computerNumbers = Arrays.asList(3, 1, 2);
            Judge judge = new Judge(userNumbers, computerNumbers);
            int strikeCnt = judge.countBall();
            assertThat(strikeCnt).isEqualTo(3);
        }

        @Test
        void countBall_WhenBallIsThree() {
            List<Integer> userNumbers = Arrays.asList(7, 3, 5);
            List<Integer> computerNumbers = Arrays.asList(5, 7, 3);
            Judge judge = new Judge(userNumbers, computerNumbers);
            int strikeCnt = judge.countBall();
            assertThat(strikeCnt).isEqualTo(3);
        }
    }

    @Nested
    class PrintResultTest {
        @Test
        void printRoundScore_WhenAllZero() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 4);
            List<Integer> computerNumbers = Arrays.asList(5, 6, 7);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Judge judge = new Judge(userNumbers, computerNumbers);
            judge.printRoundScore();
            assertThat(out.toString()).isEqualTo("낫싱" + System.lineSeparator());
        }

        @Test
        void printRoundScore_WhenStrikeNotZero() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 4);
            List<Integer> computerNumbers = Arrays.asList(1, 6, 7);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Judge judge = new Judge(userNumbers, computerNumbers);
            judge.printRoundScore();
            assertThat(out.toString()).isEqualTo("1스트라이크" + System.lineSeparator());
        }

        @Test
        void printRoundScore_WhenBallNotZero() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 4);
            List<Integer> computerNumbers = Arrays.asList(4, 1, 7);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Judge judge = new Judge(userNumbers, computerNumbers);
            judge.printRoundScore();
            assertThat(out.toString()).isEqualTo("2볼" + System.lineSeparator());
        }

        @Test
        void printRoundScore_WhenStrikeBallNoneOfZero() {
            List<Integer> userNumbers = Arrays.asList(1, 2, 4);
            List<Integer> computerNumbers = Arrays.asList(1, 4, 2);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            Judge judge = new Judge(userNumbers, computerNumbers);
            judge.printRoundScore();
            assertThat(out.toString()).isEqualTo("2볼 1스트라이크" + System.lineSeparator());
        }
    }
}