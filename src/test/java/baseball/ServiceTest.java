package baseball;

import baseball.model.BallCount;
import baseball.service.BallCountService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class ServiceTest {
    @Test
    void 스크라이크_수_계산() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> userAnswer = List.of(1, 2, 5);
        BallCountService ballCountService = new BallCountService();
        Method method = null;
        try {
            method = ballCountService.getClass().getDeclaredMethod("countStrike", List.class, List.class);
            method.setAccessible(true);
            int strike = (int) method.invoke(ballCountService, answer, userAnswer);
            assertThat(strike).isEqualTo(2);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 볼_수_계산() {
        List<Integer> answer = List.of(1, 5, 3);
        List<Integer> userAnswer = List.of(3, 2, 5);
        BallCountService ballCountService = new BallCountService();
        Method method = null;
        try {
            method = ballCountService.getClass().getDeclaredMethod("countBall", List.class, List.class);
            method.setAccessible(true);
            int ball = (int) method.invoke(ballCountService, answer, userAnswer);
            assertThat(ball).isEqualTo(2);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 볼카운트_계산() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> userAnswer = List.of(3, 2, 5);
        BallCountService ballCountService = new BallCountService();
        BallCount ballCount = ballCountService.calc(answer, userAnswer);
        assertThat(ballCount.toString()).isEqualTo(new BallCount(1, 1).toString());
    }
}
