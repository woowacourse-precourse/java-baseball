package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> playerNumber;
    Scanner sc = new Scanner(System.in);

    public Player() {
    }

    public void setNumber() {
        playerNumber = new ArrayList<>();
        for (char c : sc.next().toCharArray()) {
            playerNumber.add(Character.getNumericValue(c));
        }
    }
    
    public List<Integer> getNumber() {
        return playerNumber;
    }
}
