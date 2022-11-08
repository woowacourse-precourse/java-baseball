package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    static Player player = new Player();
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    public static List<Integer> preparePlayer(String numbers) throws IOException {
        InputStream inPlayer = generateUserInput(numbers);
        System.setIn(inPlayer);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userNumbers = bf.readLine();
        List<Integer> transformedUserNumbers =player.transform(Arrays.asList(userNumbers.split("")), Integer::parseInt);
        return transformedUserNumbers;
    }


}
