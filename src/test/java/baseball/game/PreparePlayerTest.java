package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PreparePlayerTest {
    static Player player = new Player();
    @Test
    public void prepare_Player_Test(){

        String userInput="456";
        InputStream in = GameTest.generateUserInput(userInput);
        System.setIn(in);
        player.createNumbers();
        assertThat(player.getDigits()).isNotEmpty();
    }
}
