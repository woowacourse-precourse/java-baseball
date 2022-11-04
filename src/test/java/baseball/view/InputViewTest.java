package baseball.view;

import baseball.model.Ball;
import baseball.model.Balls;
import baseball.model.Result;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    void 숫자_아닌_것_포함_입력_예외_던지기() {
        assertThatThrownBy(() -> {
            InputView.input("1w3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력을_Balls로_변환() {
        Balls balls = InputView.input("123");

        Balls comp = new Balls(List.of(
            new Ball(1, 0)
            , new Ball(2, 1)
            , new Ball(3, 2)
        ));

        assertThat(balls.getResult(comp)).isEqualTo(new Result(0, 3, 0));
    }
}
