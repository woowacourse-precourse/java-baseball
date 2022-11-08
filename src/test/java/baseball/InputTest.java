package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InputTest {

    @Test
    public void readNumber_메서드로_숫자를_입력받는_기능() {
        BaseballGameNumber expected = new BaseballGameNumber(List.of(1, 2, 3));

        command("123");
        BaseballGameNumber actual = Input.readNumber();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void readNumber_메서드_사용시_공백이_포함된_문자는_허용() {
        BaseballGameNumber expected = new BaseballGameNumber(List.of(1, 2, 3));

        command("  1   2 3    ");
        BaseballGameNumber actual = Input.readNumber();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void readNumber_메서드_사용시_숫자가_아닌_문자가_포함되는_경우() {
        assertThatThrownBy(() -> {
            command("S25");
            Input.readNumber();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 문자가 포함되었습니다.");
    }

    @Test
    public void readGameStatus_메서드로_게임_재시작을_입력받는_경우() {
        command("1");
        GameStatus gameStatus = Input.readGameStatus();

        assertThat(gameStatus).isEqualTo(GameStatus.RESTART);
    }

    @Test
    public void readGameStatus_메서드로_게임종료를_입력받는_경우() {
        command("2");
        GameStatus gameStatus = Input.readGameStatus();

        assertThat(gameStatus).isEqualTo(GameStatus.GAME_OVER);
    }

    @Test
    public void readGameStatus_메서드_사용시_1또는2_외의_입력을_받는_경우() {
        assertThatThrownBy(() -> {
            command("5");
            GameStatus gameStatus = Input.readGameStatus();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 값이 입력되었습니다.");
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
