package baseball.domain;

import java.util.List;

public class Player {

    private List<Integer> playerInput;

    public Player(List<Integer> playerInput) {
        this.playerInput = playerInput;
    }

    public List<Integer> getPlayerInput() {
        return playerInput;
    }
}
