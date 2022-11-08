package baseball.player.playerMember;

public class Player {

    private final PlayerNumbers playerNumbers;

    protected Player(PlayerNumbers playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public PlayerNumbers getPlayerNumbers() {
        return playerNumbers;
    }
}
