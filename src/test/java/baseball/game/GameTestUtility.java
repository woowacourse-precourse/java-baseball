package baseball.game;

import baseball.player.Player;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GameTestUtility {
    static Player player = new Player();
    public static InputStream generateUserInput(String userInput){
        return new ByteArrayInputStream(userInput.getBytes());
    }
    public static List<Integer> preparePlayer(String numbers) throws IOException {
        InputStream inPlayer = generateUserInput(numbers);
        System.setIn(inPlayer);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String userNumbers = bf.readLine();
        return player.transform(Arrays.asList(userNumbers.split("")), Integer::parseInt);
    }


}
