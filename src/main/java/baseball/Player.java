package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> playerNumber;

    public Player() {
    }

    public void setNumber() {
        playerNumber = new ArrayList<>();
        for (char c : Console.readLine().toCharArray()) {
            playerNumber.add(Character.getNumericValue(c));
        }
    }
    
    public List<Integer> getNumber() {
        return playerNumber;
    }
}
