package baseball;

import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Integer> playerNumber;
    Scanner sc = new Scanner(System.in);

    public Player() {
    }

    public void setNumber() {
        for (char c : sc.next().toCharArray()) {
            playerNumber.add(Integer.valueOf(c));
        }
    }
    public List<Integer> getNumber() {
        return playerNumber;
    }
}
