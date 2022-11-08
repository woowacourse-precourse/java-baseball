package baseball.game;

import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PreparePlayerTest {
    static Player player = new Player();
    static final String DELIMITER="";
    @Test
    public void prepare_Player_Test() throws IOException {

        String userInput="456";
        
        InputStream in = GameTestUtility.generateUserInput(userInput);
        System.setIn(in);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userNumbers = bf.readLine();
        List<Integer> playerNumbers=player.transform(Arrays.asList(userNumbers.split(DELIMITER)), Integer::parseInt);
        assertThat(playerNumbers).isNotEmpty();
    }
}
