package baseball.player.playerMember;

public class PlayerNumber {

    private final int playerNumber;

    public PlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o instanceof PlayerNumber) {
            return this.playerNumber == ((PlayerNumber) o).playerNumber;
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return playerNumber;
    }
}
