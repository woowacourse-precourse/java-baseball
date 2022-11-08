package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    static Computer computer = new Computer();
    static Player player = new Player();
    static Player opponent = new Player();
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    public static void preparePlayer(Player player, String numbers){
        InputStream inPlayer = generateUserInput(numbers);
        System.setIn(inPlayer);
        player.createNumbers();
    }


}
