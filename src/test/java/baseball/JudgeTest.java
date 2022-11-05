package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class JudgeTest {

    @Nested
    class StrikeTest {
        @Test
        void countStrike_WhenStrikeIsZero() {
            List<Integer> userNumbers = Arrays.asList(4,5,6);
            List<Integer> computerNumbers = Arrays.asList(1,2,3);
            int strikeCnt = Judge.countStrike(userNumbers, computerNumbers);
            assertThat(strikeCnt).isEqualTo(0);
        }

        @Test
        void countStrike_WhenStrikeIsNotZero() {
            List<Integer> userNumbers = Arrays.asList(4,5,6);
            List<Integer> computerNumbers = Arrays.asList(4,5,8);
            int strikeCnt = Judge.countStrike(userNumbers, computerNumbers);
            assertThat(strikeCnt).isEqualTo(2);
        }
    }

    @Nested
    class BallTest {
        @Test
        void countBall_WhenBallIsZero() {
            List<Integer> userNumbers = Arrays.asList(1,2,3);
            List<Integer> computerNumbers = Arrays.asList(4,5,6);
            int strikeCnt = Judge.countBall(userNumbers, computerNumbers);
            assertThat(strikeCnt).isEqualTo(0);
        }

        @Test
        void countBall_WhenBallIsOne() {
            List<Integer> userNumbers = Arrays.asList(1,2,3);
            List<Integer> computerNumbers = Arrays.asList(5,1,6);
            int strikeCnt = Judge.countBall(userNumbers, computerNumbers);
            assertThat(strikeCnt).isEqualTo(1);
        }

        @Test
        void countBall_WhenBallIsTwo() {
            List<Integer> userNumbers = Arrays.asList(1,2,3);
            List<Integer> computerNumbers = Arrays.asList(3,1,2);
            int strikeCnt = Judge.countBall(userNumbers, computerNumbers);
            assertThat(strikeCnt).isEqualTo(3);
        }

        @Test
        void countBall_WhenBallIsThree() {
            List<Integer> userNumbers = Arrays.asList(7,3,5);
            List<Integer> computerNumbers = Arrays.asList(5,7,3);
            int strikeCnt = Judge.countBall(userNumbers, computerNumbers);
            assertThat(strikeCnt).isEqualTo(3);
        }
    }
}