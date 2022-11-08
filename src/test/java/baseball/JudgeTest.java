package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgeTest {





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