package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private List<Integer> playerNumbers;

    public Player() {
        playerNumbers = new ArrayList<>();
    }

    public List<Integer> getNumbers() {
        return playerNumbers;
    }

    public void setNumbers(String playerNumber) {
        this.playerNumbers = toIntegerList(playerNumber);
    }

    private List<Integer> toIntegerList(String playerNumber) {
        return Arrays.stream(playerNumber.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}