package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Integer> inputPlayerNumber() {
        String playerNumber = Console.readLine();
        return stringToList(playerNumber);
    }

    private List<Integer> stringToList(String playerInput) {
        List<Integer> playerNumber = new ArrayList<>();
        for (int i = 0; i < playerInput.length(); i++) {
            char current = playerInput.charAt(i);
            playerNumber.add(Character.getNumericValue(current));
        }
        return playerNumber;
    }
}
