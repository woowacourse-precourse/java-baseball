package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    @Test
    public void prepare_Computer_Test(){
        Computer computer = new Computer();
        computer.createRandomNumbers();
        assertThat(computer.getDigits()).isNotEmpty();
    }
    @Test
    public void prepare_Player_Test(){
        Player player = new Player();
        String userInput="456";
        InputStream in = generateUserInput(userInput);
        System.setIn(in);
        player.createNumbers();
        assertThat(player.getDigits()).isNotEmpty();
    }
}
