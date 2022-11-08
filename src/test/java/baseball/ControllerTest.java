package baseball;

import baseball.controller.BaseBallGameController;
import baseball.service.BallCountService;
import baseball.util.ArgumentExceptionMessage;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class ControllerTest {
    @Test
    void 게임_재시작_true() {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BallCountService());
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean restart = baseBallGameController.isRestart();
        assertThat(restart).isEqualTo(true);
    }

    @Test
    void 게임_재시작_false() {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BallCountService());
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean restart = baseBallGameController.isRestart();
        assertThat(restart).isEqualTo(false);
    }

    @Test
    void 예외처리_게임_재시작() {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BallCountService());
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(baseBallGameController::isRestart)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ArgumentExceptionMessage.COMMAND_NOT_FOUND.getMessage());
    }

    @Test
    void 게임_종료여부_판단_true() {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BallCountService());
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> userAnswer = List.of(1, 2, 3);
        boolean finish = baseBallGameController.isFinish(answer, userAnswer);
        assertThat(finish).isEqualTo(true);
    }

    @Test
    void 게임_종료여부_판단_false() {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BallCountService());
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> userAnswer = List.of(1, 3, 2);
        boolean finish = baseBallGameController.isFinish(answer, userAnswer);
        assertThat(finish).isEqualTo(false);
    }

    @Test
    void 문자열_숫자_리스트로_변환() {
        BaseBallGameController baseBallGameController = new BaseBallGameController(new BallCountService());
        Method method = null;
        try {
            method = baseBallGameController.getClass().getDeclaredMethod("toIntegerList", String.class);
            method.setAccessible(true);
            Object integerList = method.invoke(baseBallGameController, "123");
            assertThat(integerList).isEqualTo(List.of(1,2,3));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

