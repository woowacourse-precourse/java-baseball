package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

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
}
