package baseball;

import baseball.game.GameManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    void checkRestartGame_메서드_1입력시_true_반환() {

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(GameManager.checkRestartGame()).isEqualTo(true);
    }

    @Test
    void checkRestartGame_메서드_2입력시_false_반환() {

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(GameManager.checkRestartGame()).isEqualTo(false);
    }

    @Test
    void checkRestartGame_메서드_선택옵션이_아닌값_입력시_IllegalArgumentException_발생() {

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> GameManager.checkRestartGame()).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("선택 옵션에 없는 숫자입니다.");
    }
}
