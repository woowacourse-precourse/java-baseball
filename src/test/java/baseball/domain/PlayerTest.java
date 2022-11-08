package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.utils.InputValidator;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    private final Player player = new Player(new InputValidator());

    @Test
    public void readBallNumberSuccessTest() throws Exception {
        // given
        String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        player.readBallNumber();

        // then
        assertThat(player.getBallNumber().get(0)).isEqualTo(1);
        assertThat(player.getBallNumber().get(1)).isEqualTo(2);
        assertThat(player.getBallNumber().get(2)).isEqualTo(3);
    }

    @Test
    public void readWeatherReGameTrueSuccessTest() throws Exception {
        // given
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        boolean result = player.readWhetherReGame();

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void readWeatherReGameFalseSuccessTest2() throws Exception {
        // given
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        boolean result = player.readWhetherReGame();

        // then
        assertThat(result).isEqualTo(false);
    }
}
