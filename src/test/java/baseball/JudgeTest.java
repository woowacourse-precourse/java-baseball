package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class JudgeTest {

    @Test
    @DisplayName("볼이 없을 때")
    void countZeroBallTest() throws Exception {
        //Given
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(4, 5, 6);

        Judge judge = new Judge(answer);

        Method countBall = Judge.class.getDeclaredMethod("countBall", List.class);
        countBall.setAccessible(true);

        //When
        Integer cnt = (Integer) countBall.invoke(judge, guess);

        //Then
        assertThat(cnt).isEqualTo(0);
    }

    @Test
    @DisplayName("볼의 2개 일 때")
    void count2BallTest() throws Exception {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> guess = List.of(3, 2, 5);

        Judge judge = new Judge(answer);

        Method countBall = Judge.class.getDeclaredMethod("countBall", List.class);
        countBall.setAccessible(true);

        //When
        Integer cnt = (Integer) countBall.invoke(judge, guess);

        //Then
        assertThat(cnt).isEqualTo(2);
    }

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