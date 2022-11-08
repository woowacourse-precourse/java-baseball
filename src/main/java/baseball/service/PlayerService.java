package baseball.service;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    public static List<Integer> generatePlayerNumber(String scanNumber) {
        List<String> number = new ArrayList<>();
        List<Integer> playerNumber = new ArrayList<>();

        for(int i = 0; i < scanNumber.length(); i++) {
            number.add(scanNumber.substring(i, i+1));
        }
        for (String currentNumber : number) {
            playerNumber.add(Integer.parseInt(currentNumber));
        }
        return playerNumber;
    }
}
