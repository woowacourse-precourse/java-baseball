package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberBaseballGameTest {

    final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUpOut() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void 게임_시작_문구를_출력한다() {
        BaseballGame baseballGame = new BaseballGame();
        String result = "숫자 야구 게임을 시작합니다.";

        baseballGame.playGame();

        assertThat(outputStream.toString().trim()).isEqualTo(result);
    }

    @Test
    void 특정_숫자와_순서를_가진_공을_하나_생성한다() {
        Ball ball = new Ball(1, 0);

        assertThat(ball).isInstanceOf(Ball.class);
    }

    @Test
    void 특정_숫자와_순서를_가진_공에서_숫자를_체크() throws NoSuchFieldException, IllegalAccessException {
        Ball ball = new Ball(3, 0);
        int result = 3;

        Field field = ball.getClass().getDeclaredField("number");
        field.setAccessible(true);
        int number = field.getInt(ball);

        assertThat(number).isEqualTo(result);
    }

    @Test
    void 특정_숫자와_순서를_가진_꽁에서_순서를_체크() throws NoSuchFieldException, IllegalAccessException {
        Ball ball = new Ball(1, 2);
        int result = 2;

        Field field = ball.getClass().getDeclaredField("order");
        field.setAccessible(true);
        int order = field.getInt(ball);

        assertThat(order).isEqualTo(result);
    }

    @Test
    void 랜덤한_1과_9사이의_숫자를_하나_생성한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Pitcher pitcher = new Pitcher();

        Method method = pitcher.getClass().getDeclaredMethod("getNotDuplicatedRandomNumber");
        method.setAccessible(true);
        int number = (int) method.invoke(pitcher);

        assertThat(number).isGreaterThan(0).isLessThan(10);
    }

    @Test
    void 투수가_랜덤한_1과_9사이의_숫자와_순서를_가진_공을_하나_생성한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Pitcher pitcher = new Pitcher();

        Method method = pitcher.getClass().getDeclaredMethod("throwRandomBall", int.class);
        method.setAccessible(true);
        Object ball = method.invoke(pitcher, 3);

        assertThat(ball).isInstanceOf(Ball.class);
    }

    @Test
    void 투수가_생성한_공에_1과_9사이의_숫자가_있는지_확인() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Pitcher pitcher = new Pitcher();

        Method method = pitcher.getClass().getDeclaredMethod("throwRandomBall", int.class);
        method.setAccessible(true);
        Ball ball = (Ball) method.invoke(pitcher, 3);

        assertThat(ball.getNumber()).isInstanceOf(Integer.class).isGreaterThan(0).isLessThan(10);
    }

    @Test
    void 서로_다른_1과_9사이의_랜덤_숫자를_가진_공_3개를_생성한다() {
        Pitcher pitcher = new Pitcher();

        List<Ball> balls = pitcher.throwRandomBalls(3);

        assertThat(balls.size()).isEqualTo(3);
    }

    @Test
    void 투수가_생성한_공_3개의_숫자가_모두_다른지_확인() {
        Pitcher pitcher = new Pitcher();
        List<Integer> checkList = new ArrayList<>(List.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        List<Ball> balls = pitcher.throwRandomBalls(3);

        balls.stream()
                .peek(ball -> System.out.println(ball.getNumber()))
                .forEach(ball -> {
                    assertThat(checkList.get(ball.getNumber())).isEqualTo(0);
                    checkList.set(ball.getNumber(), 1);
                });
    }

    @Test
    void 입력된_수에서_특정_숫자의_개수를_가져온다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BaseballGame baseballGame = new BaseballGame();
        int result = 1;

        Method method = baseballGame.getClass().getDeclaredMethod("getDigitCount", String.class, int.class);
        method.setAccessible(true);
        long digitCount = (long) method.invoke(baseballGame, "123", 3);

        assertThat(digitCount).isEqualTo(result);
    }

    @Test
    void 입력_길이가_3이_아니면_예외가_발생한다() throws NoSuchMethodException, IllegalAccessException {
        BaseballGame baseballGame = new BaseballGame();

        Method method = baseballGame.getClass().getDeclaredMethod("validateNumberLength", String.class);
        method.setAccessible(true);

        try {
            method.invoke(baseballGame, "1234");
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 입력_값이_1과_9사이의_숫자가_아니면_예외가_발생한다() throws NoSuchMethodException, IllegalAccessException {
        BaseballGame baseballGame = new BaseballGame();

        Method method = baseballGame.getClass().getDeclaredMethod("validateNumberLength", String.class);
        method.setAccessible(true);

        try {
            method.invoke(baseballGame, "120");
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 중복된_숫자가_있으면_예외가_발생한다() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BaseballGame baseballGame = new BaseballGame();

        Method method = baseballGame.getClass().getDeclaredMethod("validateNumberDuplication", String.class);
        method.setAccessible(true);

        try {
            method.invoke(baseballGame, "133");
        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 중복된_숫자가_없는_1과_9사이의_3자리_숫자면_예외가_발생하지_않는다() throws NoSuchMethodException {
        BaseballGame baseballGame = new BaseballGame();

        Method method = baseballGame.getClass().getDeclaredMethod("validate", String.class);
        method.setAccessible(true);

        assertThatNoException().isThrownBy(() ->
                method.invoke(baseballGame, "123"));
    }

    @Test
    void 예외가_발생하지_않으면_입력된_값을_반환한다() throws IOException {
        BaseballGame baseballGame = new BaseballGame();
        String input = "234";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        String number = baseballGame.inputNumber();

        assertThat(number).isEqualTo(input);
    }
}
