package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgeTest {



    @Nested
    @DisplayName("스크라이크 갯수를 찾는 메소드")
    class countStrike {
        @Test
        @DisplayName("스트라이크가 없을 때")
        void countNoStrike() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(3, 1, 2);

            Judge judge = new Judge(answer);

            Method countStrike = Judge.class.getDeclaredMethod("countStrike", List.class);
            countStrike.setAccessible(true);

            //When
            Integer cnt = (Integer) countStrike.invoke(judge, guess);

            //Then
            assertThat(cnt).isEqualTo(0);
        }

        @Test
        @DisplayName("스트라이크가 2개일 때")
        void count2Strike() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(6, 2, 3);

            Judge judge = new Judge(answer);

            Method countStrike = Judge.class.getDeclaredMethod("countStrike", List.class);
            countStrike.setAccessible(true);

            //When
            Integer cnt = (Integer) countStrike.invoke(judge, guess);

            //Then
            assertThat(cnt).isEqualTo(2);
        }

        @Test
        @DisplayName("스트라이크가 3개일 때")
        void countAllStrike() throws Exception {
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(1, 2, 3);

            Judge judge = new Judge(answer);

            Method countStrike = Judge.class.getDeclaredMethod("countStrike", List.class);
            countStrike.setAccessible(true);

            //When
            Integer cnt = (Integer) countStrike.invoke(judge, guess);

            //Then
            assertThat(cnt).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("판단한 결과를 반환하는 메서드")
    class judgeUserGuess {

        @Test
        @DisplayName("일치하는 것이 없을 때")
        void noMatching() throws Exception {
            //Given
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(4, 5, 6);

            Judge judge = new Judge(answer);
            //When
            List<Integer> result = judge.judgeUserGuess(guess);

            //Then
            assertThat(result).isEqualTo(List.of(0, 0));
        }

        @Test
        @DisplayName("볼만 있을 때")
        void onlyBall() throws Exception {
            //Given
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(3, 1, 5);

            Judge judge = new Judge(answer);
            //When
            List<Integer> result = judge.judgeUserGuess(guess);

            //Then
            assertThat(result).isEqualTo(List.of(2, 0));
        }

        @Test
        @DisplayName("스트라이크만 있을 때")
        void onlyStrike() throws Exception {
            //Given
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(1, 2, 3);

            Judge judge = new Judge(answer);
            //When
            List<Integer> result = judge.judgeUserGuess(guess);

            //Then
            assertThat(result).isEqualTo(List.of(0, 3));
        }

        @Test
        @DisplayName("스트라이크, 볼 둘다 있을 때")
        void mixedResult() throws Exception {
            //Given
            List<Integer> answer = List.of(1, 2, 3);
            List<Integer> guess = List.of(1, 3, 2);

            Judge judge = new Judge(answer);
            //When
            List<Integer> result = judge.judgeUserGuess(guess);

            //Then
            assertThat(result).isEqualTo(List.of(2, 1));
        }
    }
}